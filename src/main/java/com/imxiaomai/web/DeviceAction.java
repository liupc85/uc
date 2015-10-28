package com.imxiaomai.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.imxiaomai.base.util.JsonUtil;
import com.imxiaomai.persistence.domain.CourierDevice;
import com.imxiaomai.persistence.domain.Device;
import com.imxiaomai.service.DeviceService;
import com.imxiaomai.web.base.BaseController;

@Controller
public class DeviceAction extends BaseController{
	
	
	@Resource
	private DeviceService deviceService;

	@RequestMapping("/device/addOrUpdate")
	@ResponseBody
	public Object addOrUpdate(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);
		final Integer userId = jsonNode.findValue("userId").asInt();
		final String mobilePhone = jsonNode.findValue("mobilePhone") != null?jsonNode.findValue("mobilePhone").asText():"";
		final String deviceId = jsonNode.findValue("deviceId") != null?jsonNode.findValue("deviceId").asText():"";
		final String channelId = jsonNode.findValue("channelId") != null?jsonNode.findValue("channelId").asText():"";
		final String source = jsonNode.findValue("source") != null?jsonNode.findValue("source").asText():"";
		final String platform = jsonNode.findValue("platform") != null?jsonNode.findValue("platform").asText():"";
		final String version = jsonNode.findValue("version") != null?jsonNode.findValue("version").asText():"";
		final String srcChannel = jsonNode.findValue("srcChannel") != null?jsonNode.findValue("srcChannel").asText():"";
		final String lastUpdateChannel = jsonNode.findValue("lastUpdateChannel") != null?jsonNode.findValue("lastUpdateChannel").asText():"";
		final String baiduUserId = jsonNode.findValue("baiduUserId") != null ?jsonNode.findValue("baiduUserId").asText():"";
		final String packageName = jsonNode.findValue("packageName") != null ? jsonNode.findValue("packageName").asText() : "com.xiaomai.express";
		String msg = null;
		if(packageName.equals("com.xiaomai.express")){
			Device device = new Device(userId,mobilePhone,deviceId,channelId,source,platform,version,srcChannel,lastUpdateChannel, new Date(), new Date(), baiduUserId);
			int index = deviceService.addOrUpdate(packageName, device, null);
			msg = "操作"+(index == 0 ? "失败" : "成功") ;
		}
		if(packageName.equals("com.xiaomai.courier")){
			CourierDevice courierDevice = new CourierDevice(userId,mobilePhone,deviceId,channelId,source,platform,version,srcChannel,lastUpdateChannel, new Date(), new Date(), baiduUserId);
			int index = deviceService.addOrUpdate(packageName, null, courierDevice);
			msg = "操作"+(index == 0 ? "失败" : "成功") ;
		}
		return buildJson(0, msg);
	}

	@RequestMapping("/device/updateById")
	@ResponseBody
	public Object updateById(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);
		final long id = jsonNode.findValue("id").asLong();
		final String key = jsonNode.findValue("key").asText();
		final String val = jsonNode.findValue("value").asText();
		int index = deviceService.updateById(id, key, val);
		return buildJson(0,"修改"+(index == 0 ? "失败" : "成功"));
	}

	@RequestMapping("/device/getByDeviceId")
	@ResponseBody
	public Object getByDeviceId(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);
		final long id = jsonNode.findValue("id").asLong();
		Device device=deviceService.getByDeviceId(id);
		if(device==null){
			device=new Device(); 
		}
		return buildJson(0,"",device);
	}

	@RequestMapping("/device/getByUserId")
	@ResponseBody
	public Object getByUserId(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);
		final long userId = jsonNode.findValue("userId").asLong();
		return buildJsonAddFoo(0, "", deviceService.getByUserId(userId));
//		return buildJson(0,"",deviceService.getByUserId(userId));
	}

	@RequestMapping("/device/getNewByUserId")
	@ResponseBody
	public Object getNewByUserId(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);
		final long userId = jsonNode.findValue("userId").asLong();
		return buildJsonAddFoo(0, "", deviceService.getNewByUserId(userId));
//		return buildJson(0,"",deviceService.getNewByUserId(userId));
	}

}
