package com.imxiaomai.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.DeviceDao;
import com.imxiaomai.manager.DeviceManager;
import com.imxiaomai.persistence.domain.Device;


public class DeviceManagerImpl  extends BaseManager implements DeviceManager{
	
	@Resource 
	private DeviceDao deviceDao;

	@Override
	public int insert(Device record) {
		if(record == null){
			return 0;
		}
		return deviceDao.insert(record);
	}

	@Override
	public <T> int updateByPair(String name, T val,Integer id) {
		return deviceDao.updateByPair(name, val,id);
	}

	@Override
	public int update(Device record) {
		if(record == null){
			return 0;
		}
		return deviceDao.update(record);
	}

	@Override
	public int updateById(Device record) {
		if(record == null){
			return 0;
		}
		return deviceDao.updateById(record);
	}

	@Override
	public Device getByDeviceIdAndMobilePhone(String deviceid,
			String mobilephone) {
		if(null == deviceid || ("").equals(deviceid)){
			return null;
		}
		
		if(null == mobilephone || ("").equals(mobilephone)){
			return null;
		}
		return deviceDao.getByDeviceIdAndMobilePhone(deviceid, mobilephone);
	}

	@Override
	public List<Device> getByUserId(Long userId) {
		if(null == userId){
			return  new ArrayList<Device>();
		}
		
		if(userId <= 0 ){
			return  new ArrayList<Device>();
		}
		return deviceDao.getByUserId(userId);
	}

	@Override
	public List<Device> getNewByUserId(Long userId) {
		if(null == userId){
			return  new ArrayList<Device>();
		}
		
		if(userId <= 0 ){
			return  new ArrayList<Device>();
		}
		return deviceDao.getNewByUserId(userId);
	}

	@Override
	public Device getById(Long id) {
		if(null == id){
			return  null;
		}
		
		if(id <= 0 ){
			return  null;
		}
		return deviceDao.getById(id);
	}

	@Override
	public Device getByDeviceId(String deviceId) {
		if(null == deviceId || ("").equals(deviceId)){
			return null;
		}
		return deviceDao.getByDeviceId(deviceId);
	}
	

	
}
