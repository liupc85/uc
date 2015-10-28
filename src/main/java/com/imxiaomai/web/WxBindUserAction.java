package com.imxiaomai.web;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.imxiaomai.base.util.JsonUtil;
import com.imxiaomai.persistence.domain.WxBindUser;
import com.imxiaomai.service.WxBindUserService;
import com.imxiaomai.web.base.BaseController;

@Controller
public class WxBindUserAction extends BaseController {

	private Logger log=LoggerFactory.getLogger(WxBindUserAction.class);
	
	@Autowired WxBindUserService wxBindUserService;
	
	
/*	@RequestMapping("/bindUser/getUserIdByOpenId")
	@ResponseBody
	public Object getUserIdByOpenId( HttpServletRequest request) throws SQLException, IOException {
		
		String openId=request.getParameter("openId");
		log.info("openId :{} "+openId);
		if(StringUtils.isEmpty(openId)){
			return buildJson(-1, "openId为空", _.asMap("userId", 0)); 
		}
		WxBindUser wxbind = wxBindUserService.getByOpenId(openId);
		log.info("WxBindUser:{} "+wxbind);
		if(wxbind==null){
			return buildJson(-1, "没有相应用户", _.asMap("userId", 0)); 
		}
		return buildJson(0, "", _.asMap("userId", wxbind.getUserid())); 
	}*/
	
	
	@RequestMapping("/bindUser/getBindByOpenId")
	@ResponseBody
	public Object getBindByOpenId( HttpServletRequest request) throws SQLException, IOException {
		String data = getDataFromRequest(request);	
		JsonNode jsonNode = JsonUtil.parse(data);
		String openId=jsonNode.findValue("openId")!=null?jsonNode.findValue("openId").asText():"";
		log.info("openId :{} "+openId);
		if(StringUtils.isEmpty(openId)){
			return buildJson(-1, "openId为空", ""); 
		}
		WxBindUser wxbind = wxBindUserService.getByOpenId(openId);
		log.info("WxBindUser:{} "+wxbind);
		if(wxbind==null){
			return buildJson(-1, "没有相应用户",""); 
		}
		return buildJson(0, "",wxbind); 
	}
	
	
	@RequestMapping("/bindUser/getBindByUserId")
	@ResponseBody
	public Object getBindByUserId( HttpServletRequest request) throws SQLException, IOException {
		String data = getDataFromRequest(request);	
		JsonNode jsonNode = JsonUtil.parse(data);
		String userId=jsonNode.findValue("userId")!=null?jsonNode.findValue("userId").asText():"";
		System.out.println("userId :{} "+userId);
		log.info("userId :{} "+userId);
		if(StringUtils.isEmpty(userId)){
			return buildJson(-1, "userId为空", ""); 
		}
		WxBindUser wxbind = wxBindUserService.getByUserId(Long.parseLong(userId));
		log.info("WxBindUser:{} "+wxbind);
		if(wxbind==null){
			return buildJson(-1, "没有相应用户",""); 
		}
		return buildJson(0, "",wxbind); 
	}
	
	@RequestMapping("/bindUser/insertNewRecord")
	@ResponseBody
	public Object insertNewRecord( HttpServletRequest request) throws SQLException, IOException {
		String data = getDataFromRequest(request);	
		JsonNode jsonNode = JsonUtil.parse(data);
		String openId=jsonNode.findValue("openId")!=null?jsonNode.findValue("openId").asText():"";
		String nickname=jsonNode.findValue("nickName")!=null?jsonNode.findValue("nickName").asText():"";
		String headimgurl=jsonNode.findValue("headimgurl")!=null?jsonNode.findValue("headimgurl").asText():"";
		int sex=jsonNode.findValue("sex")!=null?jsonNode.findValue("sex").asInt():0;
		int bind=jsonNode.findValue("bind")!=null?jsonNode.findValue("bind").asInt():0;
		int userId=jsonNode.findValue("userId")!=null?jsonNode.findValue("userId").asInt():0;
		System.out.println("nickname "+nickname);
//		CharSequence source=nickname
		String filter_name=EmojiFilter.filter(nickname);//.filterEmoji(nickname);
		System.out.println("filter_name "+filter_name);
		long res=wxBindUserService.newRecord(openId, nickname, sex, headimgurl,bind,userId);
		
		if(res>0){
			return buildJson(0, "插入成功"); 
		}else{
			return buildJson(-1, "插入失败"); 
		}
		
	}
	
	
	
}
