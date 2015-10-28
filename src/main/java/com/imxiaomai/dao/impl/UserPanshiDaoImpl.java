package com.imxiaomai.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.UserPanshiDao;
import com.imxiaomai.persistence.domain.User;
import com.imxiaomai.persistence.domain.UserPanshi;
import com.imxiaomai.persistence.mapper.UserPanshiMapper;

public class UserPanshiDaoImpl extends BaseDao implements UserPanshiDao {

	@Override
	 public UserPanshi verifyBaseUser(String username, String password){
    	Map<String,Object> map=new HashMap<String,Object>();
		map.put("username", username);
		map.put("password", password);
		return this.getSqlSession().getMapper(UserPanshiMapper.class).verifyBaseUser(map);
    }

	@Override
	public int insert(UserPanshi userpanshi) {
		int affectCount = getSqlSession().getMapper(UserPanshiMapper.class).insert(userpanshi);  
		return affectCount;
	}

	@Override
	public int deleteById(Integer id) {
		int affectCount = getSqlSession().getMapper(UserPanshiMapper.class).deleteById(id);
		return affectCount;
	}

	@Override
	public int updateById(UserPanshi userpanshi) {
		int affectCount = getSqlSession().getMapper(UserPanshiMapper.class).updateById(userpanshi);
		return affectCount;
	}

	@Override
	public UserPanshi getById(Integer id) {
		UserPanshi userPanshi = getSqlSession().getMapper(UserPanshiMapper.class).getById(id);
		return userPanshi;
	}

	@Override
	public UserPanshi getByName(String username) {
		UserPanshi userPanshi = getSqlSession().getMapper(UserPanshiMapper.class).getByName(username);
		return userPanshi;
	}

}
