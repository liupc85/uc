package com.imxiaomai.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.StoreFavorableDao;
import com.imxiaomai.manager.StoreFavorableManager;
import com.imxiaomai.persistence.domain.StoreFavorable;

/**
 * 门店优惠活动表
 * int 		delPrice;   减免价格 or 赠送的积分
 * String 	tips;     	优惠活动描述 
 * int 		type;     	type = 2代表取件,此时delPrice为赠送的积分  type=3代表寄件,此时delPrice为减免
 * @author Administrator
 *
 */
public class StoreFavorableManagerImpl  extends BaseManager implements StoreFavorableManager{
	
	@Resource
	private StoreFavorableDao storeFavorableDao;

	@Override
	public int insert(StoreFavorable record) {
		if(record == null){
			return 0;
		}
		return storeFavorableDao.insert(record);
	}

	@Override
	public List<StoreFavorable> getAll() {
		// TODO Auto-generated method stub
		return storeFavorableDao.getAll();
	}

	@Override
	public StoreFavorable getByStoreId(Long storeId, Integer type) {
		if(storeId == null || storeId <= 0 ){
			return null;
		}
		return storeFavorableDao.getByStoreId(storeId, type);
	}
	

	
}
