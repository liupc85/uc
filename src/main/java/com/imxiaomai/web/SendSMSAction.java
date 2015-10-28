package com.imxiaomai.web;

import static com.imxiaomai.base._.isEmpty;
import static com.imxiaomai.base._.randInt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.imxiaomai.base.crawler.Crawler;
import com.imxiaomai.base.toolkit.DateUtil;
import com.imxiaomai.base.util.JsonUtil;
import com.imxiaomai.persistence.domain.SmsRecords;
import com.imxiaomai.service.SmsRecordsService;
import com.imxiaomai.util.SMSUtil;
import com.imxiaomai.util.SMSUtilForMK;
import com.imxiaomai.web.base.BaseController;

@Controller
public class SendSMSAction extends BaseController {

	private static Logger log=LoggerFactory.getLogger(SendSMSAction.class);
	
	@Autowired SmsRecordsService smsRecordsService;
	
	@RequestMapping("/generalSms/sendCode")
	@ResponseBody
	public Object sendSmsCode(HttpServletRequest request) throws SQLException, IOException {
		String phone = request.getParameter("phone");
		if (isEmpty(phone) || !phone.startsWith("1") || phone.length() != 11) {
			return buildJson(-1, "手机号码错误");
		}
		String template = "您的验证码：{}，10分钟内有效，请尽快使用 ";
		String opType = "registerorreset";
		
		String smscode = "";
		for (int i = 0; i < 4; i++) {
			smscode += randInt(9);
		}
		template = template.replace("{}", smscode);
		SMSUtilForMK.sendSMSText(phone, template);
		smsRecordsService.insert(phone, smscode, opType);
		return buildJson(0, "成功");
	}

	@RequestMapping("/generalSms/checkCode")
	@ResponseBody
	public Object checkSmsCode(HttpServletRequest request) throws SQLException, IOException {

		String smscode = request.getParameter("smscode");
		String phone = request.getParameter("phone");
		if (isEmpty(phone) || !phone.startsWith("1") || phone.length() != 11) {
			return buildJson(-1, "手机号码错误");
		}
		if (isEmpty(smscode)) {
			return buildJson(-1, "验证码不能为空");
		}

		SmsRecords records = smsRecordsService.getNewsByTelPhone(phone, "registerorreset");
		if (records == null||records.getId() == null||records.getId() == 0|| !smscode.equalsIgnoreCase(records.getSmscode())) {
			return buildJson(-1, "校验失败，请检查验证码是否正确或者重试");
		}
		Date d=records.getCreatetime();
		Date expire=DateUtils.addMinutes(d, 10);
		if(new Date().after(expire)){
			return buildJson(-1, "验证码已失效，请重新获取");
		}
		return buildJson(0, "成功");
	}
	
	
	@RequestMapping("/generalSms/groupSendSms")
	@ResponseBody
	public Object groupSendSms(HttpServletRequest request) throws SQLException, IOException {
		
		String data = getDataFromRequest(request);	
		log.info("groupSendSms \t", data);
		JsonNode jsonNode = JsonUtil.parse(data);
		JsonNode jsonNode2 = jsonNode.findValue("data");
		Iterator it=jsonNode2.iterator();
		while(it.hasNext()){
			JsonNode node =(JsonNode )it.next();
			String phone=node.findValue("phone").asText();
			String text=node.findValue("text").asText();
			SMSUtilForMK.sendSMSText(phone, text);
		}
		return buildJson(0, "成功");
	}
	
	
	
	@RequestMapping("/send/sendSms")
	@ResponseBody
	public Object sendSms(HttpServletRequest request){
		String phone=request.getParameter("phone");
		String content=request.getParameter("content");
		boolean hasSend=SMSUtil.sendSMSText(phone, content);
//		boolean hasSend=send(SMS_USER_NAME, SMS_PASSWORD, phone, content);
		if(hasSend){
			return buildJson(0, "发送成功");	
		}else{
			return buildJson(-1, "发送失败");	
		}
		
	}
	
}
