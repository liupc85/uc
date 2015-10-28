package com.imxiaomai.manager.impl;

import java.util.Date;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.UserStatDao;
import com.imxiaomai.manager.UserStatManager;
import com.imxiaomai.persistence.domain.UserStat;



public class UserStatManagerImpl  extends BaseManager implements UserStatManager {
	
	@Resource 
	private UserStatDao userStatDao;

	@Override
	public int newStat(Integer userId, String uid, String mac, String uuid) {
		// TODO Auto-generated method stub
		return userStatDao.newStat(userId, uid, mac, uuid);
	}

	@Override
	public int updateVersionCode(String versionCode, String uid, String mac,
			String uuid, Long userId, Date modifiedTime) {
		// TODO Auto-generated method stub
		return userStatDao.updateVersionCode(versionCode, uid, mac, uuid, userId, modifiedTime);
	}

	@Override
	public int update(String headImgUrl, Long score, Long gold, Long userId) {
		// TODO Auto-generated method stub
		return userStatDao.update(headImgUrl, score, gold, userId);
	}

	@Override
	public UserStat getByUserId(Long userId) {
		// TODO Auto-generated method stub
		return userStatDao.getByUserId(userId);
	}

	@Override
	public int uidCount(String uid) {
		// TODO Auto-generated method stub
		return userStatDao.uidCount(uid);
	}

	@Override
	public int macCount(String mac) {
		// TODO Auto-generated method stub
		return userStatDao.macCount(mac);
	}

	@Override
	public int uuidCount(String uuid) {
		// TODO Auto-generated method stub
		return userStatDao.uuidCount(uuid);
	}

	@Override
	public <T> int updateByPair(String key, T val, Integer userId) {
		// TODO Auto-generated method stub
		return userStatDao.updateByPair(key, val, userId);
	}

	@Override
	public int updateIcon(String headImgUrl, Long userId) {
		// TODO Auto-generated method stub
		return userStatDao.updateIcon(headImgUrl, userId);
	}

	
}