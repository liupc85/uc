package com.imxiaomai.service;

import java.util.List;

import com.imxiaomai.persistence.domain.StoreFavorable;


public interface FavorableService {
	
	
	List<StoreFavorable> storeFavorable(long storeId,int type);

}
