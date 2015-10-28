package com.imxiaomai.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.imxiaomai.base.util.JsonUtil;
import com.imxiaomai.entity.AreaInfo;
import com.imxiaomai.entity.CityInfo;
import com.imxiaomai.entity.ProvinceInfo;
import com.imxiaomai.persistence.domain.Area;
import com.imxiaomai.persistence.domain.City;
import com.imxiaomai.persistence.domain.Country;
import com.imxiaomai.persistence.domain.Province;
import com.imxiaomai.service.CityService;
import com.imxiaomai.web.base.BaseController;

@Controller
public class CityAction extends BaseController{
	
	@Resource
	private CityService cityService;
	
	@RequestMapping("/country/get")
	@ResponseBody
	public Object getCountry(HttpServletRequest request) throws IOException, SQLException {
		List<Country> countryInfos = cityService.getAllCountry();
		return buildJsonAddFoo(0, "", countryInfos);
//		return buildJson(0, "", countryInfos);
	}

	@RequestMapping("/city/get")
	@ResponseBody
	public Object getCity(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);
		long id = jsonNode.findValue("id") != null ? jsonNode.findValue("id").asLong() : 0;
		long pid = jsonNode.findValue("province_id") != null ? jsonNode.findValue("province_id").asInt() : 0;
		List<City> cityInfos = cityService.getCity(id, pid);
		return buildJsonAddFoo(0, "", cityInfos);
//		return buildJson(0,"",cityInfos);
	}

	@RequestMapping("/province/get")
	@ResponseBody
	public Object getProvince(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);
		long id = jsonNode.findValue("id") != null ? jsonNode.findValue("id").asLong() : 0;
		List<Province> provinceInfos = cityService.getProvince(id);
		return buildJsonAddFoo(0, "", provinceInfos);
//		return buildJson(0,"",provinceInfos);
	}

	@RequestMapping("/area/get")
	@ResponseBody
	public Object getArea(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);
		long cityId = jsonNode.findValue("cityId") != null ? jsonNode.findValue("cityId").asLong() : 0;
		long id = jsonNode.findValue("id") != null ? jsonNode.findValue("id").asLong() : 0;
		List<Area> areaInfos = cityService.getArea(cityId, id);
		return buildJsonAddFoo(0, "", areaInfos);
//		return buildJson(0,"",areaInfos);
	}

	@RequestMapping("/area/all")
	@ResponseBody
	public Object areaAll(HttpServletRequest request) throws SQLException {
		return cityService.areaAll();
//		return buildJson(0,"",cityService.areaAll());
	}

	@RequestMapping("/city/all")
	@ResponseBody
	public Object cityAll(HttpServletRequest request) throws SQLException {
		return cityService.cityAll();
//		return buildJson(0,"",cityService.areaAll());
	}
}
