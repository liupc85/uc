package com.imxiaomai.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.CountryDao;
import com.imxiaomai.manager.CountryManager;
import com.imxiaomai.persistence.domain.Country;


public class CountryManagerImpl  extends BaseManager implements CountryManager  {
	
	@Resource
	private CountryDao  countryDao;

	@Override
	public List<Country> getAllCountry() {
		return countryDao.getAllCountry();
	}
	
}
