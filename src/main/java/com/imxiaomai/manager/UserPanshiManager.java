package com.imxiaomai.manager;

import com.imxiaomai.persistence.domain.UserPanshi;


public interface UserPanshiManager {

	public  UserPanshi verifyBaseUser(String mobilePhone,  String password);
	
	public int insert(UserPanshi userpanshi);
	
	public int deleteById(Integer id);
	
	public int updateById(UserPanshi userpanshi);
	
	public UserPanshi getById(Integer id);
	
	public UserPanshi getByName(String username);

}
