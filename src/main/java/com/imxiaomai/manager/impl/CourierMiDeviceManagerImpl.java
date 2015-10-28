package com.imxiaomai.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.CourierMiDeviceDao;
import com.imxiaomai.manager.CourierMiDeviceManager;
import com.imxiaomai.persistence.domain.CourierMidevice;


public class CourierMiDeviceManagerImpl  extends BaseManager implements CourierMiDeviceManager{
	
	@Resource
	private CourierMiDeviceDao courierMiDeviceDao;

	@Override
	public int insert(CourierMidevice record) {
		if(record == null){
			return  0;
		}
		return courierMiDeviceDao.insert(record);
	}

	@Override
	public <T> int updateByPair(String name, T val,Integer id) {
		// TODO Auto-generated method stub
		return courierMiDeviceDao.updateByPair(name, val,id);
	}

	@Override
	public int update(String mobilePhone, String deviceId, String platform,
			String version, String srcChannel, String regId, Integer id) {
		if(null == mobilePhone || ("").equals(mobilePhone)){
			return 0;
		}
		System.out.println("deviceInfo id "+id);
		if(id==null||id == 0){
			return 0;
		}
		
		return courierMiDeviceDao.update(mobilePhone, deviceId, platform, version, srcChannel, regId, id);
	}

	@Override
	public List<CourierMidevice> getByUserId(Long userId) {
		if(userId == null){
			return  new ArrayList<CourierMidevice>();
		}
		
		if(userId <= 0){
			return  new ArrayList<CourierMidevice>();
		}
	
		return courierMiDeviceDao.getByUserId(userId);
	}

	@Override
	public CourierMidevice getNewByUserId(Long userId) {
		if(userId == null){
			return  null;
		}
		
		if(userId <= 0){
			return  null;
		}
	
		return courierMiDeviceDao.getNewByUserId(userId);
	}

	@Override
	public CourierMidevice getById(Long id) {
		if(id == null){
			return  null;
		}
		
		if(id <= 0){
			return  null;
		}
	
		return courierMiDeviceDao.getById(id);
	}

	@Override
	public CourierMidevice getByDeviceId(String deviceId) {
		if(null == deviceId || ("").equals(deviceId)){
			return  null;
		}
		return courierMiDeviceDao.getByDeviceId(deviceId);
	}

	@Override
	public CourierMidevice getByDeviceIdAndMobilePhone(String deviceId,
			String mobilePhone) {
		if(null == deviceId || ("").equals(deviceId)){
			return null;
		}
		
		if(null == mobilePhone || ("").equals(mobilePhone)){
			return null;
		}
		
		return courierMiDeviceDao.getByDeviceIdAndMobilePhone(deviceId, mobilePhone);
	} 
	
	
	
}
