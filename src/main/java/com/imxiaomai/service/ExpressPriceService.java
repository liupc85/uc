package com.imxiaomai.service;

import java.util.HashMap;
import java.util.List;

public interface ExpressPriceService {
	
	
	
	List<HashMap<String,Class>> getListWithTotalPrice(long sourceAreaId,long targetAreaId,double weight);
	
	
	List<HashMap<com.imxiaomai.persistence.domain.ExpressPrice,Class>> getList(long sourceProvinceId,long targetProvinceId);
	
	
	List<HashMap> getListByStoreAndTargetCity(long storeId ,long targetCityId);
	
	
	List<HashMap> getListWithTotalPriceByStoreAndTargetAreaId(long storeId,long targetAreaId,double weight);
	
	
	List<HashMap> getListByStoreAndArea(long storeId,long fromAreaId,long toAreaId,double weight,double ceilWeight);
	

}
