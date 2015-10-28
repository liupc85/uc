package com.imxiaomai.service;

import java.util.List;

import com.imxiaomai.persistence.domain.CourierMidevice;
import com.imxiaomai.persistence.domain.Midevice;

public interface MiDeviceService {
	
	
	int addOrUpdate(String packageName,Midevice device,CourierMidevice courierDevice);

	/**
	 * 根据userId查询
	 * @param userId
	 * @return
	 */
	List<Midevice> getByUserId(Long userId);
	
	/**
	 * 查询最新的一条记录
	 * @param userId
	 * @return
	 */
	Midevice getNewByUserId(Long userId);
	
}
