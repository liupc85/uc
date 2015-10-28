package com.imxiaomai.manager.impl;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.CourierDeviceDao;
import com.imxiaomai.manager.CourierDeviceManager;
import com.imxiaomai.persistence.domain.CourierDevice;


public class CourierDeviceManagerImpl  extends BaseManager implements  CourierDeviceManager {
	
	@Resource
	private CourierDeviceDao courierDeviceDao;

	@Override
	public int insert(CourierDevice record) {
		if(record == null){
			return 0;
		}
		return courierDeviceDao.insert(record);
	}

	@Override
	public <T> int updateByPair(String name, T val,Integer id) {
		return courierDeviceDao.updateByPair(name, val,id);
	}

	@Override
	public int update(CourierDevice record) {
		if(record == null){
			return 0;
		}
		return courierDeviceDao.update(record);
	}

	@Override
	public int updateById(CourierDevice record) {
		if(record == null){
			return 0;
		}
		return courierDeviceDao.updateById(record);
	}

	@Override
	public CourierDevice getByDeviceIdAndMobilePhone(String deviceid,
			String mobilephone) {
		
		if(deviceid == null || ("").equals(deviceid)){
			return null;
		}
		
		if(mobilephone == null || ("").equals(mobilephone)){
			return null;
		}
		
		return courierDeviceDao.getByDeviceIdAndMobilePhone(deviceid, mobilephone);
	}
	

	
	
}
