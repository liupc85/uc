package com.imxiaomai.dao.impl;

import java.util.ArrayList;
import java.util.List;



import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.CityDao;
import com.imxiaomai.persistence.mapper.CityMapper;
import com.imxiaomai.persistence.domain.City;
import com.imxiaomai.persistence.domain.College;

public class CityDaoImpl extends BaseDao implements CityDao{

	public  List<City> getByProvinceId(Long province_id){
		City record=new City();
		record.setProvinceId(province_id.intValue());
		if(province_id==null||province_id.longValue()==0){
			return new ArrayList<City>();
		}
		return this.getSqlSession().getMapper(CityMapper.class).selectBySomeCondition(record);
	}

	public  City getById(Long id){
		City tmp=this.getSqlSession().getMapper(CityMapper.class).selectByPrimaryKey(id.intValue());
		return validate(tmp);
	}

	public  List<City> getAll(){
		City record=new City();
		return this.getSqlSession().getMapper(CityMapper.class).selectAll();
	}
	
	/**
	  * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
	  * @param record
	  * @return
	  */
	 private City validate(City record){
	 	if(record==null){
	 		return new City();
	 	}else{
	 		return record;
	 	}
	 }

}
