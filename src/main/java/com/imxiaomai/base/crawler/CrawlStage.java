package com.imxiaomai.base.crawler;

import org.apache.http.protocol.HttpContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

final class CrawlStage {

	/* ------------------------- constants ------------------------- */

	private static int idx = 0;

	// ** cost: retry, redirect

	@UsedBy(MyRequestDirector.class)
	public static final CrawlStage round_start = new CrawlStage(++idx); // per request start(redirect considered)

	// ** cost: pick entry from connManager

	@UsedBy(MyClientConnectionOperator.class)
	public static final CrawlStage conn_start = new CrawlStage(++idx); // conn succ.
	@UsedBy(MyClientConnectionOperator.class)
	public static final CrawlStage dns_start = new CrawlStage(++idx); // request entry got. start socket.conn

	// ** cost: dns lookup

	@UsedBy(MyClientConnectionOperator.class)
	public static final CrawlStage dns_end = new CrawlStage(++idx); // start conn

	// ** cost: conn

	@UsedBy(MyClientConnectionOperator.class)
	public static final CrawlStage conn_end = new CrawlStage(++idx); // conn succ.
	@UsedBy(MyRequestDirector.class)
	public static final CrawlStage conn_end_2 = new CrawlStage(++idx); // conn succ.
	// err: org.apache.http.conn.ConnectTimeoutException: Connect to weibo.com:80 timed out
	// err: java.net.UnknownHostException: w

	// * cost: request handle

	@UsedBy(MyRequestDirector.class)
	public static final CrawlStage exec_start = new CrawlStage(++idx); //

	// ** cost: recieve response

	@UsedBy(MyRequestDirector.class)
	public static final CrawlStage exec_end = new CrawlStage(++idx); //

	public static final CrawlStage download_start = new CrawlStage(++idx); //

	// ** cost: download left body

	public static final CrawlStage download_end = new CrawlStage(++idx); //

	static final int _lastValue = download_end.value;

	/* ------------------------- impl ------------------------- */

	public final int value;
	private CrawlStage(int value) {
		this.value = value;
	}

	public void log(HttpContext context) {
		CrawlStopwatch watch = CrawlStopwatch.from(context);
		if (watch != null)
			watch.log(this.value);
	}

	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.SOURCE)
	@interface UsedBy {
		Class<?>[] value();
	}

}
/*
 * 笔记
 *
 * tlog:1722|10|0|-1|-1|1|0|444|0|1|0|1275
 * (典型的下载完成)总耗时1722|第10步|0-未重定向|-1(无需获得连接)|-1(无需dns解析)|1(http连接)|0(req准备)|444(http请求)|0(-)|1(获得2k)|0|1275(获得内容)
 *
 * tlog:6003|3|0|0|0|-1|-1|-1|-1|-1|-1|-1
 * (典型的超时)总耗时6003|第3步(conn失败)|0-未重定向|0(获得连接)|0(dns解析成功)|-1|-1|-1|-1|-1|-1|-1
 */
