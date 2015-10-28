package com.imxiaomai.manager.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.StoreDao;
import com.imxiaomai.manager.StoreManager;
import com.imxiaomai.persistence.domain.Store;
import org.apache.log4j.Logger;


public class StoreManagerImpl  extends BaseManager implements StoreManager{
	
	@Resource 
	private StoreDao storeDao;

	private static Logger log = Logger.getLogger(StoreManagerImpl.class);
	Cache<String, List<Store>> cache = CacheBuilder.newBuilder().maximumSize(1000).expireAfterWrite(300, TimeUnit.SECONDS).build();

	public int updateSelective(Store store){
		return storeDao.updateSelective(store);
	}
	
	
	@Override
	public Store getById(final Long id) {
		if(id == null || id <=0 ){
			return null;
		}
		return storeDao.getById(Long.valueOf(id));
	}

	@Override
	public List<Store> getAll() {
		try {
			return cache.get("allStore", new Callable<List<Store>>() {
				@Override
				public List<Store> call() throws Exception {
					return storeDao.getAll();
				}
			});
		} catch (ExecutionException e) {
			log.error("get all store failed", e);
		}
		return null;
	}

	@Override
	public Store getByCollegeId(Store store ) {
		return storeDao.getByCollegeId(store );
	}

	@Override
	public int update(Long id, String short_address, String take_express_phone) {
		// TODO Auto-generated method stub
		return storeDao.update(id, short_address, take_express_phone);
	}

	@Override
	public int update(Long id, String short_address, String take_express_phone,
			String latest_business_time) {
		// TODO Auto-generated method stub
		return storeDao.update(id, short_address, take_express_phone, latest_business_time);
	}

	@Override
	public List<Store> getByStatus(Integer status) {
		try {
			final String idKey = "STATUS"+status.toString();
			List<Store> stores = cache.get(idKey, new Callable<List<Store>>() {
				@Override
				public List<Store> call() throws Exception {
					Store store = new Store();
					Integer status = Integer.valueOf(idKey.replace("STATUS", ""));
					store.setStatus(status);
					List<Store> stores = storeDao.getByCondition(store);
					return stores;
				}
			});
			return stores;
		} catch (ExecutionException e) {
			log.error("get all store failed", e);
			return null;
		}
	}
}
