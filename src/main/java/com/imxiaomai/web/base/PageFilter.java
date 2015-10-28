package com.imxiaomai.web.base;

import com.imxiaomai.base.toolkit.AutoLog;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.imxiaomai.base._.f;
import static com.imxiaomai.base._.regex;

public class PageFilter implements Filter {

	static final Logger logger = LoggerFactory.getLogger(PageFilter.class);

	static final ConcurrentHashMap<String,AutoLog> logMap = new ConcurrentHashMap<>();

	static final AutoLog pvall = AutoLog.of("pv.all");

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse resp = (HttpServletResponse) servletResponse;

		boolean isStaticFile = isStaticFile(req.getRequestURI());
		if (!isStaticFile) {
			setHeader(req, resp);
		}

		long start = System.currentTimeMillis();
		chain.doFilter(req, resp);
		opLog(start, req);
	}


	public static boolean isStaticFile(String uri) {
		Matcher m = postfixPattern.matcher(uri);
		if (!m.find())
			return false;
		String group = m.group(1).toLowerCase();
		return staticSuffixes.contains(group);
	}
	static final Pattern postfixPattern = regex("\\.(\\w+)$");
	static final Set<String> staticSuffixes = new HashSet<>(Arrays.asList( //
			"ico", "css", "js", "gif", "png", "jpg", "jpeg", "swf", "txt"));


	/** 对request、response的惯例设置 */
	private void setHeader(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
	}

	public static void opLog(long start, HttpServletRequest req) {
		long end = System.currentTimeMillis();
		String url = ServletUtils.getUrlFull(req);
		String ip = ServletUtils.getIp(req);
		int cost = (int) (end - start);
		
		String log = "[INFO] [%s] [Observer,type=xiaomaiUser,cost=%s,Owner=OP,url=%s,ip=%s,raw=%s]";
		System.out.println(f(log, format.print(end), cost, url, ip,req.getAttribute("raw")));
		log(req, cost);
	}
	static final DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.S");

	private static void log(HttpServletRequest request, int cost) {
		String reqUrl = request.getRequestURI();
		AutoLog autoLog = null;
		reqUrl = convert(reqUrl);
		if( !logMap.containsKey(reqUrl) ) {
			autoLog = AutoLog.of(reqUrl);
			AutoLog tmp = logMap.putIfAbsent(reqUrl, autoLog);
			if( tmp != null ){
				autoLog = tmp;
			}
		}else{
			autoLog = logMap.get(reqUrl);
		}

		autoLog.add(cost);
		pvall.add(cost);
	}

	private static String convert(String url){
		if( url.startsWith("/") )
			url = url.substring(1);
		return url.replaceAll("/",".");
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void destroy() {}

}
