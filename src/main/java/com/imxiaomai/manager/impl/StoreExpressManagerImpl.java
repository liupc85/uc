package com.imxiaomai.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.StoreExpressDao;
import com.imxiaomai.manager.StoreExpressManager;
import com.imxiaomai.persistence.domain.StoreExpress;

/**
 * 门店快递业务
 * @author Administrator
 *
 */
public class StoreExpressManagerImpl  extends BaseManager implements StoreExpressManager {
	
	@Resource
	private StoreExpressDao storeExpressDao;

	@Override
	public int insert(StoreExpress record) {
		if(record == null ){
			return 0;
		}
		return storeExpressDao.insert(record);
	}

	@Override
	public List<StoreExpress> getAll() {
		return storeExpressDao.getAll();
	}

	@Override
	public StoreExpress getByStoreId(Long storeId) {
		if(storeId == null ||  storeId <= 0){
			return null;
		}
		return storeExpressDao.getByStoreId(storeId);
	}
	

	
}
