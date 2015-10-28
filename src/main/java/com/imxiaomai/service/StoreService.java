package com.imxiaomai.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.imxiaomai.persistence.domain.Store;


public interface StoreService {
	
	int updateSelective(Store store);
	
	List<Store> getStore(long id);
	
	public  Store getById( Long id);

	public  List<Store> getAll();

	public  Store getByCollegeId(Store store);

	public  int update( Long id, String short_address, String take_express_phone);
	
	public  int update( Long id,  String short_address,  String take_express_phone,  String latest_business_time);
	
	public Map<String ,Object>  toMap(Store store) throws SQLException;

	public List<Store> getByStatusExpress(Integer status, List<String>dispatch_ids);

	public List<Store> getByStatusExpress(Integer status, List<String>dispatch_ids, String areaId);

	public List<Store> getByStatusExpress(Integer status, List<String>dispatch_ids, String areaId, String cityId);
}
