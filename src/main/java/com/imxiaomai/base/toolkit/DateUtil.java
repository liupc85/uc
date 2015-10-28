package com.imxiaomai.base.toolkit;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String addDay(String day, String pattern, int offsetDay) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = sdf.parse(day);
		return new DateTime(date).plusDays(offsetDay).toString(pattern);
	}

	public static DateTime today(){
		return DateTime.now();
	}

	public static String format(long time, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date(time));
	}

	public static String translate(String time, String fromPattern, String toPattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(fromPattern);
		Date date = sdf.parse(time);
		sdf.applyPattern(toPattern);
		return sdf.format(date);
	}

}
