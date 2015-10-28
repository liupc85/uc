package com.imxiaomai.dao.impl;

import java.util.ArrayList;
import java.util.List;


import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.ExpressPriceDao;
import com.imxiaomai.persistence.domain.ExpressPrice;
import com.imxiaomai.persistence.mapper.ExpressPriceMapper;

public class ExpressPriceDaoImpl extends BaseDao implements ExpressPriceDao {
	
	public Long insert(ExpressPrice record){
		int res=this.getSqlSession().getMapper(ExpressPriceMapper.class).insert(record);
		return (long) res;
	}
	
	public  int getCount(String sql, Object... params){
		return -1;
	}
	
	@Deprecated
	public  List<ExpressPrice> getExpressListByArea2Area(Long sourceAreaId, Long targetAreaId){
		if(sourceAreaId != null &&sourceAreaId >0&&targetAreaId != null &&targetAreaId >0){
			ExpressPrice record=new ExpressPrice();
			record.setSourceareaid(sourceAreaId.intValue());
			record.setTargetareaid(targetAreaId.intValue());
			return this.getSqlSession().getMapper(ExpressPriceMapper.class).getBySomeCondition(record);
		}
		return new ArrayList<ExpressPrice>();

	}
	
	@Deprecated
	public  List<ExpressPrice> getExpressListByProvince2Province(Long  sourceProvinceId, Long  targetProvinceId){
		if(sourceProvinceId != null &&sourceProvinceId >0&&targetProvinceId != null &&targetProvinceId >0){
			ExpressPrice record=new ExpressPrice();
			record.setSourceprovinceid(sourceProvinceId.intValue());
			record.setTargetprovinceid(targetProvinceId.intValue());
			return this.getSqlSession().getMapper(ExpressPriceMapper.class).getBySomeCondition(record);
		}
		return new ArrayList<ExpressPrice>();
	}
	
	public  List<ExpressPrice> getExpressPriceListByStoreIdAndTargetCityId(Long  storeId,Long  targetCityId){
		if(storeId != null &&storeId >0&&targetCityId != null &&targetCityId >0){
			ExpressPrice record=new ExpressPrice();
			record.setSourcestoreid(storeId.intValue());
			record.setTargetcityid(targetCityId.intValue());
			return this.getSqlSession().getMapper(ExpressPriceMapper.class).getBySomeCondition(record);
		}
		return new ArrayList<ExpressPrice>();
	}
	
	public  List<ExpressPrice> getExpressPriceListByStoreIdAndTargetProvinceId(Long storeId,Long targetProvinceId){
		if(storeId != null &&storeId >0&&targetProvinceId != null &&targetProvinceId >0){
			ExpressPrice record=new ExpressPrice();
			record.setSourcestoreid(storeId.intValue());
			record.setTargetprovinceid(targetProvinceId.intValue());
			return this.getSqlSession().getMapper(ExpressPriceMapper.class).getBySomeCondition(record);
		}
		return new ArrayList<ExpressPrice>();
	}
	

}
