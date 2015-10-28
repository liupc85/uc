package com.imxiaomai.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.ExpressPriceDao;
import com.imxiaomai.manager.ExpressPriceManager;
import com.imxiaomai.persistence.domain.ExpressPrice;

/**
 * 快递价格表
 * @author Administrator
 *
 */
public class ExpressPriceManagerImpl  extends BaseManager implements ExpressPriceManager {
	
	@Resource
	private  ExpressPriceDao  eOxpressPriceDao;

	@Override
	public Long insert(ExpressPrice record) {
		if(record == null){
			return 0l;
		}
		return eOxpressPriceDao.insert(record);
	}

	@Override
	public int getCount(String sql, Object... params) {
		// TODO Auto-generated method stub
		return eOxpressPriceDao.getCount(sql, params);
	}
	@Deprecated
	@Override
	public List<ExpressPrice> getExpressListByArea2Area(Long sourceAreaId,
			Long targetAreaId) {
		// TODO Auto-generated method stub
		return eOxpressPriceDao.getExpressListByArea2Area(sourceAreaId, targetAreaId);
	}
	
	@Deprecated
	@Override
	public List<ExpressPrice> getExpressListByProvince2Province(
			Long sourceProvinceId, Long targetProvinceId) {
		// TODO Auto-generated method stub
		return eOxpressPriceDao.getExpressListByProvince2Province(sourceProvinceId, targetProvinceId);
	}

	@Override
	public List<ExpressPrice> getExpressPriceListByStoreIdAndTargetCityId(
			Long storeId, Long targetCityId) {
		if(null ==storeId || storeId <= 0 ){
			return new ArrayList<ExpressPrice>();
		}
		if(null ==targetCityId || targetCityId <= 0 ){
			return new ArrayList<ExpressPrice>();
		}
		return eOxpressPriceDao.getExpressPriceListByStoreIdAndTargetCityId(storeId,targetCityId);
	}

	@Override
	public List<ExpressPrice> getExpressPriceListByStoreIdAndTargetProvinceId(
			Long storeId, Long targetProvinceId) {
		if(null ==storeId || storeId <= 0 ){
			return new ArrayList<ExpressPrice>();
		}
		if(null ==targetProvinceId || targetProvinceId <= 0 ){
			return new ArrayList<ExpressPrice>();
		}
		return eOxpressPriceDao.getExpressPriceListByStoreIdAndTargetProvinceId(storeId,targetProvinceId);
	}
	
	
	
}
