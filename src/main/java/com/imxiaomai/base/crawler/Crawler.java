package com.imxiaomai.base.crawler;


import com.imxiaomai.base._;
import com.imxiaomai.base.infrastructure.Config;
import com.imxiaomai.base.toolkit.AutoLog;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.ContentEncodingHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.protocol.BasicHttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

import static com.imxiaomai.base.crawler.CrawlerHelper.*;

public class Crawler {

    static final Logger logger = LoggerFactory.getLogger(Crawler.class);

    /* ------------------------- builder  v2 ------------------------- */
    /* ------------------------- based on Config & params, support autolog ------------------------- */
    public static Crawler of(String name) {
        return new Crawler(name, defConnTimeout, defSoTimeout, defMaxTotalConn, defMaxConnPerHost, defRetry, defRetryTimeout, true);
    }

    public static Crawler of(String name, int connTimeout, int soTimeout) {
        return new Crawler(name, connTimeout, soTimeout, defMaxTotalConn, defMaxConnPerHost, defRetry, defRetryTimeout, true);
    }

    public static Crawler of(String name, int connTimeout, int soTimeout, int retry, long retryTimeout) {
        return new Crawler(name, connTimeout, soTimeout, defMaxTotalConn, defMaxConnPerHost, retry, retryTimeout, true);
    }

    public static Crawler of(String name, int connTimeout, int soTimeout, int maxTotalConn, int maxConnPerHost, int retry, long retryTimeout) {
        return new Crawler(name, connTimeout, soTimeout, maxTotalConn, maxConnPerHost, retry, retryTimeout, true);
    }

    private static String defCrawlerName = "default.crawler";
    private String name = defCrawlerName;

    private Crawler(String name, int connTimeout, int soTimeout, int maxTotalConn, int maxConnPerHost, int retry, long retryTimeout, boolean crawlLog) {
        connTimeout = _.toInt(Config.of(name + ".conn.timeout", _.toStr(connTimeout)).get());
        soTimeout = _.toInt(Config.of(name + ".so.timeout", _.toStr(soTimeout)).get());
        maxTotalConn = _.toInt(Config.of(name + ".max.total.conn", _.toStr(maxTotalConn)).get());
        maxConnPerHost = _.toInt(Config.of(name + ".max.conn.per.host", _.toStr(maxConnPerHost)).get());
        retry = _.toInt(Config.of(name + ".retry", _.toStr(retry)).get());
        retryTimeout = _.toLong(Config.of(name + ".retry.timeout", _.toStr(retryTimeout)).get());

        Pair<PoolingClientConnectionManager, ContentEncodingHttpClient> pair = CrawlerHelper.newClient(connTimeout, soTimeout, maxTotalConn, maxConnPerHost, retry, retryTimeout, crawlLog);
        logger.info("Crawler instance: {}=({},{},{},{},{},{})", name, connTimeout, soTimeout, maxTotalConn, maxConnPerHost, retry, retryTimeout);
        this.cm = pair.getLeft();
        this.client = pair.getRight();
        this.crawlLog = crawlLog;
        this.name = name;
        initAutoLog();
    }

    /* ------------------------- builder ------------------------- */
    @Deprecated // 推荐使用of(String name)
    public static Crawler newInstance() {
        return new Crawler(defConnTimeout, defSoTimeout, defMaxTotalConn, defMaxConnPerHost, defRetry, defRetryTimeout, true);
    }

    @Deprecated // 推荐使用of(String name, int connTimeout, int soTimeout)
    public static Crawler newInstance(int connTimeout, int soTimeout) {
        return new Crawler(connTimeout, soTimeout, defMaxTotalConn, defMaxConnPerHost, defRetry, defRetryTimeout, true);
    }

    @Deprecated
    // 推荐使用of(String name, int connTimeout, int soTimeout, int maxTotalConn, int maxConnPerHost, int retry, long retryTimeout)
    public static Crawler newInstance(int connTimeout, int soTimeout, int maxTotalConn, int maxConnPerHost, int retry, long retryTimeout, boolean crawlLog) {
        return new Crawler(connTimeout, soTimeout, maxTotalConn, maxConnPerHost, retry, retryTimeout, crawlLog);
    }

    public static Crawler getInstance() {
        return defaultCrawler;
    }

    static final Crawler defaultCrawler = newInstance();

	/* ------------------------- init ------------------------- */

    public Crawler(int connTimeout, int soTimeout) {
        this(connTimeout, soTimeout, defMaxTotalConn, defMaxConnPerHost, defRetry, defRetryTimeout, true);
    }

    public Crawler(int connTimeout, int soTimeout, int maxTotalConn, int maxConnPerHost, int retry, long retryTimeout, boolean crawlLog) {
        this(defCrawlerName, connTimeout, soTimeout, maxTotalConn, maxConnPerHost, retry, retryTimeout, crawlLog);
    }

    public Crawler(Crawler crawler) {
        this.cm = crawler.cm;
        this.client = crawler.client;
        this.crawlLog = crawler.crawlLog;
        initAutoLog();
    }

    public final PoolingClientConnectionManager cm;
    public final ContentEncodingHttpClient client;
    public final boolean crawlLog;

	/* ------------------------- methods ------------------------- */

    /**
     * 需求：不同失败区分处理
     */
    public Pair<Integer, String> get(String url) {
        return rawExec(new HttpGet(url)).asPair();
    }

    public CrawlResponse getResp(String url) {
        return rawExec(new HttpGet(url));
    }

    /**
     * 需求：内部接口等，不同失败区分处理
     */
    public Pair<Integer, String> post(HttpPost post) {
        return rawExec(post).asPair();
    }

    public Pair<Integer, String> post(String url, HttpEntity entity) {
        return postResp(url,entity).asPair();
    }

    public CrawlResponse postResp(String url, HttpEntity entity) {
        HttpPost post = new HttpPost(url);
        post.setEntity(entity);
        return rawExec(post);
    }

    public Pair<Integer, String> post(String url, String entity, Charset entityCharset) {
        return post(url, new StringEntity(entity, entityCharset));
    }

	public CrawlResponse postResp( String url, HttpEntity entity, Header[] headers){
		HttpPost post = new HttpPost(url);
		post.setEntity(entity);
		for( Header h : headers ){
			post.setHeader(h);
		}
		return rawExec(post);
	}

	public CrawlResponse postResp( String url, String entity, Header[] headers, Charset charset ){
		HttpPost post = new HttpPost(url);
		post.setEntity(new StringEntity(entity,charset));
		for( Header h : headers )
			post.setHeader(h);
		return rawExec(post);
	}

    /**
     * 需求：不care失败，只care内容是否合法(xml/json)
     */
    public String getContent(String url) {
        return rawExec(new HttpGet(url)).asStr();
    }

    public String getContent(String url, String charset) {
        return rawExec(new HttpGet(url), charset).asStr();
    }

/*    public Document getDocument(String url) {
        return rawExec(new HttpGet(url)).asXml();
    }

    public Document getDocument(String url, String charset) {
        return rawExec(new HttpGet(url), charset).asXml();
    }
*/
    // 更多需求可继承crawler实现，可以通过new Crawler(crawler)重用client

	/* ------------------------- impl ------------------------- */

    private CrawlResponse rawExec(HttpUriRequest req) {
        return rawExec(req, defaultCharset);
    }

    private CrawlResponse rawExec(HttpUriRequest req, String charset) {
        CrawlResponse resp = new CrawlResponse();
        final BasicHttpContext context = new BasicHttpContext();
        final long start = System.currentTimeMillis();
        final CrawlStopwatch watch = CrawlStopwatch.newInstance(context);
        context.setAttribute("url", req.getURI());

        try {
            CrawlerHelper.ResponseHandler handler = new CrawlerHelper.ResponseHandler(watch, resp, charset);
            resp = client.execute(req, handler, context);
        } catch (Exception e) {
            resp.e = e;
            e.printStackTrace();
        } finally {
            resp.cost = (int) (System.currentTimeMillis() - start);
            resp.timelog = watch.toString();
            resp.watch = watch;
        }

        log(req, resp);
        return resp;
    }

    private void log(HttpUriRequest req, CrawlResponse resp) {
        if (crawlLog)
            logCrawl(req, resp);

        costLog.add(resp.cost);
        succLog.add(resp.httpCode == 200 ? 1 : 0);
        long200Log.add(resp.cost > 200 ? 1 : 0);
        long2000Log.add(resp.cost > 2000 ? 1 : 0);

        crawlerCostLog.add(resp.cost);
        crawlerSuccLog.add(resp.httpCode == 200 ? 1 : 0);
        crawlerLong200Log.add(resp.cost > 200 ? 1 : 0);
        crawlerLong2000Log.add(resp.cost > 2000 ? 1 : 0);
    }

    private void initAutoLog() {
        crawlerCostLog = AutoLog.of("crawl.cost." + this.name);
        crawlerSuccLog = AutoLog.of("crawl.succ." + this.name);
        crawlerLong200Log = AutoLog.of("crawl.long200." + this.name);
        crawlerLong2000Log = AutoLog.of("crawl.long2000." + this.name);
    }

    private AutoLog crawlerCostLog = null;
    private AutoLog crawlerSuccLog = null;
    private AutoLog crawlerLong200Log = null;
    private AutoLog crawlerLong2000Log = null;

    static final AutoLog costLog = AutoLog.of("crawl.cost");
    static final AutoLog succLog = AutoLog.of("crawl.succ");
    static final AutoLog long200Log = AutoLog.of("crawl.long200");
    static final AutoLog long2000Log = AutoLog.of("crawl.long2000");

}
