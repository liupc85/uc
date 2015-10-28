package com.imxiaomai.service.impl;




import java.util.*;
import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.imxiaomai.manager.AreaManager;
import com.imxiaomai.manager.CityManager;
import com.imxiaomai.manager.CountryManager;
import com.imxiaomai.manager.ProvinceManager;
import com.imxiaomai.persistence.domain.Area;
import com.imxiaomai.persistence.domain.City;
import com.imxiaomai.persistence.domain.Country;
import com.imxiaomai.persistence.domain.Province;
import com.imxiaomai.service.CityService;

public class CityServiceImpl implements CityService {
	
	@Resource
	private CountryManager countryManager;
	@Resource
	private CityManager cityManager;
	@Resource
	private ProvinceManager provinceManager;
	@Resource
	private AreaManager areaManager;

	@Override
	public List<Country> getAllCountry() {
		List<Country>  list = countryManager.getAllCountry();
		return list;
	}

	@Override
	public List<City> getCity(long id, long provinceId) {
		List<City> cityInfos;
		if(provinceId != 0){
			cityInfos =   cityManager.getByProvinceId(provinceId);
		}else if( id != 0 ){
			cityInfos = Arrays.asList(cityManager.getById(id));
		}else{
			cityInfos = cityManager.getAll();
		}
		return cityInfos;
	}

	@Override
	public List<Province> getProvince(long id) {
		List<Province> provinceInfos = new ArrayList<Province>();
		if(id != 0){
			provinceInfos = Arrays.asList(provinceManager.getById(id));
		}else{
			provinceInfos = provinceManager.getAll();
		}
		return provinceInfos;
	}

	@Override
	public List<Area> getArea(long cityId, long id) {
		List<Area> areaInfos;
		if( id != 0 ){
			areaInfos = Arrays.asList(areaManager.getById(id));
		}else if( cityId != 0 ){
			areaInfos = areaManager.getByCityId(cityId);
		}else{
			areaInfos = areaManager.getAll();
		}
		return areaInfos;
	}

	@Override
	public String areaAll() {
		List<Province> provinceInfos = provinceManager.getAll();
		Map<Province,Map<City,List<Area>>> result = new LinkedHashMap<>();
		for(Province p : provinceInfos ){
			Map<City,List<Area>> tmp = new LinkedHashMap<>();
			List<City> cityInfos = cityManager.getByProvinceId(Long.valueOf(p.getId().toString()));
			for( City c : cityInfos ){
				tmp.put(c,areaManager.getByCityId(Long.valueOf(c.getId().toString())));
			}
			result.put(p,tmp);
		}
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("code",0);
		jsonObject.addProperty("msg","");
		
		
		JsonObject properties = new JsonObject();

		for(Province p : result.keySet() ){

			JsonObject citys = new JsonObject();
			for( City c : result.get(p).keySet() ){
				JsonArray areaArrays = new JsonArray();
				List<Area> areaInfos = result.get(p).get(c);
				for( Area areaInfo : areaInfos ){
						JsonObject jsonObject1 = new JsonObject();
						jsonObject1.addProperty("id",areaInfo.getId());
						jsonObject1.addProperty("name",areaInfo.getName());
						jsonObject1.addProperty("city_id",areaInfo.getCityId());
						jsonObject1.addProperty("cityName",cityManager.getById(areaInfo.getCityId().longValue()).getName());
						areaArrays.add(jsonObject1);
				}
				citys.add(c.getName(),areaArrays);
				citys.addProperty("id",c.getId());
				citys.addProperty("code",c.getCode());
			}

			properties.add(p.getName(),citys);
			properties.addProperty("id",p.getId());
		}

		jsonObject.add("data",properties);
		return jsonObject.toString();
		
	}

	@Override
	public String cityAll(){
		String ret = "";
		List<Province> provinceInfos = provinceManager.getAll();
		List<City> cityInfos = cityManager.getAll();
		JSONArray retJson = new JSONArray();
		for(Province province : provinceInfos){
			Map<String, Object> provinceDTO = new HashMap<String, Object>();
			List<City> cityList = new ArrayList<City>();
			for(City city : cityInfos){
				if(city.getProvinceId() == province.getId()){
					cityList.add(city);
				}
			}
			provinceDTO.put("id", province.getId());
			provinceDTO.put("name", province.getName());
			provinceDTO.put("cities",cityList);
			retJson.add(provinceDTO);
//			retJson.put(pname, provinceDTO);
		}
		ret = retJson.toJSONString();
		return ret;
	}
}
