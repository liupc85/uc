package com.imxiaomai.web;

import static com.imxiaomai.base._.asMap;
import static com.imxiaomai.base._.isEmpty;
import static com.imxiaomai.base._.randInt;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.imxiaomai.base.util.JsonUtil;
import com.imxiaomai.persistence.domain.SmsRecords;
import com.imxiaomai.service.SmsRecordsService;
import com.imxiaomai.web.base.BaseController;

@Controller
public class SmsRecordsAction extends BaseController{

	private static final int EXPIRE_SEC = 5*60*1000;
	
	@Resource
	private SmsRecordsService smsRecordsService;

	@RequestMapping("/smsrecords/getSmsCode")
	@ResponseBody
	public Object get(HttpServletRequest request) throws IOException, SQLException {
		String json = getDataFromRequest(request);
		JsonNode jsonObject = JsonUtil.parse(json);
		final String telPhone = jsonObject.findValue("telPhone") != null ? jsonObject.findValue("telPhone").asText() : "";
		final String action = jsonObject.findValue("action") != null ? jsonObject.findValue("action").asText() : "";
		if(isEmpty(telPhone) || isEmpty(action)){
			return buildJson(-1, "参数错误");
		}
		String smsCode = smsRecordsService.getSmsCode(telPhone, action);
		return buildJson(0, "", asMap("smsCode", smsCode));
	}

	@RequestMapping("/smsrecords/check")
	@ResponseBody
	public Object check(HttpServletRequest request) throws IOException, SQLException {
		String json = getDataFromRequest(request);
		JsonNode jsonObject = JsonUtil.parse(json);
		final String telPhone = jsonObject.findValue("telPhone") != null ? jsonObject.findValue("telPhone").asText() : "";
		final String smsCode = jsonObject.findValue("smsCode") != null ? jsonObject.findValue("smsCode").asText() : "";
		final String action = jsonObject.findValue("action") != null ? jsonObject.findValue("action").asText() : "";
		if(isEmpty(telPhone) || isEmpty(action) || isEmpty(smsCode)){
			return buildJson(-1, "参数错误");
		}
		SmsRecords sms = smsRecordsService.getNewsByTelPhone(telPhone, action);
		if(sms !=null){
			if(sms.getSmscode().equals(smsCode)){
				return buildJson(0, "成功");
			}else{
				return buildJson(-1, "失败");
			}
		}else{
			return buildJson(-1, "失败");
		}

	}
	
	
	@RequestMapping("/smsrecords/insertRecord")
	@ResponseBody
	public Object insertRecord(HttpServletRequest request) throws IOException, SQLException {
		String json = getDataFromRequest(request);

		JsonNode jsonObject = JsonUtil.parse(json);
		final String telPhone = jsonObject.findValue("telPhone") != null ? jsonObject.findValue("telPhone").asText() : "";
		final String action = jsonObject.findValue("action") != null ? jsonObject.findValue("action").asText() : "";
		final String smsCode= jsonObject.findValue("smsCode") != null ? jsonObject.findValue("smsCode").asText() : "";
		if(isEmpty(telPhone) || isEmpty(action)||isEmpty(smsCode)){
			return buildJson(-1, "参数错误");
		}
		int res = smsRecordsService.insert(telPhone, smsCode, action);
		if(res>0){
			return buildJson(0, "插入记录成功" );
		}else{
			return buildJson(-1, "插入记录失败");
		}
		
	}
	
	
	

}
