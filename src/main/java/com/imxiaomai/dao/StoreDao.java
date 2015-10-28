package com.imxiaomai.dao;

import java.util.List;

import com.imxiaomai.persistence.domain.Store;



public interface StoreDao {
	
	public int updateSelective(Store store);
	
	public  Store getById( Long id);

	public  List<Store> getAll();

	public List<Store> getByCondition(Store store);

	public  Store getByCollegeId( Store store );

	public  int update( Long id, String short_address, String take_express_phone);
	
	public  int update( Long id,  String short_address,  String take_express_phone,  String latest_business_time);
}
