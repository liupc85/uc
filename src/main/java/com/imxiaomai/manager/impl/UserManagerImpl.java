package com.imxiaomai.manager.impl;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.UserDao;
import com.imxiaomai.manager.UserManager;
import com.imxiaomai.persistence.domain.ExtraUser;
import com.imxiaomai.persistence.domain.User;
import com.imxiaomai.persistence.domain.UserGold;
import com.imxiaomai.persistence.domain.UserStat;

public class UserManagerImpl  extends BaseManager implements UserManager {
	
	@Resource 
	private UserDao  userDao;

	@Override
	public long insert(User record, String uid, String mac, String uuid) throws Exception {
		if(record == null){
			return 0l;
		}
		return userDao.insert(record, uid, mac, uuid);
	}

	@Override
	public User validate(String mobilePhone, String password) {
		if(mobilePhone == null || ("").equals(mobilePhone)){
			return null;
		}
		if(password == null || ("").equals(password)){
			return null;
		}
		return userDao.validate(mobilePhone, password);
	}

	@Override
	public User grant(String mobilePhone, String token) {
		if(mobilePhone == null || ("").equals(mobilePhone)){
			return null;
		}
		if(token == null || ("").equals(token)){
			return null;
		}
		return userDao.grant(mobilePhone, token);
	}

	@Override
	public int update(User record) {
		if(record == null){
			return 0;
		}
		return userDao.update(record);
	}

	@Override
	public User getById(Long id) {
		if(id == null || id <= 0){
			return null;
		}
		return userDao.getById(id);
	}

	@Override
	public User getByPhone(String mobilePhone) {
		if(mobilePhone == null || ("").equals(mobilePhone)){
			return null;
		}
		return userDao.getByPhone(mobilePhone);
	}

	@Override
	public List<User> getUsers(Integer pageSize, Integer currentPage) {
		// TODO Auto-generated method stub
		return userDao.getUsers(pageSize, currentPage);
	}

	@Override
	public List<User> getUsersByIds(List<UserStat> ids) {
		if(ids == null || ids.size()  == 0){
			return new ArrayList<User>();
		}
		return userDao.getUsersByIds(ids);
	}

	@Override
	public int count(String where, Object... params) {
		// TODO Auto-generated method stub
		return userDao.count(where, params);
	}

	@Override
	public <T> int updateByPair( String name, T val,String conditionName ,T conditionValue) {
		return userDao.updateByPair(name, val, conditionName,conditionValue);
	}
	
	@Override
	public <T> User  selectByPair(String conditionName ,T conditionValue){
		return userDao.selectByPair(conditionName,conditionValue);
	}
	
	
	@Override
	public int updatePassword(String password, Integer id) throws Exception {
		if(password == null || ("").equals(password)){
			return 0;
		}
		if(id == null || id == 0 ){
			return  0;
		}
		return userDao.updatePassword(password, id);
	}

	/**
	 * 
	 * @param password
	 * @param id
	 * @param flag 原微信用户已经通过注册流程修改了密码的标记位
	 * @return
	 * @throws Exception 
	 */
	public  int updatePasswordAndFlag( String password,Integer id,Integer flag) throws Exception{
		return userDao.updatePasswordAndFlag(password, id,flag);
	}
	
	@Override
	public int updateSourceByOpenid(Integer id) {
		if(id == null || id <= 0 ){
			return  0;
		}
		return userDao.updateSourceByOpenid(id);
	}

	@Override
	public int updateSource(Integer source, Integer id) {
		// TODO Auto-generated method stub
		return userDao.updateSource(source, id);
	}

	@Override
	public int updateRandomToken(String randomId, String productId,String randomToken, String mobilePhone) {
		// TODO Auto-generated method stub
		return userDao.updateRandomToken(randomId, productId, randomToken, mobilePhone);
	}
	
	public User getUserByOpenId(String openId){
		return userDao.getUserByOpenId(openId);
	}
	
	
    public ExtraUser getExtraUserByOpenId(String openId){
    	return userDao.getExtraUserByOpenId(openId);
    }

    public ExtraUser getUserByOpenIdExceptPre( String openId){
    	return userDao.getUserByOpenIdExceptPre(openId);
    }
    
    public ExtraUser getExtraUserByMobilePhone(String mobilePhone){
    	return userDao.getExtraUserByMobilePhone(mobilePhone);
    }
    
    public ExtraUser getExtraUserByUserId(Integer userId){
    	return userDao.getExtraUserByUserId(userId);
    }
	
    public List<ExtraUser> getExtraUserByAreaId(final Integer areaId){
    	return userDao.getExtraUserByAreaId(areaId);
    }
	
    public ExtraUser getExtraUserByMobileForInnerJoin(String mobilePhone){
    	return userDao.getExtraUserByMobileForInnerJoin(mobilePhone);
    }
    
    public  List<UserGold> selectOrderByGold(int retNum){
    	return userDao.selectOrderByGold(retNum);
    }
    
}
