package com.imxiaomai.base.toolkit;

public class StagedStopWatch {

	public static StagedStopWatch newInstance(int stageCount) {
		return new StagedStopWatch(stageCount);
	}

	/* ------------------------- impl ------------------------- */

	//留作public，预防灵活需求
	public final int maxStage;
	public final long[] timestamps; // initTime, stagesTime..., currentStage

	private StagedStopWatch(int maxStage) {
		this.maxStage = maxStage;
		this.timestamps = new long[maxStage + 2];
		this.timestamps[0] = System.currentTimeMillis();
		this.timestamps[maxStage + 1] = 0; // stage = 0
	}

	/* ------------------------- facade ------------------------- */

	public void log(int stage) {
		if (stage <= 0 || stage > maxStage)
			throw new IllegalArgumentException("illegal stage: " + stage);
		this.timestamps[stage] = System.currentTimeMillis();
		this.timestamps[maxStage + 1] = stage;
	}

	/** format: cost[stage]cost1|cost2|cost3 */
	@Override
	public String toString() {
		long lastTime = this.timestamps[0];
		StringBuilder sb = new StringBuilder();
		sb.append(System.currentTimeMillis() - lastTime);
		sb.append('[');
		sb.append(this.timestamps[maxStage + 1]);
		for (int i = 1; i <= maxStage; i++) {
			sb.append(i == 1 ? ']' : '|');
			long curTime = this.timestamps[i];
			if (curTime <= 0) {
				sb.append('-');
			} else {
				sb.append(curTime - lastTime);
				lastTime = curTime;
			}
		}
		return sb.toString();
	}

}
