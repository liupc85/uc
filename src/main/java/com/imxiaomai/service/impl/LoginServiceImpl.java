package com.imxiaomai.service.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.imxiaomai.manager.UserPanshiManager;
import com.imxiaomai.persistence.domain.UserPanshi;
import com.imxiaomai.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Resource
	private UserPanshiManager userPanshiManager;
	
	
	@Override
	public UserPanshi verifyBaseUser(String username, String password,HttpServletResponse response,HttpServletRequest request) {
		return  this.userPanshiManager.verifyBaseUser(username, password);
	}


	@Override
	public UserPanshi getById(Integer id) {
		UserPanshi u = this.userPanshiManager.getById(id);
		return u;
	}


	@Override
	public int update(UserPanshi userpanshi) {
		UserPanshi tmp = this.userPanshiManager.getById(userpanshi.getId());
		if(tmp == null){
			return 0;
		}
		if (StringUtils.isNotEmpty(userpanshi.getUserName())) {
			tmp.setUserName(userpanshi.getUserName());
		}
		if (StringUtils.isNotEmpty(userpanshi.getRealName())) {
			tmp.setRealName(userpanshi.getRealName());
		}
		if (StringUtils.isNotEmpty(userpanshi.getMobilePhone())) {
			tmp.setMobilePhone(userpanshi.getMobilePhone());
		}
		if (StringUtils.isNotEmpty(userpanshi.getUserPwd())) {
			tmp.setUserPwd(userpanshi.getUserPwd());
		}
		if (StringUtils.isNotEmpty(userpanshi.getToken())) {
			tmp.setToken(userpanshi.getToken());
		}
		if (StringUtils.isNotEmpty(userpanshi.getType().toString())) {
			tmp.setType(userpanshi.getType());
		}
		if (StringUtils.isNotEmpty(userpanshi.getStatus().toString())) {
			tmp.setStatus(userpanshi.getStatus());
		}
		if (StringUtils.isNotEmpty(userpanshi.getValidateLevel().toString())) {
			tmp.setValidateLevel(tmp.getValidateLevel());
		}
		if (StringUtils.isNotEmpty(userpanshi.getPrivilege())) {
			tmp.setPrivilege(userpanshi.getPrivilege());
		}
		tmp.setUpdateTime(new Date());
		return this.userPanshiManager.updateById(tmp);
	}


	@Override
	public int delById(Integer id) {
		UserPanshi u = this.getById(id);
		if(u == null){
			return 0;
		}
		return this.userPanshiManager.deleteById(id);
	}


	@Override
	public int insert(String userName, String realName, String mobilePhone, String userPwd, String token) {
		UserPanshi u = new UserPanshi();
		u.setUserName(userName);
		u.setRealName(realName);
		u.setMobilePhone(mobilePhone);
		u.setUserPwd(userPwd);
		u.setType(0);
		u.setToken(token);
		u.setCreateTime(new Date());
		u.setUpdateTime(new Date());
		u.setStatus(1);
		u.setValidateLevel(1);
		u.setPrivilege("");
		return this.userPanshiManager.insert(u);
	}
}
