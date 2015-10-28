package com.imxiaomai.dao.impl;


import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.ExpressPriceSfDao;
import com.imxiaomai.persistence.domain.ExpressPriceSf;
import com.imxiaomai.persistence.mapper.ExpressPriceSfMapper;

public class ExpressPriceSfDaoImpl extends BaseDao implements  ExpressPriceSfDao {
	
	public  ExpressPriceSf getByFromAreaIdAndToAreaId(Long fromAreaId, Long toAreaId) {
		ExpressPriceSf record=new ExpressPriceSf();
		record.setFromareaid(fromAreaId.intValue());
		record.setToareaid(toAreaId.intValue());	
		return this.getSqlSession().getMapper(ExpressPriceSfMapper.class).getByFromAreaIdAndToAreaId(record);
//		return validate(tmp);
	}
	
	/**
	  * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
	  * @param record
	  * @return
	  */
	 private ExpressPriceSf validate(ExpressPriceSf record){
	 	if(record==null){
	 		return new ExpressPriceSf();
	 	}else{
	 		return record;
	 	}
	 }
}
