package com.imxiaomai.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.manager.CourierMiDeviceManager;
import com.imxiaomai.manager.MiDeviceManager;
import com.imxiaomai.persistence.domain.CourierMidevice;
import com.imxiaomai.persistence.domain.Midevice;
import com.imxiaomai.service.MiDeviceService;

public class MiDeviceServiceImpl implements MiDeviceService {
	
	@Resource 
	MiDeviceManager miDeviceManager;
	
	@Resource
	CourierMiDeviceManager courierMiDeviceManager;

	@Override
	public int addOrUpdate(String packageName, Midevice device,
			CourierMidevice courierDevice) {
		int index = 0 ;
		if(packageName.equals("com.xiaomai.express")){
			Midevice md = miDeviceManager.getByDeviceIdAndMobilePhone(device.getDeviceid(), device.getMobilephone());
			if(md == null){
				index = miDeviceManager.insert(device);
			}else{
				device.setId(md.getId());
				index = miDeviceManager.update(device);
			}
		}
		if(packageName.equals("com.xiaomai.courier")){
			CourierMidevice md = courierMiDeviceManager.getByDeviceIdAndMobilePhone(courierDevice.getDeviceid(), courierDevice.getMobilephone());
			if(md == null){
				index = courierMiDeviceManager.insert(courierDevice);
			}else{
				courierDevice.setId(md.getId());
				index = courierMiDeviceManager.update(courierDevice.getMobilephone(),courierDevice.getDeviceid(),courierDevice.getPlatform(),courierDevice.getVersion(),courierDevice.getSrcchannel(),courierDevice.getRegid(),courierDevice.getId());
			}
		}
		return index;
	}

	
	public List<Midevice> getByUserId(Long userId){
		return miDeviceManager.getByUserId(userId);
	}
	
	
	public Midevice getNewByUserId(Long userId){
		return miDeviceManager.getNewByUserId(userId);
	}
	
}
