package com.imxiaomai.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.manager.UserSourceManager;
import com.imxiaomai.persistence.domain.UserSource;
import com.imxiaomai.service.UserSourceService;

public class UserSourceServiceImpl implements UserSourceService{

	@Resource UserSourceManager userSourceManager;
	/**
	 * 插入用户来源表，区分用户的来源，如wx，app，麦客
	 * @param record
	 * @return
	 */
	public int insertUserSource(UserSource record){
		return userSourceManager.insertUserSource(record);
	}
	
	
	public List<UserSource> queryUserSourceByUserId(final Integer userId){
		return userSourceManager.queryUserSourceByUserId(userId);
	}
	
	
}
