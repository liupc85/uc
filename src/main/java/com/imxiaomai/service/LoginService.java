package com.imxiaomai.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imxiaomai.persistence.domain.UserPanshi;



public interface LoginService {

	public UserPanshi getById(Integer id);
	
	public int update(UserPanshi user);
	
	public int delById(Integer id);
	
	public int insert(String userName, String realName, String mobilePhone, String userPwd, String token);
	
	public UserPanshi verifyBaseUser(String username, String password,HttpServletResponse response,HttpServletRequest request);
}
