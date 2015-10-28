package com.imxiaomai.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.imxiaomai.base.crawler.Crawler;
import com.imxiaomai.base.infrastructure.Config;
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

/**
 * 为P2P的麦客信新增通道
 * @author Administrator
 *
 */
public class SMSUtilForMK {

	private static final Logger log = LoggerFactory.getLogger(SMSUtilForMK.class);

	private static final Crawler crawler = Crawler.of("sms.push",3000,5000);

	/**
	 * 发送短信服务的URL
	 */
//	public static final String SMS_URL = "http://123.57.228.194:8091/smsCenter/sendSms";
//	public static final String SMS_URL = "http://10.51.84.7:8091/smsCenter/sendSms";
//	public static final String SMS_URL = "http://182.92.232.254:8091/smsCenter/sendSms";
	public static final String SMS_URL = "http://sms.imxiaomai.com/sendSms";
	
	/**
	 * 发送短信服务的用户名（网站）
	 */
	public static final String SMS_USER_NAME_FOR_P2P = "p2p_mkx";
	/**
	 * 发送短信服务的密码（网站）
	 */
	public static final String SMS_PASSWORD_FOR_P2P = "p2p_mkx";
	
	
	public static boolean sendSMSText(String phoneNums, String template){
		Config  channel= Config.of("SMS_FOR_P2P_CHANNEL", "7");//通道编码
		String channel_s=channel.get();
		System.out.println("channel_s "+channel_s);
		return send(SMS_USER_NAME_FOR_P2P, SMS_PASSWORD_FOR_P2P,channel_s, phoneNums, template);
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
	private static boolean send(String smsUsername, String smsPassword,String channel, String phoneNums, String text) {
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
			params.add(new BasicNameValuePair("sendtype", channel));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, Consts.UTF_8);
			System.out.println(SMS_URL);
			Pair<Integer, String> result = crawler.post(SMS_URL, entity);

			log.info("request.sms.interface,entity={},result.httpcode={},result.content={}",params.toString(),result.getLeft(), result.getRight());
			System.out.println(result);
			System.out.println(result.getRight());
			System.out.println(result.getLeft());
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
		System.out.println( sendSMSText("15810964799","测试撒打算123458787") );
	}

}
