package com.imxiaomai.dao.impl;

import java.util.List;

import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.StoreDao;
import com.imxiaomai.persistence.domain.Store;
import com.imxiaomai.persistence.mapper.StoreMapper;


public class StoreDaoImpl extends BaseDao implements StoreDao {
	
	public int updateSelective(Store store){
		
		store.setUpdateTime(time(System.currentTimeMillis()));
		return this.getSqlSession().getMapper(StoreMapper.class).updateByPrimaryKeySelective(store);
		
	}
	
	
	public  Store getById( Long id) {
		return this.getSqlSession().getMapper(StoreMapper.class).selectByPrimaryKey(id.intValue());
	}

	public List<Store> getAll() {
		Store record=new Store();
		record.setIsdel(0);
		return this.getSqlSession().getMapper(StoreMapper.class).getAll(record);
	}

	@Override
	public List<Store> getByCondition(Store store) {
		return this.getSqlSession().getMapper(StoreMapper.class).getByCondition(store);
	}

	public  Store getByCollegeId( Store store ) {
		return this.getSqlSession().getMapper(StoreMapper.class).getByCollegeId(store);
//		return validate(tmp);
	}

	public  int update( Long id, String short_address, String take_express_phone) {
		Store record=new Store();
		record.setId(id.intValue());
		record.setShortAddress(short_address);
		record.setTakeExpressPhone(take_express_phone);
		return this.getSqlSession().getMapper(StoreMapper.class).updateBySomeCondition(record);
	}
	
	public  int update( Long id,  String short_address,  String take_express_phone,  String latest_business_time) {
		Store record=new Store();
		record.setId(id.intValue());
		record.setShortAddress(short_address);
		record.setTakeExpressPhone(take_express_phone);
		record.setLatestBusinessTime(latest_business_time);
		return this.getSqlSession().getMapper(StoreMapper.class).updateBySomeCondition(record);
	}
	
	/**
	  * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
	  * @param record
	  * @return
	  */
	 private Store validate(Store record){
	 	if(record==null){
	 		return new Store();
	 	}else{
	 		return record;
	 	}
	 }

}
