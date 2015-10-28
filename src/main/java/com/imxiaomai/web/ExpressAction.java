package com.imxiaomai.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.databind.JsonNode;
import com.imxiaomai.base.util.JsonUtil;
import com.imxiaomai.persistence.domain.Express;
import com.imxiaomai.service.ExpressService;
import com.imxiaomai.web.base.BaseController;

@Controller
public class ExpressAction extends BaseController{
	
	@Resource
	private ExpressService expressService;

	@RequestMapping("/express/get")
	@ResponseBody
	public Object getExpress(HttpServletRequest request) throws IOException, SQLException {
		String json = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(json);
		long id = jsonNode.findValue("id") != null ? jsonNode.findValue("id").asLong() : 0;
		
		List<Express> expressInfos = expressService.getExpress(id);
		return buildJsonAddFoo(0, "", expressInfos);
//		return buildJson(0,"",expressInfos);
	}
	
	@RequestMapping("/express/getByShortName")
	@ResponseBody
	public Object getExpressByShortName(HttpServletRequest request) throws IOException, SQLException {
		String json = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(json);
		String shortName = jsonNode.findValue("shortName") != null ? jsonNode.findValue("shortName").asText() : "";
		List<Express> expressInfos = expressService.getExpressByShortName(shortName);
		return buildJsonAddFoo(0, "", expressInfos);
//		return buildJson(0,"",expressInfos);
	}
	
}
