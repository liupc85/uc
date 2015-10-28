package com.imxiaomai.service;

import java.util.List;

import com.imxiaomai.persistence.domain.UserSource;

public interface UserSourceService {

	/**
	 * 插入用户来源表，区分用户的来源，如wx，app，麦客
	 * @param record
	 * @return
	 */
	public int insertUserSource(UserSource record);
	
	
	public List<UserSource> queryUserSourceByUserId(final Integer userId);
	
	
}
