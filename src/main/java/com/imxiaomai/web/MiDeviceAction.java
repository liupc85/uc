package com.imxiaomai.web;

import static com.imxiaomai.base._.isEmpty;

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
import com.imxiaomai.persistence.domain.CourierMidevice;
import com.imxiaomai.persistence.domain.Midevice;
import com.imxiaomai.service.MiDeviceService;
import com.imxiaomai.web.base.BaseController;

@Controller
public class MiDeviceAction extends BaseController{
	
	@Resource 
	MiDeviceService miDeviceService;
	
	@RequestMapping("/app/getRegId")
	@ResponseBody
	public Object getRegId(HttpServletRequest request) throws IOException, SQLException{
		String json = getDataFromRequest(request);
		if( isEmpty(json) )
			return buildErrJson("参数错误");
		JsonNode jsonNode = JsonUtil.parse(json);
		if( jsonNode == null )
			return buildErrJson("参数格式错误");
		Long userId = jsonNode.findValue("userId")!=null ? jsonNode.findValue("userId").asLong() : 0;
		String mobilePhone = jsonNode.findValue("mobilePhone")!=null ? jsonNode.findValue("mobilePhone").asText() : "";
		String deviceId = jsonNode.findValue("deviceId")!=null ? jsonNode.findValue("deviceId").asText() : "";
		String platform = jsonNode.findValue("platform")!=null ? jsonNode.findValue("platform").asText() : "";
		String version = jsonNode.findValue("version")!=null ? jsonNode.findValue("version").asText() : "";
		String srcChannel = jsonNode.findValue("srcChannel")!=null ? jsonNode.findValue("srcChannel").asText() : "";
		String regId = jsonNode.findValue("regId")!=null ? jsonNode.findValue("regId").asText() : "";
		String packageName = jsonNode.findValue("packageName")!=null ? jsonNode.findValue("packageName").asText() : "";
		String msg = null;
		if(packageName.equals("com.xiaomai.express")){
			Midevice device = new Midevice(userId.intValue(),  mobilePhone,deviceId,  platform,  version,srcChannel, new Date(), new Date(),  regId);
			int index = miDeviceService.addOrUpdate(packageName, device, null);
			msg = (index == 0 ? "添加成功" : "修改成功");
		}
		if(packageName.equals("com.xiaomai.courier")){
			CourierMidevice md = new CourierMidevice(userId.intValue(),  mobilePhone,deviceId,  platform,  version,srcChannel, new Date(), new Date(),  regId);
			int index = miDeviceService.addOrUpdate(packageName, null, md);
			msg = (index == 0 ? "添加成功" : "修改成功");
		}
		return buildJson(0, msg);
	}

	
}
