package com.imxiaomai.util;

import com.imxiaomai.base.toolkit.MyExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class SMSUtilNew {

	private final static String baifenrl = "http://cf.lmobile.cn/submitdata/Service.asmx/g_Submit";

	private final static Logger log = LoggerFactory.getLogger(SMSUtilNew.class);

	private final static MyExecutor exector = MyExecutor.instance();

	public static void doSendByBaifenAsync(final String telphone, final String content ){
		exector.submit("async.sms.send.baifen",new Runnable() {
			@Override
			public void run() {
				doSendByBaifen(telphone, content);
			}
		});
	}

	private static void doSendByBaifen( String telphone, String content ){
		try {

			String entity = "sname={sname}&spwd={spwd}&scorpid={scorpid}&sprdid={sprdid}&sdst={tel}&smsg={content}";
			entity = entity.replace("{sname}", UrlConstants.baifen_sname);
			entity = entity.replace("{spwd}", UrlConstants.baifen_spwd);
			entity = entity.replace("{scorpid}", UrlConstants.baifen_scorpid);
			entity = entity.replace("{sprdid}", UrlConstants.baifen_sprdid);
			entity = entity.replace("{tel}", telphone);
			entity = entity.replace("{content}", content);

			URL url = new URL(baifenrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setConnectTimeout(3000);
			conn.setReadTimeout( 3000 );
			conn.setUseCaches(false);
			conn.setDoOutput(true);

			conn.setRequestProperty("Content-Length", "" + entity.length());
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			out.write(entity);
			out.flush();
			out.close();

			//获取响应状态
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out.println("connect failed!");
				return;
			}
			//获取响应内容体
			String line, result = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			while ((line = in.readLine()) != null) {
				result += line + "\n";
			}
			in.close();

			log.info("taskpool.doSendByBaifen.return,url={},return={}", entity, result);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
