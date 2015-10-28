package com.imxiaomai.dao.impl;

import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.AreaDao;
import com.imxiaomai.persistence.domain.Area;
import com.imxiaomai.persistence.mapper.AreaMapper;

import java.util.*;

public class AreaDaoImpl  extends BaseDao implements AreaDao{
    
	public  List<Area> getByCityId(Long cityId) {
		return this.getSqlSession().getMapper(AreaMapper.class).getByCityId(cityId.intValue());
	}

	public  Area getById(Long id){
		Area tmp= this.getSqlSession().getMapper(AreaMapper.class).selectByPrimaryKey(id.intValue());
		return validate(tmp);
	}

	public  List<Area> getAll() {
		return this.getSqlSession().getMapper(AreaMapper.class).selectAll();
		
	}
	
	/**
	  * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
	  * @param record
	  * @return
	  */
	 private Area validate(Area record){
	 	if(record==null){
	 		return new Area();
	 	}else{
	 		return record;
	 	}
	 }

    
}