package com.imxiaomai.manager;

import com.imxiaomai.persistence.domain.CourierDevice;


public interface CourierDeviceManager {
	

	public int insert(CourierDevice record) ;

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
	public int update(CourierDevice record);
	
	/**
	 * 更新部分字段
	 * @param record
	 * @return
	 */
	public int updateById(CourierDevice record);
	
	public  CourierDevice getByDeviceIdAndMobilePhone(String deviceid,  String mobilephone);
	
	
}
