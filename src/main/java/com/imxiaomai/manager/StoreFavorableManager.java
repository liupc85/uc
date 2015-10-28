package com.imxiaomai.manager;

import java.util.List;
import com.imxiaomai.persistence.domain.StoreFavorable;

/**
 * 门店优惠活动表
 * int 		delPrice;   减免价格 or 赠送的积分
 * String 	tips;     	优惠活动描述 
 * int 		type;     	type = 2代表取件,此时delPrice为赠送的积分  type=3代表寄件,此时delPrice为减免
 * @author Administrator
 *
 */
public interface StoreFavorableManager {
	
	public int insert(StoreFavorable record);
	
	public  List<StoreFavorable> getAll();

	public  StoreFavorable getByStoreId( Long storeId, Integer type);
	
}
