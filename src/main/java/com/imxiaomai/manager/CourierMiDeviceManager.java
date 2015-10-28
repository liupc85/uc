package com.imxiaomai.manager;

import java.util.List;

import com.imxiaomai.persistence.domain.CourierMidevice;


public interface CourierMiDeviceManager { 
	
	public int insert(CourierMidevice record);

	public <T> int updateByPair(  String name,  T val,Integer id) ;
	
	public   int update(String mobilePhone, String deviceId, String platform, String version, String srcChannel, String regId, Integer id);

	public   List<CourierMidevice> getByUserId(  Long userId) ;

	public   CourierMidevice getNewByUserId(  Long  userId);

	public   CourierMidevice getById( Long id)  ;
	
	public   CourierMidevice getByDeviceId( String deviceId);
	
	public   CourierMidevice getByDeviceIdAndMobilePhone( String deviceId,  String mobilePhone);
	
	
}
