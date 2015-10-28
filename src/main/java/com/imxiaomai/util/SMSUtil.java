package com.imxiaomai.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.imxiaomai.base.crawler.Crawler;
import com.imxiaomai.base.toolkit.DateUtil;
import com.imxiaomai.base.util.JsonUtil;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SMSUtil {

	private static final String template = "主人～我是你的包裹，天冷不想来接我？让麦客代劳吧！点击进入北理免费送货通道： http://url.cn/dsUaTv 【小麦公社】";

	private static final Logger log = LoggerFactory.getLogger(SMSUtil.class);

	private static final Crawler crawler = Crawler.of("sms.push",3000,5000);

	/**
	 * 发送短信服务的URL
	 */
	public static final String SMS_URL = "http://sms.imxiaomai.com/sendSms";
	/**
	 * 发送短信服务的用户名（网站）
	 */
	public static final String SMS_USER_NAME = "wx_platform";
	/**
	 * 发送短信服务的密码（网站）
	 */
	public static final String SMS_PASSWORD = "wx_2013";

	/**
	 * 发送短信
	 * @author sqj
	 * @created 2014-3-10 下午2:24:38
	 *
	 * @param phoneNums 手机号码，多个用英文逗号隔开
	 * @return
	 */
	public static boolean sendSMSText(String phoneNums) {
		return send(SMS_USER_NAME, SMS_PASSWORD, phoneNums, template);
	}

	public static boolean sendSMSText(String phoneNums, String template){
		return send(SMS_USER_NAME, SMS_PASSWORD, phoneNums, template);
	}

	/**
	 * 通过Apache HttpComponents发送请求到短信服务器，发送短信
	 *
	 * @param smsUsername 短信服务用户名
	 *
	 * @param smsPassword 短信服务密码
	 *
	 * @param phoneNums 手机号码，多个用英文逗号隔开
	 *
	 * @param text 短信文本
	 */
	private static boolean send(String smsUsername, String smsPassword, String phoneNums, String text) {
		if (!StringUtils.hasText(phoneNums) || !StringUtils.hasText(text)) {
			return false;
		}

		try {
			// 处理请求参数
			String nowDateStr = DateUtil.today().toString("yyyy-MM-dd HH:mm:ss");
			String str = smsUsername + smsPassword + nowDateStr;
			String token = DigestUtils.md5DigestAsHex(str.getBytes()).toLowerCase();

			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("name", smsUsername));
			params.add(new BasicNameValuePair("token", token));
			params.add(new BasicNameValuePair("phones", phoneNums));
			params.add(new BasicNameValuePair("content", text));
			params.add(new BasicNameValuePair("sendtime", nowDateStr));
			params.add(new BasicNameValuePair("sendtype", "2"));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, Consts.UTF_8);

			Pair<Integer, String> result = crawler.post(SMS_URL, entity);

			log.info("request.sms.interface,entity={},result.httpcode={},result.content={}",params.toString(),result.getLeft(), result.getRight());

			if (result.getLeft() / 100 == 2) {

				try {
					JsonNode jsonNode = JsonUtil.parse(result.getRight());
					return jsonNode.findValue("code") != null && jsonNode.findValue("code").asInt() == 200;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println( sendSMSText("18612081583") );
	}

}
