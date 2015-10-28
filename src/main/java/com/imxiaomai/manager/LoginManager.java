package com.imxiaomai.manager;

import com.imxiaomai.persistence.domain.UserPanshi;


public interface LoginManager {

	public  UserPanshi verifyBaseUser(String username,  String password);
	
	public UserPanshi getById(Integer id);
	
	public int update(UserPanshi user);
	
	public int delById(Integer id);
	
	public int insert(String userName, String realName, String mobilePhone, String userPwd, String token);
}
