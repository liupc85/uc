package com.imxiaomai.web.base;

import com.imxiaomai.base._;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import static com.imxiaomai.base._.*;

public class ServletUtils {

	public static Map<String,String> getParams(HttpServletRequest request){
		Map<String,String> params = new HashMap<>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
		}
		return params;
	}

	public static boolean isPost(HttpServletRequest req) {
		return "post".equalsIgnoreCase(req.getMethod());
	}

	public static boolean isAjax(HttpServletRequest req) {
		//目前js库基本都会加这个属性，这么判断还是靠谱的
		return "XMLHttpRequest".equalsIgnoreCase(req.getHeader("X-Requested-With"));
	}

	public static String getUuid(HttpServletRequest req) {
		//方便各个地方使用，nginx模块中的cookie，每个请求uuid唯一
		return _.trimToEmpty(getCookie(req, "uuid"));
	}

	public static String getIp(HttpServletRequest req) {
		//代理转发前ip识别由apache/nginx实现，取到的即为真实ip，无需考虑代理中转问题
		return req.getRemoteAddr();
	}

	public static String mockIp() {
		return f("%s.%s.%s.%s", (int) (random() * 0x100), (int) (random() * 0x100),
				(int) (random() * 0x100), (int) (random() * 0x100));
	}

	public static boolean isIntranet(HttpServletRequest req) {
		return isIntranet(getIp(req));
	}

	public static boolean isIntranet(String ip) {
		return intranetIpPattern.matcher(ip).find();
	}

	// ref: http://en.wikipedia.org/wiki/IP_address#IPv4_private_addresses
	static final Pattern intranetIpPattern = Pattern.compile(
			"(^127\\.)|(^10\\.)|(^172\\.1[6-9]\\.)|(^172\\.2[0-9]\\.)|(^172\\.3[0-1]\\.)|(^192\\.168\\.)|(^::1$)");

	public static String getUrl(HttpServletRequest req) {
		String query = req.getQueryString();
		return req.getRequestURI() + (isNotEmpty(query) ? "?" + query : "");
	}

	public static String getUrlFull(HttpServletRequest req) {
		String query = req.getQueryString();
		StringBuffer url = req.getRequestURL();
		if (isNotEmpty(query))
			url.append('?').append(query);
		return url.toString();
	}

	public static String getUrlMain(HttpServletRequest req) {
		int port = req.getServerPort();
		return "http://" + req.getServerName() + (port != 80 ? ":" + port : "");
	}


	/* ------------------------- cookie ------------------------- */

	public static String getCookie(HttpServletRequest req, String key) {
		Cookie[] cookies = req.getCookies();
		if (cookies == null)
			return null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(key))
				return cookie.getValue();
		}
		return null;
	}

	public static void setCookie(HttpServletResponse resp, String key, String value) {
		setCookie(resp, key, value, -1);
	}

	public static void setCookie(HttpServletResponse resp, String key, String value, int second) {
		setCookie(resp, key, value, second, null, null);
	}

	public static void setCookie(HttpServletResponse resp, String key, String value, int second, String path,
	                             String domain) {
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(second);
		if (isNotEmpty(path))
			cookie.setPath(path);
		if (isNotEmpty(domain))
			cookie.setDomain(domain);
		resp.addCookie(cookie);
	}

	public static void clearCookie(HttpServletResponse resp, String key) {
		clearCookie(resp, key, null, null);
	}

	public static void clearCookie(HttpServletResponse resp, String key, String path, String domain) {
		Cookie cookie = new Cookie(key, "");
		cookie.setMaxAge(0);
		if (isNotEmpty(path))
			cookie.setPath(path);
		if (isNotEmpty(domain))
			cookie.setDomain(domain);
		resp.addCookie(cookie);
	}

}
