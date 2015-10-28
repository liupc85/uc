package com.imxiaomai.service.impl;


import java.sql.SQLException;
import java.util.*;

import javax.annotation.Resource;

import com.imxiaomai.manager.*;
import com.imxiaomai.persistence.domain.*;
import com.imxiaomai.service.StoreService;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class StoreServiceImpl implements StoreService {
	
	@Resource
	StoreManager storeManager;
	
	@Resource
	ProvinceManager provinceManager;
	
	@Resource
	AreaManager areaManager;
	
	@Resource
	CityManager cityManager;
	
	@Resource
	CollegeManager collegeManager;
	
	private static Logger logger = Logger.getLogger(StoreServiceImpl.class);

	public int updateSelective(Store store){
		return storeManager.updateSelective(store);
	}
	
	
	@Override
	public List<Store> getStore(long id) {
		List<Store> storeInfos;
		if( id != 0 ){
			storeInfos = Arrays.asList(storeManager.getById(id));
		}else{
			storeInfos = storeManager.getAll();
		}
		return storeInfos;
	}


	@Override
	public  Store getById( Long id){
		return storeManager.getById(id);
	}
	
	@Override
	public  List<Store> getAll(){
		return storeManager.getAll();
	}
	
	@Override
	public  Store getByCollegeId( Store store){
		return storeManager.getByCollegeId(store);
	}
	
	@Override
	public  int update( Long id, String short_address, String take_express_phone){
		return storeManager.update(id, short_address, take_express_phone);
	}
	
	public  int update( Long id,  String short_address,  String take_express_phone,  String latest_business_time){
		return storeManager.update(id, short_address, take_express_phone, latest_business_time);
	}
	
	@Override
	public Map<String ,Object>  toMap(Store store) throws SQLException{
		Map<String ,Object> map= new HashMap<String ,Object> ();
		map.put("id", store.getId());
		map.put("name",store.getName());
		map.put("short_name", store.getShortName());
		map.put("owner", store.getOwner());
		map.put("phone", store.getPhone());
		if(store.getProvinceId()==null){
			store.setProvinceId(0);
		}
		map.put("province_id", store.getProvinceId());
		Province province = provinceManager.getById(new Long(store.getProvinceId()));
		map.put("province_name", province != null ? province.getName():"" );
		
		
		if(store.getCityId()==null){
			store.setCityId(0);
		}
		map.put("city_id", store.getCityId());
		City city = cityManager.getById(new Long(store.getCityId()));
		map.put("city_name", city != null ? city.getName() : "");

		
		if(store.getAreaId()==null){
			store.setAreaId(0);
		}
		map.put("area_id", store.getAreaId());
		Area area = areaManager.getById(new Long(store.getAreaId()));
		map.put("area_name", area  != null ? area.getName() : "");

		
		if(store.getCollegeId()==null){
			store.setCollegeId(0);
		}
		map.put("college_id", store.getCollegeId());
		College college = collegeManager.getById(new Long(store.getCollegeId()));
		map.put("college_name", college != null ? college.getName() : "");
		
		
		map.put("address", store.getAddress());
		map.put("short_address",store.getShortAddress());
		map.put("take_express_phone",store.getTakeExpressPhone());
		map.put("latest_business_time",store.getLatestBusinessTime());
		map.put("start_time",store.getStartTime());
		map.put("end_time",store.getEndTime());
		map.put("create_time", store.getCreateTime());
		//新加入门店揽件、派件、类型、级别、状态、编码
		map.put("receive_ids", store.getReceiveIds());
		map.put("dispatch_ids", store.getDispatchIds());
		map.put("operate_type", store.getOperateType());
		map.put("level", store.getLevel());
		map.put("status", store.getStatus());
		map.put("code", store.getCode());
		map.put("isP2p", store.getIsp2p());
		return map;
	}

	@Override
	public List<Store> getByStatusExpress(Integer status, List<String> dispatch_ids) {
		List<Store> stores = storeManager.getByStatus(status);
		if(ArrayUtils.isEmpty(dispatch_ids.toArray())){
			return stores;
		}
		List<Store> ret = new ArrayList<Store>();
		for(Store store : stores){
			List<String> storeDispatchIds = Arrays.asList(store.getDispatchIds().split(","));
			if(storeDispatchIds.containsAll(dispatch_ids) || dispatch_ids.isEmpty()){
				ret.add(store);
			}
		}
		return ret;
	}

	@Override
	public List<Store> getByStatusExpress(Integer status, List<String> dispatch_ids, String areaId, String cityIdStr) {
		if(StringUtils.isEmpty(cityIdStr)){
			return getByStatusExpress(status, dispatch_ids, areaId);
		}
		else{
			List<Store> stores = getByStatusExpress(status, dispatch_ids, areaId);
			try{
				Integer cityId = Integer.valueOf(cityIdStr);
				List<Store> ret = new ArrayList<Store>();
				for(Store store : stores){
					if(cityId.equals(store.getCityId())){
						ret.add(store);
					}
				}
				return ret;
			}catch (Exception e){
				logger.error("get store info by StatusExpress failed ",e);
			}
			return null;
		}
	}


	@Override
	public List<Store> getByStatusExpress(Integer status, List<String> dispatch_ids, String areaIdStr) {
		if(StringUtils.isEmpty(areaIdStr)) {
			return getByStatusExpress(status, dispatch_ids);
		}else{
			List<Store> stores = getByStatusExpress(status, dispatch_ids);
			try{
				Integer areaId = Integer.valueOf(areaIdStr);
				List<Store> ret = new ArrayList<Store>();
				for(Store store : stores){
					if(areaId.equals(store.getAreaId())){
						ret.add(store);
					}
				}
				return ret;
			}catch (Exception e){
				logger.error("get store info by StatusExpress failed ",e);
			}
			return null;
		}
	}


}
