package com.imxiaomai.manager;

import java.util.List;

import com.imxiaomai.persistence.domain.City;


public interface CityManager{
	
	public  List<City> getByProvinceId(Long province_id);

	public  City getById(Long id);

	public  List<City> getAll();

}
