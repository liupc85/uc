package com.imxiaomai.service;

import java.util.List;

import com.google.gson.JsonObject;
import com.imxiaomai.persistence.domain.Area;
import com.imxiaomai.persistence.domain.City;
import com.imxiaomai.persistence.domain.Country;
import com.imxiaomai.persistence.domain.Province;



public interface CityService {
	
	/**
	 * 查询国家
	 * @return
	 */
	List<Country>  getAllCountry();
	
	/**
	 * 查询城市
	 * @param id
	 * @param provinceId
	 * @return
	 */
	List<City> getCity(long id,long provinceId);
	
	/**
	 * 查询省市
	 * @param id
	 * @return
	 */
	List<Province> getProvince(long id);

	
	/**
	 * 查询区域
	 * @param cityId
	 * @param id
	 * @return
	 */
	List<Area> getArea(long cityId,long id);
	
	/**
	 * 查询全部区域
	 * @return
	 */
	String  areaAll();

	String cityAll();
}
