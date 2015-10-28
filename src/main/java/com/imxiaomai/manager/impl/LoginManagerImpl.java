package com.imxiaomai.manager.impl;

import javax.annotation.Resource;

import com.imxiaomai.manager.LoginManager;
import com.imxiaomai.persistence.domain.UserPanshi;
import com.imxiaomai.service.LoginService;

public class LoginManagerImpl implements LoginManager {

	@Resource
	private LoginService loginService;
	
	@Override
	public UserPanshi verifyBaseUser(String username, String password) {
		return loginService.verifyBaseUser(username, password, null, null);
	}

	@Override
	public UserPanshi getById(Integer id) {
		return this.loginService.getById(id);
	}

	@Override
	public int update(UserPanshi user) {
		return this.loginService.update(user);
	}

	@Override
	public int delById(Integer id) {
		return this.loginService.delById(id);
	}

	@Override
	public int insert(String userName, String realName, String mobilePhone,
			String userPwd, String token) {
		return this.loginService.insert(userName, realName, mobilePhone, userPwd, token);
	}

}
