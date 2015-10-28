package com.imxiaomai.util;

import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;

public class UrlUtils {

	public static String encode(String s){
		if(StringUtils.isEmpty(s)){
			return "";
		}
		String result=URLEncoder.encode(s);
		return result;
	}
	
	
}
