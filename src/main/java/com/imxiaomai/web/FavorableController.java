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
import com.imxiaomai.persistence.domain.StoreFavorable;
import com.imxiaomai.service.FavorableService;
import com.imxiaomai.web.base.BaseController;

@Controller
public class FavorableController extends BaseController{
	
	@Resource 
	FavorableService favorableService;

	@RequestMapping("/store/favorable")
	@ResponseBody
	public Object storeFavorable(HttpServletRequest request) throws IOException, SQLException {
		final String data = getDataFromRequest(request);
		JsonNode node = JsonUtil.parse(data);
		long storeId = node.findValue("storeId") != null ? node.findValue("storeId").asLong() : 0;
		int type = node.findValue("type") != null ? node.findValue("type").asInt() : 0;
		List<StoreFavorable> storeFavorables = favorableService.storeFavorable(storeId, type);
		return buildJsonAddFoo(0, "", storeFavorables);
//		return buildJson(0,"",storeFavorables);
	}
}
