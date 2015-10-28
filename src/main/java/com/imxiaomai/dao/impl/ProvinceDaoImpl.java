package com.imxiaomai.dao.impl;

import java.util.List;



import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.ProvinceDao;
import com.imxiaomai.persistence.domain.Province;
import com.imxiaomai.persistence.mapper.ProvinceMapper;


public class ProvinceDaoImpl extends BaseDao implements ProvinceDao{

	public  Province getById(Long id) {
		return this.getSqlSession().getMapper(ProvinceMapper.class).selectByPrimaryKey(id.intValue());
//		return validate(tmp);
	}

	public  List<Province> getAll() {
		return this.getSqlSession().getMapper(ProvinceMapper.class).selectAll();
	}
	
	/**
	  * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
	  * @param record
	  * @return
	  */
	 private Province validate(Province record){
	 	if(record==null){
	 		return new Province();
	 	}else{
	 		return record;
	 	}
	 }
	
}
