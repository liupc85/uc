package com.imxiaomai.manager;

import java.util.List;

import com.imxiaomai.persistence.domain.Device;


public interface DeviceManager{
	

	public int insert(Device record) ;

	/**
	 * 无人调用
	 * @param name
	 * @param val
	 * @return
	 */
	public <T> int updateByPair( String name,T val,Integer id) ;

	/**
	 * 更新全部字段
	 * @param record
	 * @return
	 */
	public int update(Device record);
	
	/**
	 * 更新部分字段
	 * @param record
	 * @return
	 */
	public int updateById(Device record);
	
	public  Device getByDeviceIdAndMobilePhone(String deviceid,  String mobilephone);
	
	public  List<Device> getByUserId(Long userId);

	public  List<Device> getNewByUserId(Long userId);

	public  Device getById( Long id) ;
	
	public  Device getByDeviceId( String deviceId) ;
}
