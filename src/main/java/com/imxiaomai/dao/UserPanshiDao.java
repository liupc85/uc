package com.imxiaomai.dao;

import java.util.Map;

import com.imxiaomai.persistence.domain.UserPanshi;


public interface UserPanshiDao {

	public UserPanshi verifyBaseUser(String username, String password);
	
	public int insert(UserPanshi userpanshi);
	
	public int deleteById(Integer id);
	
	public int updateById(UserPanshi userpanshi);
	
	public UserPanshi getById(Integer id);
	
	public UserPanshi getByName(String username);
}
