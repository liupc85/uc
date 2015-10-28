package com.imxiaomai.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.MiDeviceDao;
import com.imxiaomai.manager.MiDeviceManager;
import com.imxiaomai.persistence.domain.Midevice;


public class MiDeviceManagerImpl  extends BaseManager implements  MiDeviceManager  {
	
	@Resource
	private MiDeviceDao miDeviceDao;

	@Override
	public int insert(Midevice record) {
		if(record == null){
			return 0;
		}
		return miDeviceDao.insert(record);
	}

	@Override
	public <T> int updateByPair(String name, T val,Integer id) {
		// TODO Auto-generated method stub
		return miDeviceDao.updateByPair(name, val,id);
	}

	@Override
	public int update(Midevice record) {
		if(record == null){
			return 0;
		}
		return miDeviceDao.update(record);
	}

	@Override
	public List<Midevice> getByUserId(Long userId) {
		if(null == userId || userId <=0 ){
			return  new ArrayList<Midevice>();
		}
		return miDeviceDao.getByUserId(userId);
	}

	@Override
	public Midevice getNewByUserId(Long userId) {
		if(null == userId || userId <=0 ){
			return  null;
		}
		return miDeviceDao.getNewByUserId(userId);
	}

	@Override
	public Midevice getById(Long id) {
		if(null == id || id <=0 ){
			return  null;
		}
		return miDeviceDao.getById(id);
	}

	@Override
	public Midevice getByDeviceId(String deviceId) {
		if(null == deviceId || ("").equals(deviceId)){
			return null;
		}
		return miDeviceDao.getByDeviceId(deviceId);
	}

	@Override
	public Midevice getByDeviceIdAndMobilePhone(String deviceid,
			String mobilephone) {
		if(null == deviceid || ("").equals(deviceid)){
			return null;
		}
		if(null == mobilephone || ("").equals(mobilephone)){
			return null;
		}
		return miDeviceDao.getByDeviceIdAndMobilePhone(deviceid, mobilephone);
	}
	

}
