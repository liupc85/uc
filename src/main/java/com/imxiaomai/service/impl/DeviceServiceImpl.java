package com.imxiaomai.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.manager.CourierDeviceManager;
import com.imxiaomai.manager.DeviceManager;
import com.imxiaomai.persistence.domain.CourierDevice;
import com.imxiaomai.persistence.domain.Device;
import com.imxiaomai.service.DeviceService;

public class DeviceServiceImpl implements DeviceService {
	
	@Resource
	private DeviceManager deviceManager;
	
	@Resource
	private CourierDeviceManager courierDeviceManager;

	@Override
	public int addOrUpdate(String packageName, Device device,
			CourierDevice courierDevice) {
		int index = 0;
		if(packageName.equals("com.xiaomai.express")){
			Device iod = deviceManager.getByDeviceIdAndMobilePhone(device.getDeviceid(), device.getMobilephone());
			if (iod == null) {
				index = deviceManager.insert(device);
			}else{
				device.setId(iod.getId());
				index = deviceManager.update(device);
			}
		}
		if(packageName.equals("com.xiaomai.courier")){
			CourierDevice oldDeviceInfo = courierDeviceManager.getByDeviceIdAndMobilePhone(courierDevice.getDeviceid(), courierDevice.getMobilephone());
			if (oldDeviceInfo == null) {
				index = courierDeviceManager.insert(courierDevice);
			}else{
				courierDevice.setId(oldDeviceInfo.getId());
				System.out.println("courierDevice.getId() "+courierDevice.getId());
				index = courierDeviceManager.update(courierDevice);
			}
		}
		return index;
		
		
	}

	@Override
	public <T> int updateById(long id, String key, T val) {
		return deviceManager.updateByPair(key, val, Integer.valueOf(String.valueOf(id)));
	}

	@Override
	public Device getByDeviceId(long id) {
		// TODO Auto-generated method stub
		return deviceManager.getById(id);
	}

	@Override
	public List<Device> getByUserId(long userId) {
		// TODO Auto-generated method stub
		return deviceManager.getByUserId(userId);
	}

	@Override
	public List<Device> getNewByUserId(long userId) {
		// TODO Auto-generated method stub
		return deviceManager.getNewByUserId(userId);
	}

}
