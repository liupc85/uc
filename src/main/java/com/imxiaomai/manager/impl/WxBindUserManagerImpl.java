package com.imxiaomai.manager.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.WxBindUserDao;
import com.imxiaomai.manager.WxBindUserManager;
import com.imxiaomai.persistence.domain.WxBindUser;

public class WxBindUserManagerImpl  extends BaseManager implements WxBindUserManager{
	
	@Resource
	private WxBindUserDao wxBindUserDao;

	@Override
	public int updateUserId(Long userId, String icode, Long id) {
		if(null == userId || userId<=0  ){
			return 0;
		}
		if(null == id || id <=0 ){
			return 0;
		}
		return wxBindUserDao.updateUserId(userId, icode, id);
	}

	@Override
	public long newRecord(String openId, String nickName, Integer sex,
			String headimgurl,int bind ,int userId) {
		if(null == openId || ("").equals(openId)){
			return 0l;
		}
/*		if(null == nickName || ("").equals(nickName)){
			return 0l;
		}*/
		return wxBindUserDao.newRecord(openId, nickName, sex, headimgurl,bind ,userId);
	}

	@Override
	public WxBindUser getByUserId(Long userId) {
		if(null == userId || userId<=0){
			return null;
		}
		return wxBindUserDao.getByUserId(userId);
	}

	@Override
	public List<WxBindUser> getByUserIds(List<Long> userIds) {
		if(userIds == null){
			return new ArrayList<WxBindUser>();
		}
		if(userIds.size() == 0){
			return new ArrayList<WxBindUser>();
		}
		return wxBindUserDao.getByUserIds(userIds);
	}

	public  WxBindUser getById( Long id) {
		if(null == id || id<=0){
			return null;
		}
		return wxBindUserDao.getById(id);
	}
	
	@Override
	public WxBindUser getByOpenId(String openId) {
		if(null == openId || ("").equals(openId)){
			return null;
		}
		return wxBindUserDao.getByOpenId(openId);
	}
	
	public  WxBindUser getByUnionId( String unionId ){
		if(null == unionId || ("").equals(unionId)){
			return null;
		}
		return wxBindUserDao.getByUnionId(unionId);
	}
	
	
	
	@Override
	public <T> int updateByPair( String name, T val,String conditionName ,T conditionValue) {
		return wxBindUserDao.updateByPair(name, val, conditionName,conditionValue);
	}
	
	@Override
	public <T> WxBindUser selectByPair(String conditionName,T conditionValue){
		return wxBindUserDao.selectByPair( conditionName,conditionValue);
	}
}