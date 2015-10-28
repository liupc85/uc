package com.imxiaomai.base.crawler;


import org.apache.http.protocol.HttpContext;

final class CrawlStopwatch {

	public static CrawlStopwatch newInstance(HttpContext ctx) {
		CrawlStopwatch watch = new CrawlStopwatch();
		ctx.setAttribute("timelog", watch);
		return watch;
	}
	static CrawlStopwatch from(HttpContext ctx) {
		return ctx != null ? (CrawlStopwatch) ctx.getAttribute("timelog") : null;
	}

	/* ------------------------- init ------------------------- */

	// 留作public，预防灵活需求
	public static final int maxStage = CrawlStage._lastValue;
	public final long[] timestamps; // initTime, stagesTime..., currentStage, retryTimes

	CrawlStopwatch() {
		this.timestamps = new long[maxStage + 3];
		this.timestamps[0] = System.currentTimeMillis();
		this.timestamps[maxStage + 1] = 0; // stage = 0
		this.timestamps[maxStage + 2] = 0; // retry = 0
	}

	/* ------------------------- impl ------------------------- */

	public void log(int stage) {
		if (stage <= 0 || stage > maxStage)
			throw new IllegalArgumentException("illegal stage: " + stage);

		this.timestamps[stage] = System.currentTimeMillis();
		this.timestamps[maxStage + 1] = stage;

		// 重试会重新触发stage1
		if (stage == 1)
			for (int i = 2; i <= maxStage; i++)
				this.timestamps[i] = 0;
	}

	/** format: cost|stage|cost1|cost2|cost3 */
	@Override
	public String toString() {
		long lastTime = this.timestamps[0];
		StringBuilder sb = new StringBuilder();
		sb.append(System.currentTimeMillis() - lastTime);
		sb.append("_<");
		sb.append(this.timestamps[maxStage + 1]);

		int lastValue = maxStage;
		while (this.timestamps[lastValue] == 0 && lastValue > 0)
			lastValue--;

		for (int i = 1; i <= lastValue; i++) {
			long curTime = this.timestamps[i];
			long stamp;
			if (curTime <= 0)
				stamp = -1;
			else {
				stamp = curTime - lastTime;
				lastTime = curTime;
			}
			sb.append(i == 1 ? ">_" : "|");
			if (i == CrawlStage.dns_end.value)
				sb.append("h");
			if (i == CrawlStage.conn_end.value)
				sb.append("c");
			if (i == CrawlStage.exec_end.value)
				sb.append("w");
			if (i == CrawlStage.download_end.value)
				sb.append("d");
			sb.append(stamp);
		}

		return sb.toString();
	}

}
