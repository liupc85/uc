package com.imxiaomai.base.infrastructure;

import com.imxiaomai.base.util.HackUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.imxiaomai.base._.*;
import static com.imxiaomai.base.infrastructure.ConfigHelper.loadServletContext;


/**
 * 项目中通常都有大量的可配置项，如：各种依赖服务的地址、一些服务需要的参数等。
 * 此类的考虑是：希望能集中web项目或单模块的所有配置，相关代码对OP仍具有可读性，可供线上环境配置参考。
 * 使用方式参考：
 * http://svn.sogou-inc.com/svn/mobilesearch/trunk/zhidao/front/web/src/main/java/com/sogou/wen/main.pay.com.imxiaomai.base/keys/Configs.java
 *
 * bugfix(2013-9): 将读取外部文件时的Properties类改为LinkedProperties。
 * 原因：Properties类是HashTable，并不按配置文件中的顺序执行，可能造成hack等出现意外情况
 */
public final class Config {

	static final Logger logger = LoggerFactory.getLogger(Config.class);

	/* ------------------------- api ------------------------- */

	// syntax sugar
	public static Config of(String key, String defVal) {
		return new Config(key, defVal);
	}

	// instance
	public final String key;
	public String defVal;
	Config(String key, String defVal) {
		this.key = key;
		this.defVal = defVal;
	}

	// storage
	static final ConcurrentHashMap<String, String> configs = new ConcurrentHashMap<String, String>();
	public String get() {
		String val = configs.get(key);
		return val != null ? val : defVal;
	}
	public void set(String val) {
		configs.put(this.key, val);
	}
	static void set(String key, String val) {
		configs.put(key, val);
	}

	/* ------------------------- util.load ------------------------- */

	// load config file
	public static void load(Properties p) {
		for (Map.Entry<Object, Object> entry : p.entrySet()) {
			String key = String.valueOf(entry.getKey());
			String val = String.valueOf(entry.getValue());

			// 这里是这样考虑的：
			// 如果希望“以配置形式，设置内部参数”，可以写这样的配置
			// hack_wait_more_time_for_recommend_debug=com.sogou.wen.main.pay.com.imxiaomai.base.keys.Constants::recommendWaitTime=3000
			// ！需注意，这种方式可能导致相关类提前加载，建议仅在外部配置文件中使用，且写在文件最后
			if (key.startsWith("hack")) {
				String ret = HackUtil.hack(val);
				logger.info(f("hack: %s => %s", val, ret));
			} else {
				set(key, val);
				logger.info(f("conf: %s = %s", key, val));
			}
		}
	}
	public static void load(ServletContext ctx) {
		loadServletContext(ctx);
	}
	public static String webConfContextKey = "config.properties.file";
	public static String webConfDefault = "../conf/web.conf";

	static final class LinkedProperties extends Properties {
		Map<Object, Object> linkedMap = new LinkedHashMap<Object, Object>();
		@Override
		public synchronized Object put(Object key, Object value) {
			return linkedMap.put(key, value);
		}
		@Override
		public Set<Map.Entry<Object, Object>> entrySet() {
			return linkedMap.entrySet();
		}
	}

	/* ------------------------- util.misc ------------------------- */

	/** 针对我们经常使用的0@xxx风格配置，简化之。代码中可简写为shards("cache01~04.wenda.yf") */
	public static String shards(String expression) {
		List<String> shards = new ArrayList<String>();
		addShards(shards, expression);
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < shards.size(); i++)
			out.append(f(" %d@%s", i, shards.get(i)));
		return out.toString().trim();
	}
	private static void addShards(List<String> shards, String expression) {
		expression = trimToEmpty(expression);
		if (isEmpty(expression))
			return;
		if (expression.contains(",")) {
			for (String token : expression.split(","))
				addShards(shards, token);
			return;
		}
		if (expression.contains("~")) {
			Matcher m = Pattern.compile("^(\\w+?)(\\d+)~(\\d+)(.*)$").matcher(expression);
			if (!m.matches())
				return;
			for (int i = toInt(m.group(2)); i <= toInt(m.group(3)); i++) {
				String host = m.group(1) + f("%0" + m.group(2).length() + "d", i) + m.group(4);
				addShards(shards, host);
			}
			return;
		}
		shards.add(expression);
	}

	// for data dir
	public static final Config dataDir = of("data_dir", "/search/odin/data/"); //
	public static String dataFile(String filename) {
		String dir = dataDir.get();
		return dir + (dir.endsWith("/") ? "" : "/") + filename;
	}

}
