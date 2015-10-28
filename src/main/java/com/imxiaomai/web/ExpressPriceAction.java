package com.imxiaomai.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.imxiaomai.base._;
import com.imxiaomai.base.util.JsonUtil;
import com.imxiaomai.entity.AreaInfo;
import com.imxiaomai.entity.CityInfo;
import com.imxiaomai.entity.ExpressPrice;
import com.imxiaomai.entity.ExpressPriceSf;
import com.imxiaomai.service.ExpressPriceService;
import com.imxiaomai.web.base.BaseController;

@Controller
public class ExpressPriceAction extends BaseController{
    
    private static final Logger log = LoggerFactory.getLogger(ExpressPriceAction.class);

    @Resource
    ExpressPriceService expressPriceService;
    
    @Deprecated
	@RequestMapping("/expressprice/listWithTotalPriceByArea")
	@ResponseBody
	public Object getListWithTotalPrice(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);
		long sourceAreaId = jsonNode.findValue("sourceAreaId") != null ? jsonNode.findValue("sourceAreaId").asLong() : 0;
		long targetAreaId = jsonNode.findValue("targetAreaId") != null ? jsonNode.findValue("targetAreaId").asLong() : 0;
		double weight = jsonNode.findValue("weight") != null ? jsonNode.findValue("weight").asDouble() : 1;
		weight = Math.ceil(weight);
		List<HashMap<String,Class>> resultList = expressPriceService.getListWithTotalPrice(sourceAreaId, targetAreaId, weight);
        return buildJson(0,"",resultList);
        
	}

	@Deprecated
	@RequestMapping("/expressprice/listByProvince")
    @ResponseBody
    public Object getList(HttpServletRequest request) throws IOException, SQLException {
        String data = getDataFromRequest(request);
        JsonNode jsonNode = JsonUtil.parse(data);
        long sourceProvinceId = jsonNode.findValue("sourceProvinceId") != null ? jsonNode.findValue("sourceProvinceId").asLong() : 0;
        long targetProvinceId = jsonNode.findValue("targetProvinceId") != null ? jsonNode.findValue("targetProvinceId").asLong() : 0;
        List<HashMap<com.imxiaomai.persistence.domain.ExpressPrice,Class>> resultList = expressPriceService.getList(sourceProvinceId, targetProvinceId);
        return buildJson(0,"",resultList);
    }
	
	
	@RequestMapping("/expressprice/listByStoreAndTargetCity")
    @ResponseBody
    public Object getListByStoreAndTargetCity(HttpServletRequest request) throws IOException, SQLException {
        String data = getDataFromRequest(request);
        JsonNode jsonNode = JsonUtil.parse(data);
        long storeId = jsonNode.findValue("storeId") != null ? jsonNode.findValue("storeId").asLong() : 0;
        long targetCityId = jsonNode.findValue("targetCityId") != null ? jsonNode.findValue("targetCityId").asLong() : 0;
        List<HashMap> resultList  = expressPriceService.getListByStoreAndTargetCity(storeId, targetCityId);
        return buildJson(0,"",resultList);
    }
	
	
	
	@RequestMapping("/expressprice/listWithTotalPriceByStoreAndTargetAreaId")
    @ResponseBody
    public Object getListWithTotalPriceByStoreAndTargetAreaId(HttpServletRequest request) throws IOException, SQLException {
        String data = getDataFromRequest(request);
        JsonNode jsonNode = JsonUtil.parse(data);
        long storeId = jsonNode.findValue("storeId") != null ? jsonNode.findValue("storeId").asLong() : 0;
        long targetAreaId = jsonNode.findValue("targetAreaId") != null ? jsonNode.findValue("targetAreaId").asLong() : 0;
        double weight = jsonNode.findValue("weight") != null ? jsonNode.findValue("weight").asDouble() : 1;
        weight = Math.ceil(weight);
        List<HashMap> resultList  = expressPriceService.getListWithTotalPriceByStoreAndTargetAreaId(storeId, targetAreaId, weight);
        return buildJson(0,"",resultList);
        
    }
	
	@RequestMapping("/expressprice/listByStoreAndArea")
	@ResponseBody
	public Object getListByStoreAndArea(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		log.debug("调用接口：/expressprice/listByStoreAndArea，参数:" + data);
		JsonNode jsonNode = JsonUtil.parse(data);
		long storeId = jsonNode.findValue("storeId") != null ? jsonNode.findValue("storeId").asLong() : 0;
		long fromAreaId = jsonNode.findValue("fromAreaId") != null ? jsonNode.findValue("fromAreaId").asLong() : 0;
		long toAreaId = jsonNode.findValue("toAreaId") != null ? jsonNode.findValue("toAreaId").asLong() : 0;
		double weight = jsonNode.findValue("weight") != null ? jsonNode.findValue("weight").asDouble() : 0;
		double ceilWeight = Math.ceil(weight);
		
		List<HashMap> resultList = expressPriceService.getListByStoreAndArea(storeId, fromAreaId, toAreaId, weight, ceilWeight);
		return buildJson(0,"",resultList);
	}
}
