package com.imxiaomai.dao;

import java.util.List;

import com.imxiaomai.persistence.domain.StoreExpress;

/**
 * 门店快递业务
 * @author Administrator
 *
 */
public interface StoreExpressDao {
	
	public int insert(StoreExpress record);
	public  List<StoreExpress> getAll();
	public  StoreExpress getByStoreId(Long storeId);
	
}
