package com.imxiaomai.base.util;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.imxiaomai.base._.regex;
import static com.imxiaomai.base._.trimToEmpty;

/** 主要用于基于反射的通用后门 */
public class HackUtil {

	public static String hack(String cmd) {
		for (Pattern pattern : assignPatterns) {
			Matcher m = pattern.matcher(cmd);
			if (m.matches())
				return setProperty(m.group(1), m.group(2), m.group(3));
		}
		return "invalid expression";
	}
	static final Pattern[] assignPatterns = {
			regex("^([\\w.]+?)\\s*::\\s*([\\w]+?)\\s*=\\s*(.*)"),
			regex("^([\\w.]+?)\\s*.\\s*([\\w]+?)\\s*=\\s*(.*)")
	};

	public static String setProperty(String className, String key, String val) {
		final Class<?> clazz;
		try {
			clazz = Class.forName(className);
		} catch (Exception e) {
			return "find class err: " + e;
		}

		final Field field;
		try {
			field = clazz.getDeclaredField(key);
			field.setAccessible(true);
		} catch (Exception e) {
			return "find field err: " + e;
		}

		try {
			Class<?> type = field.getType();
			Object from, to;
			if (type.isAssignableFrom(boolean.class)) {
				val = trimToEmpty(val).toLowerCase();
				boolean v = val.equals("on") || val.equals("true") || val.equals("ture") || val.equals("yes")
						|| val.equals("1");
				from = field.getBoolean(null) ? "on" : "off";
				to = v ? "on" : "off";
				field.setBoolean(null, v);
			} else if (type.isAssignableFrom(int.class)) {
				int v = Integer.parseInt(trimToEmpty(val));
				from = field.getInt(null);
				to = v;
				field.setInt(null, v);
			} else if (type.isAssignableFrom(long.class)) {
				long v = Long.parseLong(trimToEmpty(val));
				from = field.getLong(null);
				to = v;
				field.setLong(null, v);
			} else if (type.isAssignableFrom(float.class)) {
				float v = Float.parseFloat(trimToEmpty(val));
				from = field.getLong(null);
				to = v;
				field.setFloat(null, v);
			} else if (type.isAssignableFrom(double.class)) {
				double v = Double.parseDouble(trimToEmpty(val));
				from = field.getDouble(null);
				to = v;
				field.setDouble(null, v);
			} else {
				return "unsupported type: " + type;
			}
			return String.format("set %s#%s from %s to %s", className, key, from, to);
		} catch (Exception e) {
			return "set field err: " + e;
		}
	}

}
