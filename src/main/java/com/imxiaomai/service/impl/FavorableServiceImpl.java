package com.imxiaomai.service.impl;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.manager.StoreFavorableManager;
import com.imxiaomai.persistence.domain.StoreFavorable;
import com.imxiaomai.service.FavorableService;

public class FavorableServiceImpl implements FavorableService {
	
	@Resource
	StoreFavorableManager storeFavorableManager;

	@Override
	public List<StoreFavorable> storeFavorable(long storeId, int type) {
		List<StoreFavorable> storeFavorables;
		if( storeId == 0 ){
			storeFavorables = storeFavorableManager.getAll();
		}else{
			storeFavorables = Arrays.asList(storeFavorableManager.getByStoreId(storeId,type));
		}
		return storeFavorables;
	}

}
