package com.imxiaomai.dao.impl;

import java.util.List;

import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.StoreExpressDao;
import com.imxiaomai.persistence.domain.StoreExpress;
import com.imxiaomai.persistence.mapper.StoreExpressMapper;


public class StoreExpressDaoImpl extends BaseDao implements StoreExpressDao {
	public int insert(StoreExpress record) {
		return this.getSqlSession().getMapper(StoreExpressMapper.class).insert(record);
	}

	public  List<StoreExpress> getAll() {
		StoreExpress record=new StoreExpress ();
		return this.getSqlSession().getMapper(StoreExpressMapper.class).selectAll(record);
	}

	public  StoreExpress getByStoreId(Long storeId) {
		return this.getSqlSession().getMapper(StoreExpressMapper.class).selectByPrimaryKey(storeId.intValue());
//		return validate(tmp);
	}
	
	
	/**
	  * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
	  * @param record
	  * @return
	  */
	 private StoreExpress validate(StoreExpress record){
	 	if(record==null){
	 		return new StoreExpress();
	 	}else{
	 		return record;
	 	}
	 }
}
