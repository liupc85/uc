package com.imxiaomai.dao.impl;

import java.util.List;

import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.StoreFavorableDao;
import com.imxiaomai.persistence.domain.StoreFavorable;
import com.imxiaomai.persistence.mapper.StoreFavorableMapper;

/**
 * 门店优惠活动表
 * int 		delPrice;   减免价格 or 赠送的积分
 * String 	tips;     	优惠活动描述 
 * int 		type;     	type = 2代表取件,此时delPrice为赠送的积分  type=3代表寄件,此时delPrice为减免
 * @author Administrator
 *
 */
public class StoreFavorableDaoImpl extends BaseDao implements StoreFavorableDao {
	
	public int insert(StoreFavorable record) {
		return this.getSqlSession().getMapper(StoreFavorableMapper.class).insert(record);
	}

	public  List<StoreFavorable> getAll() {
		StoreFavorable record=new StoreFavorable ();
		return this.getSqlSession().getMapper(StoreFavorableMapper.class).getAll(record);
	}

	public  StoreFavorable getByStoreId( Long storeId, Integer type) {
		StoreFavorable record=new StoreFavorable ();
		record.setStoreid(storeId.intValue());
		record.setType(type.byteValue());
		return this.getSqlSession().getMapper(StoreFavorableMapper.class).getByStoreIdAndType(record);
//		return  validate(tmp);
	}
	
	
	/**
	  * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
	  * @param record
	  * @return
	  */
	 private StoreFavorable validate(StoreFavorable record){
	 	if(record==null){
	 		return new StoreFavorable();
	 	}else{
	 		return record;
	 	}
	 }
	
}
