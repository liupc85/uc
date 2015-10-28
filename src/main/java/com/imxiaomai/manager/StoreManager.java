package com.imxiaomai.manager;

import java.util.List;

import com.imxiaomai.persistence.domain.Store;



public interface StoreManager {
	
	int updateSelective(Store store);
	
	public  Store getById( Long id);

	public  List<Store> getAll();

	public  Store getByCollegeId( Store store);

	public  int update( Long id, String short_address, String take_express_phone);
	
	public  int update( Long id,  String short_address,  String take_express_phone,  String latest_business_time);

	public List<Store> getByStatus(Integer status);
}
