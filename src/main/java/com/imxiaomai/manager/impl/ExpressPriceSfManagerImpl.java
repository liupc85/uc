package com.imxiaomai.manager.impl;


import javax.annotation.Resource;
import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.ExpressPriceSfDao;
import com.imxiaomai.manager.ExpressPriceSfManager;
import com.imxiaomai.persistence.domain.ExpressPriceSf;

/**
 * 快递价格表-顺丰
 * @author Administrator
 *
 */
public class ExpressPriceSfManagerImpl  extends BaseManager implements  ExpressPriceSfManager{
	
	@Resource
	private  ExpressPriceSfDao  expressPriceSfDao;

	@Override
	public ExpressPriceSf getByFromAreaIdAndToAreaId(Long fromAreaId,
			Long toAreaId) {
		if(null ==fromAreaId || fromAreaId <= 0 ){
			return null;
		}
		if(null ==toAreaId || toAreaId <= 0 ){
			return null;
		}
		
		return expressPriceSfDao.getByFromAreaIdAndToAreaId(fromAreaId, toAreaId);
	}
	
	
}
