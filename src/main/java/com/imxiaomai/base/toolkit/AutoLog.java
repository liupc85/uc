package com.imxiaomai.base.toolkit;

import com.imxiaomai.base.util.EnvUtil;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.imxiaomai.base._.*;

/** 使用方式参考：http://svn.sogou-inc.com/svn/mobilesearch/trunk/zhidao/front/web/src/main/java/com/sogou/wen/main.pay.com.imxiaomai.base/keys/AutoLogs.java */
public class AutoLog {

	/** 可灵活设置logger名。另：除logger外，还会向stderr输出一份 */
	public static Logger statLogger = LoggerFactory.getLogger("stat");
	/** 以何间隔输出日志 */
	public static long logInterval = EnvUtil.isWindows ? 10000 : (1 * 60000L);
	/** 格式为String.format格式，1/2/3/4 = 时间/key/avg/count */
	public static String logFormat = "%1$s\t%2$s\tavg:%3$s\tcount:%4$s";
	/** 日志中时间的格式 */
	public static DateTimeFormatter logTimeFormat = DateTimeFormat.forPattern("yyyyMMddHHmm");

	/* ------------------------- init ------------------------- */

	public static AutoLog of(String name) {
		return new AutoLog(name);
	}
	public final String name;
	private AutoLog(String name) {
		this.name = name;
		checkDuplicateName(name);
	}

	static Set<String> usedNames = Collections.synchronizedSet(new HashSet<String>());
	private void checkDuplicateName(String name) {
		if (usedNames.contains(name))
			logger.error("duplicate autoLog: " + name);
		else
			usedNames.add(name);
	}

	/* ------------------------- impl ------------------------- */

	static final Logger logger = LoggerFactory.getLogger(AutoLog.class);

	private ReentrantLock lock = new ReentrantLock();
	private volatile int count = 0;
	private volatile int sum = 0;
	/* sum为int而不为long的考虑：
	 * 以记录耗时ms数为例：int最大可表示2G，5分钟间隔意味着是0.3M，则大约7k个线程不停地操作，才能把int撑满，所以不成问题
	 * 假如记录的是成功率，只要平均操作速度不是远低于1ms，那也不成问题 */

	public void add(int time) {
		lock.lock();
		{
			this.count++;
			this.sum += time;
		}
		lock.unlock();
	}
	public final void end(long start) {
		add((int) (System.currentTimeMillis() - start));
	}

	public void log(String date) {
		if (this.count <= 0)
			return;

		int c, s;
		lock.lock();
		{
			c = this.count;
			s = this.sum;
			this.count = 0;
			this.sum = 0;
		}
		lock.unlock();
		if (c > 0) {
			if (statLogger != null) {
				//勿更改此格式，此log会用于统计
				statLogger.info(f(logFormat, date, name, ((double) s) / c, c));
			}
			System.err.println(f("[AutoLog] " + logFormat, date, name, ((double) s) / c, c));
		}
	}

	/* ------------------------- schedule ------------------------- */

	static List<AutoLog> instances = new ArrayList<AutoLog>();
	{
		synchronized (instances) {
			instances.add(this);
		}
	}

	static {
		// liuzhixin(2013-7): 延迟执行的目的：即使在AutoLog已初始化后，仍可修改logInterval参数
		MyExecutor.timer.schedule(new TimerTask() {
			public void run() {
				long interval = logInterval;
				long firstTime = (System.currentTimeMillis() / interval * interval) + interval;
				MyExecutor.timer.scheduleAtFixedRate(new LogTimerTask(), new Date(firstTime), interval);
				// liuzhixin(2013-8): 使用schedule()会有执行时间导致触发时间误差逐渐累加问题，必须使用scheduleAtFixedRate()
			}
		}, 50);
	}
	public static class LogTimerTask extends TimerTask {
		public void run() {
			long time = this.scheduledExecutionTime();
			long interval = logInterval;
			String date = logTimeFormat.print(time / interval * interval - interval);
			for (AutoLog autoLog : instances)
				autoLog.log(date);
		}
	}

	/** resin要关的时候，打出最后一次log，避免数据丢失 */
	public static void printAll() {
		printAll(System.currentTimeMillis());
	}
	static void printAll(long time) {
		long interval = logInterval;
		String date = logTimeFormat.print(time / interval * interval - interval);
		for (AutoLog autoLog : instances)
			autoLog.log(date);
	}

	/* ------------------------- debug ------------------------- */

	public static void main(String[] args) {
		AutoLog.logInterval = 200;
		AutoLog.statLogger = null;

		AutoLog log = AutoLog.of("key");
		sleep(150);
		log.add(1);
		sleep(200); // output, count 1
		for (int i = 0; i < 10; i++)
			log.add(randInt(10));
		sleep(200); // output, count 10
	}

}
