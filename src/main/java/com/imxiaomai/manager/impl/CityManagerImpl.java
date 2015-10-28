package com.imxiaomai.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import java.io.Serializable;
import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.CityDao;
import com.imxiaomai.manager.CityManager;
import com.imxiaomai.persistence.domain.City;


public class CityManagerImpl  extends BaseManager implements CityManager, Serializable  {
	
	@Resource
	private CityDao cityDao;

	@Override
	public List<City> getByProvinceId(Long province_id) {
		if(province_id == null){
			return new ArrayList<City>();
		}
		
		if(province_id <= 0 ){
			return new ArrayList<City>();
		}
		
		return cityDao.getByProvinceId(province_id);
	}

	@Override
	public City getById(Long id) {
		if(id == null){
			return null;
		}
		
		if(id <= 0){
			return null;
		}
		return cityDao.getById(id);
	}

	@Override
	public List<City> getAll() {
		// TODO Auto-generated method stub
		return cityDao.getAll();
	}
	

}
