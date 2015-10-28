package com.imxiaomai.dao;

import java.util.List;

import com.imxiaomai.persistence.domain.Midevice;


public interface MiDeviceDao {
	

	public int insert(Midevice record) ;

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
	public int update(Midevice record);
	
	public  List<Midevice> getByUserId(Long userId);

	public  Midevice getNewByUserId(Long userId);

	public  Midevice getById( Long id) ;
	
	public  Midevice getByDeviceId( String deviceId) ;
	
	public  Midevice getByDeviceIdAndMobilePhone(String deviceid,  String mobilephone);
}
