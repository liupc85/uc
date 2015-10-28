package com.imxiaomai.manager;

import java.util.List;

import com.imxiaomai.persistence.domain.ExpressPrice;

/**
 * 快递价格表
 * @author Administrator
 *
 */
public interface ExpressPriceManager {
	
	public Long insert(ExpressPrice record);
	
	public  int getCount(String sql, Object... params);
	
	@Deprecated
	public  List<ExpressPrice> getExpressListByArea2Area(Long sourceAreaId, Long targetAreaId);
	
	@Deprecated
	public  List<ExpressPrice> getExpressListByProvince2Province(Long  sourceProvinceId, Long  targetProvinceId);
	
	public  List<ExpressPrice> getExpressPriceListByStoreIdAndTargetCityId(Long  storeId,Long  targetCityId);
	
	public  List<ExpressPrice> getExpressPriceListByStoreIdAndTargetProvinceId(Long storeId,Long targetProvinceId);
	
}
