package com.imxiaomai.manager.impl;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.UserPanshiDao;
import com.imxiaomai.manager.UserPanshiManager;
import com.imxiaomai.persistence.domain.UserPanshi;

public class UserPanshiManagerImpl  extends BaseManager implements UserPanshiManager {
	
	@Resource
	private UserPanshiDao userPanshiDao;

	@Override
	public UserPanshi verifyBaseUser(String mobilePhone, String password) {
		// TODO Auto-generated method stub
		return userPanshiDao.verifyBaseUser(mobilePhone, password);
	}

	@Override
	public int insert(UserPanshi userpanshi) {
		// TODO Auto-generated method stub
		return userPanshiDao.insert(userpanshi);
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return userPanshiDao.deleteById(id);
	}

	@Override
	public int updateById(UserPanshi userpanshi) {
		// TODO Auto-generated method stub
		return userPanshiDao.updateById(userpanshi);
	}

	@Override
	public UserPanshi getById(Integer id) {
		// TODO Auto-generated method stub
		return userPanshiDao.getById(id);
	}

	@Override
	public UserPanshi getByName(String username) {
		// TODO Auto-generated method stub
		return userPanshiDao.getByName(username);
	}

}
