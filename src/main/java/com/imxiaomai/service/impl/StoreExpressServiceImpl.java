package com.imxiaomai.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.manager.StoreExpressManager;
import com.imxiaomai.persistence.domain.StoreExpress;
import com.imxiaomai.service.StoreExpressService;

/**
 * 门店快递业务
 * @author Administrator
 *
 */
public class StoreExpressServiceImpl implements StoreExpressService {
	
	@Resource StoreExpressManager storeExpressManager;
	
	public int insert(StoreExpress record){
		return storeExpressManager.insert(record);
	}
	
	public  List<StoreExpress> getAll(){
		return storeExpressManager.getAll();
	}
	
	public  StoreExpress getByStoreId(Long storeId){
		return storeExpressManager.getByStoreId(storeId);
	}
	
	
}
