package com.imxiaomai.base.crawler;

import com.imxiaomai.base.io.StreamUtil;
import com.imxiaomai.base.util.EscapeUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.ContentEncodingHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static com.imxiaomai.base._.f;
import static com.imxiaomai.base._.isEmpty;
import static com.imxiaomai.base._.trimToEmpty;


@SuppressWarnings("deprecation")
public class CrawlerHelper {

    public static int defConnTimeout = 3000;
    public static int defSoTimeout = 6000;
    public static int defMaxTotalConn = 1000;
    public static int defMaxConnPerHost = 300;
    public static int defRetry = 3;
    public static long defRetryTimeout = 3000;

    public static String userAgent = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)";
    public static String defaultCharset = EscapeUtil.UTF8;

    public static final class ResponseHandler implements org.apache.http.client.ResponseHandler<CrawlResponse> {
        private final CrawlStopwatch watch;
        private final CrawlResponse bean;
        private final String charset;
        public ResponseHandler(CrawlStopwatch watch, CrawlResponse bean, String charset) {
            this.watch = watch;
            this.bean = bean;
            this.charset = charset;
        }
        public CrawlResponse handleResponse(HttpResponse resp) throws ClientProtocolException, IOException {
            watch.log(CrawlStage.download_start.value);
            bean.httpCode = resp.getStatusLine().getStatusCode();
            bean.bcontent = EntityUtils.toByteArray(resp.getEntity());
            bean.content = new String(bean.bcontent,charset);
            //bean.content = EntityUtils.toString(resp.getEntity(), charset);
            bean.headers = resp.getAllHeaders();
            watch.log(CrawlStage.download_end.value);
            return bean;
        }
    }

    public static Pair<PoolingClientConnectionManager, ContentEncodingHttpClient> newClient(int connTimeout, int soTimeout, int maxTotalConn, int maxConnPerHost, int retryCount, long retryTimeout, boolean crawlLog) {
        // prepare cm
        PoolingClientConnectionManager cm = new PoolingClientConnectionManager() {
            protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schreg) {
                return new MyClientConnectionOperator(schreg);
            }
        };
        cm.setDefaultMaxPerRoute(maxConnPerHost);
        cm.setMaxTotal(maxTotalConn);

        // prepare params
        HttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, defaultCharset);
        HttpProtocolParams.setUseExpectContinue(params, false);
        HttpProtocolParams.setUserAgent(params, userAgent);

        HttpConnectionParams.setStaleCheckingEnabled(params, true);
        HttpConnectionParams.setConnectionTimeout(params, connTimeout);
        HttpConnectionParams.setSoTimeout(params, soTimeout);
        HttpClientParams.setRedirecting(params, true);
        HttpClientParams.setCookiePolicy(params, CookiePolicy.BROWSER_COMPATIBILITY);

        // ContentEncodingHttpClient被Deprecated的原因是：
        // 修改entity内容的时候，没有同步修改Content-Length等header
        // 但这正是我们期望的行为，我们期望尽可能保留返回信息，供以后使用
        ContentEncodingHttpClient client = new ContentEncodingHttpClient(cm, params) {
            private final Log log = LogFactory.getLog(getClass());
            @Override
            protected RequestDirector createClientRequestDirector(HttpRequestExecutor requestExec,
                                                                  ClientConnectionManager conman, ConnectionReuseStrategy reustrat,
                                                                  ConnectionKeepAliveStrategy kastrat, HttpRoutePlanner rouplan, HttpProcessor httpProcessor,
                                                                  HttpRequestRetryHandler retryHandler, RedirectStrategy redirectStrategy,
                                                                  AuthenticationHandler targetAuthHandler, AuthenticationHandler proxyAuthHandler,
                                                                  UserTokenHandler stateHandler, HttpParams params) {
                throw new IllegalArgumentException();
            }
            @Override
            protected RequestDirector createClientRequestDirector(HttpRequestExecutor requestExec,
                                                                  ClientConnectionManager conman, ConnectionReuseStrategy reustrat,
                                                                  ConnectionKeepAliveStrategy kastrat, HttpRoutePlanner rouplan, HttpProcessor httpProcessor,
                                                                  HttpRequestRetryHandler retryHandler, RedirectStrategy redirectStrategy,
                                                                  AuthenticationStrategy targetAuthStrategy, AuthenticationStrategy proxyAuthStrategy,
                                                                  UserTokenHandler userTokenHandler, HttpParams params) {
                return new MyRequestDirector(log, requestExec, conman, reustrat, kastrat, rouplan, httpProcessor,
                        retryHandler, redirectStrategy, targetAuthStrategy, proxyAuthStrategy, userTokenHandler, params);
            }
        };
        client.setHttpRequestRetryHandler(new MyHttpRequestRetryHandler(retryCount, retryTimeout, crawlLog));
        return Pair.of(cm, client);
    }

    static void logCrawl(HttpUriRequest req, CrawlResponse resp) {
        CrawlStopwatch watch = resp.watch;
        int httpCode = resp.httpCode;
        int len = trimToEmpty(resp.content).length();
        logCrawl(watch, httpCode, len, resp.e, req.getURI().toString(), req, resp);
    }
    static void logCrawl(CrawlStopwatch watch, IOException e, int executionCount, String url) {
        logCrawl(watch, 0, 0, e, url);
    }
    private static void logCrawl(CrawlStopwatch watch, int httpCode, int len, Exception e, String url, HttpUriRequest request, CrawlResponse response) {
        int round = (int) watch.timestamps[CrawlStopwatch.maxStage + 2];
        long cost = System.currentTimeMillis() - watch.timestamps[0];
        String timelog = watch.toString();
        String eStr = e == null ? "" : e.toString();
	    String params = getParams(request);
		String header = getHeaders(request);
        Crawler.logger.info(f("[CrawlLog] (%s) cost:%d, timelog:%s, code:%d, len:%d, err:%s, url:%s, method:%s, params:%s, header:%s, return:%s",
                round, cost, timelog, httpCode, len, eStr, url, request.getMethod(), params, header, cut(response.content, 256)));
    }

	private static void logCrawl(CrawlStopwatch watch, int httpCode, int len, Exception e, String url) {
		int round = (int) watch.timestamps[CrawlStopwatch.maxStage + 2];
		long cost = System.currentTimeMillis() - watch.timestamps[0];
		String timelog = watch.toString();
		String eStr = e == null ? "" : e.toString();
		Crawler.logger.info(f("[CrawlLog] (%s) cost:%d, timelog:%s, code:%d, len:%s, err:%s, url:%s",
				round, cost, timelog, httpCode, len, eStr, url));
	}

	private static String cut(String str, int len){
		if( isEmpty(str) )
			return "";
		return str.length() > len ? str.substring(0,len) + "..." : str;
	}

	private static String getParams(HttpUriRequest request) {
		try {
			if ("POST".equalsIgnoreCase(request.getMethod())) {
				byte[] bytes = StreamUtil.consume(((HttpPost) request).getEntity().getContent());
				return new String(bytes, "UTF-8");
			} else {
				return "";
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return "";
	}

	private static String getHeaders(HttpUriRequest request){
		Header[] headers = request.getAllHeaders();
		if( headers != null && headers.length > 0 ){
			StringBuilder builder = new StringBuilder(128);
			builder.append("{");
			for( Header h : headers ){
				builder.append(h.getName()).append("=").append(h.getValue()).append(",");
			}
			builder.deleteCharAt( builder.length() - 1 );
			builder.append("}");
			return builder.toString();
		}
		return "";
	}

}
