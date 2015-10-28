package com.imxiaomai.base.crawler;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import static com.imxiaomai.base._.sleep;

/** 添加两个策略：1.如果超过n时间则不再重试、2.每次重试间sleep一定时间 */
public class MyHttpRequestRetryHandler implements HttpRequestRetryHandler {

	public static long sleepBeforeRetry = 20;

	final int retryCount;
	final long retryTimeout;
	final boolean crawlLog;
	public MyHttpRequestRetryHandler(int retryCount, long retryTimeout, boolean crawlLog) {
		this.retryCount = retryCount;
		this.retryTimeout = retryTimeout;
		this.crawlLog = crawlLog;
	}

	@Override
	public boolean retryRequest(IOException e, int executionCount, HttpContext context) {
		CrawlStopwatch watch = CrawlStopwatch.from(context);
		long passedTime = watch == null ? 0 : (System.currentTimeMillis() - watch.timestamps[0]);

		boolean retry = defaultRetryRequest(e, executionCount, context, passedTime);
		if (retry) {
			if (passedTime > retryTimeout) {
				retry = false;
			} else {
				// 如果成功/不重试，最外面有一层log，所以这里仅需要retry=true时打log
				if (crawlLog)
					CrawlerHelper.logCrawl(watch, e, executionCount, String.valueOf(context.getAttribute("url")));
				if (sleepBeforeRetry > 0)
					sleep(sleepBeforeRetry);
				watch.timestamps[CrawlStopwatch.maxStage + 2] = executionCount;
			}
		}
		return retry;
	}

	/* ------------------------- impl ------------------------- */
	// 在DefaultHttpRequestRetryHandler做了点小修正

	public boolean defaultRetryRequest(final IOException exception, int executionCount, final HttpContext context, long passedTime) {
		if (exception == null)
			throw new IllegalArgumentException("Exception parameter may not be null");
		if (context == null)
			throw new IllegalArgumentException("HTTP context may not be null");

		// Do not retry if over max retry count
		if (executionCount > this.retryCount || passedTime > retryCount)
			return false;

		// Timeout
		if (exception instanceof InterruptedIOException)
			return false;
		// Unknown host
		if (exception instanceof UnknownHostException)
			return false;
		// Connection refused
		if (exception instanceof ConnectException)
			return false;
		// SSL handshake exception
		if (exception instanceof SSLException)
			return false;

		HttpRequest request = (HttpRequest) context.getAttribute(ExecutionContext.HTTP_REQUEST);

		if (requestIsAborted(request))
			return false;

		// 关于org.apache.http.NoHttpResponseException: The target server failed to respond
		// 当对方由于超时等，主动将连接关闭，此时我们并不知道，此时发请求会有这种异常，且响应时间超级短(通常1~2ms)
		// 而HttpClient默认会将post接口理解成非idempotent，认为这种情况已经sent，所以不重发，特此修正
		if (exception instanceof NoHttpResponseException && passedTime < 5)
			return true;

		// Retry if the request is considered idempotent
		if (handleAsIdempotent(request))
			return true;

		Boolean b = (Boolean)
				context.getAttribute(ExecutionContext.HTTP_REQ_SENT);
		boolean sent = (b != null && b.booleanValue());

		if (!sent) {
			// Retry if the request has not been sent fully or
			// if it's OK to retry methods that have been sent
			return true;
		}
		// otherwise do not retry
		return false;
	}
	protected boolean handleAsIdempotent(final HttpRequest request) {
		return !(request instanceof HttpEntityEnclosingRequest);
	}
	protected boolean requestIsAborted(final HttpRequest request) {
		HttpRequest req = request;
		if (request instanceof RequestWrapper) { // does not forward request to original
			req = ((RequestWrapper) request).getOriginal();
		}
		return (req instanceof HttpUriRequest && ((HttpUriRequest) req).isAborted());
	}

}
