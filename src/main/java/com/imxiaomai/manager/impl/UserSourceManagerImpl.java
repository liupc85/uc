package com.imxiaomai.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.dao.UserSourceDao;
import com.imxiaomai.manager.UserSourceManager;
import com.imxiaomai.persistence.domain.UserSource;

public class UserSourceManagerImpl implements UserSourceManager{

	@Resource  UserSourceDao  userSourceDao;
	
	/**
	 * 插入用户来源表，区分用户的来源，如wx，app，麦客
	 * @param record
	 * @return
	 */
	public int insertUserSource(UserSource record){
		return userSourceDao.insertUserSource(record);
	}
	
	public int deleteUserSource(UserSource record){
		return userSourceDao.deleteUserSource(record);
	}
	
	public List<UserSource> queryUserSourceByUserId(final Integer userId){
		return userSourceDao.queryUserSourceByUserId(userId);
	}
	
	
}
