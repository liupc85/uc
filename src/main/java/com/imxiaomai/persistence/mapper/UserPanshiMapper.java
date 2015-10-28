package com.imxiaomai.persistence.mapper;

import java.util.Map;

import com.imxiaomai.persistence.domain.Area;
import com.imxiaomai.persistence.domain.UserPanshi;


public interface UserPanshiMapper {

	UserPanshi verifyBaseUser(Map<String, Object> map);
	
	int insert(UserPanshi userpanshi); 
	
	int deleteById(Integer id);
	
	int updateById(UserPanshi userpanshi);
	
	UserPanshi getById(Integer id);
	
	UserPanshi getByName(String username);
}
