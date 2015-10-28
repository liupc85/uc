package com.imxiaomai.service;

import java.util.List;

import com.imxiaomai.persistence.domain.CourierDevice;
import com.imxiaomai.persistence.domain.Device;

public interface DeviceService {

	/**
	 * 添加or修改
	 * @param packageName
	 * @param device
	 * @param courierDevice
	 * @return
	 */
	int addOrUpdate(String packageName,Device device,CourierDevice courierDevice);
	
	/**
	 * 修改
	 * @param <T>
	 * @param id
	 * @param key
	 * @param val
	 * @return
	 */
	<T> int updateById(long id,String key,T val);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Device getByDeviceId(long id);
	
	/**
	 * 根据userId查询
	 * @param userId
	 * @return
	 */
	List<Device> getByUserId(long userId);
	
	/**
	 * 根据新的userId查询
	 * @param userId
	 * @return
	 */
	List<Device> getNewByUserId(long userId);
}
