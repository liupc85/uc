package com.imxiaomai.dao;

import com.imxiaomai.persistence.domain.ExpressPriceSf;

/**
 * 快递价格表-顺丰
 * @author Administrator
 *
 */
public interface ExpressPriceSfDao {
	public  ExpressPriceSf getByFromAreaIdAndToAreaId(Long fromAreaId, Long toAreaId) ;
}
