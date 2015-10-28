package com.imxiaomai.base.crawler;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.Header;

public final class CrawlResponse {

	public int httpCode;
	public Exception e;
	public String content;
    public byte[] bcontent;
    public Header[] headers;
	public int cost;
	public String timelog;
	CrawlStopwatch watch;

	public String asStr() {
		return httpCode == 200 ? content : null;
	}
	public Pair<Integer, String> asPair() {
		if (e == null)
			return Pair.of(httpCode, content);
		else
			return Pair.of(600, e.toString());
	}

}
