package com.imxiaomai.dao.impl;

import java.util.List;

import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.UserSourceDao;
import com.imxiaomai.persistence.domain.UserSource;
import com.imxiaomai.persistence.mapper.UserSourceMapper;

public class  UserSourceDaoImpl extends BaseDao implements UserSourceDao  {

	/**
	 * 插入用户来源表，区分用户的来源，如wx，app，麦客
	 * @param record
	 * @return
	 */
	public int insertUserSource(UserSource record){
		long createTime = System.currentTimeMillis();
		record.setCreatetime(time(createTime));
		return this.getSqlSession().getMapper(UserSourceMapper.class).insert(record);
	}
	
	public int deleteUserSource(UserSource record){
		return this.getSqlSession().getMapper(UserSourceMapper.class).deleteUserSource(record);
	}
	
	public List<UserSource> queryUserSourceByUserId(final Integer userId){
		return this.getSqlSession().getMapper(UserSourceMapper.class).queryUserSourceByUserId(userId);
	}
	
	
}
