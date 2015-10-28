package com.imxiaomai.base.crawler;


import org.apache.http.HttpHost;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.DefaultClientConnectionOperator;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

class MyClientConnectionOperator extends DefaultClientConnectionOperator {

	public MyClientConnectionOperator(SchemeRegistry schemes) {
		super(schemes);
	}

	@Override
	public void openConnection(final OperatedClientConnection conn, final HttpHost target, final InetAddress local,
							   final HttpContext context, final HttpParams params) throws IOException {
		try {
			cachedContext = context;
			CrawlStage.conn_start.log(context);
			super.openConnection(conn, target, local, context, params);
		} finally {
			CrawlStage.conn_end.log(context);
			cachedContext = null;
		}
	}

	private HttpContext cachedContext = null;

	@Override
	protected InetAddress[] resolveHostname(String host) throws UnknownHostException {
		try {
			CrawlStage.dns_start.log(cachedContext);
			return super.resolveHostname(host);
		} finally {
			CrawlStage.dns_end.log(cachedContext);
		}
	}

}
