package com.imxiaomai.dao.impl;

import java.util.List;


import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.CountryDao;
import com.imxiaomai.persistence.domain.Country;
import com.imxiaomai.persistence.mapper.CountryMapper;

public class CountryDaoImpl extends BaseDao implements CountryDao{
	
    public  List<Country> getAllCountry() {
    	Country c=new Country();
    	c.setLevel(1);
    	c.setIsdel((short)0);
    	return this.getSqlSession().getMapper(CountryMapper.class).getAllCountry(c);
    }
	
}
