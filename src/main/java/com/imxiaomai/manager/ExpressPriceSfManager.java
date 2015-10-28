package com.imxiaomai.manager;

import com.imxiaomai.persistence.domain.ExpressPriceSf;

/**
 * 快递价格表-顺丰
 * @author Administrator
 *
 */
public interface ExpressPriceSfManager {
	public  ExpressPriceSf getByFromAreaIdAndToAreaId(Long fromAreaId, Long toAreaId) ;
}
