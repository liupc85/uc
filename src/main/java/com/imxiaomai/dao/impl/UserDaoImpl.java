package com.imxiaomai.dao.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.base.digt.Md5Util;
import com.imxiaomai.dao.UserDao;
import com.imxiaomai.dao.UserStatDao;
import com.imxiaomai.util.TokenUtils;
import com.imxiaomai.persistence.domain.ExtraUser;
import com.imxiaomai.persistence.domain.User;
import com.imxiaomai.persistence.domain.UserGold;
import com.imxiaomai.persistence.domain.UserStat;
import com.imxiaomai.persistence.mapper.UserMapper;

public class UserDaoImpl extends BaseDao implements UserDao {
	
	@Autowired UserStatDao userStatdao;
	
	
	public long insert( User record, String uid, String mac, String uuid) throws Exception {
		System.out.println("user insert db");
		long createTime = System.currentTimeMillis();
		long updateTime = System.currentTimeMillis();
		Integer isdel=new Integer(0);
		record.setCreatetime(time(createTime));
		record.setUpdatetime(time(updateTime));
		record.setBirthday(time(createTime));
		record.setIsdel(isdel.byteValue());
		String password=record.getPassword();//此时password是未加密的
		record.setPassword( Md5Util.md5AsLowerHex(password));
		System.out.println("record.getIspre() ="+record.getIspre());
		this.getSqlSession().getMapper(UserMapper.class).insert(record);
		System.out.println("user insert db record :"+record);
		int id = record.getId();
		System.out.println("user insert db id :"+id);
		//目的是更新token，因token的计算需要userId,并且password是未加密的
		updatePassword(password, id);
		userStatdao.newStat(id, uid, mac, uuid);
		return id;
	}

	public  User validate( String mobilePhone,  String password)  {
		if(!StringUtils.isEmpty(mobilePhone)&&!StringUtils.isEmpty(password)){
			User record=new User();
			record.setMobilephone(mobilePhone);
			record.setPassword(Md5Util.md5AsLowerHex(password));
			return this.getSqlSession().getMapper(UserMapper.class).getByCondition(record);
//			return validate(tmp);
		}
		return null;
	}

	public  User grant( String mobilePhone,  String token)  {
		if(!StringUtils.isEmpty(mobilePhone)&&!StringUtils.isEmpty(token)){
			User record=new User();
			record.setMobilephone(mobilePhone);
			record.setToken(token);
			return this.getSqlSession().getMapper(UserMapper.class).getByCondition(record);
//			return validate(tmp);
		}
		return null;
	}

	public int update(User record) {
		return this.getSqlSession().getMapper(UserMapper.class).updateByPrimaryKey(record);
	}
	
	public  User getById( Long id)  {
		//加入openId，cityId，provinceId
		return  this.getSqlSession().getMapper(UserMapper.class).selectByPrimaryKey(id.intValue());
//		return validate(tmp);
	}

	public  User getByPhone( String mobilePhone)  {
		if(StringUtils.isEmpty(mobilePhone)){
			return null;
		}
		User record=new User();
		record.setMobilephone(mobilePhone);
		return this.getSqlSession().getMapper(UserMapper.class).getByCondition(record);
//		return validate(tmp);
	}

	public  List<User> getUsers( Integer pageSize, Integer currentPage) {
		if(pageSize>0&&currentPage>0){
			HashMap<String, Integer> map=new HashMap<String, Integer>();
			int start =(currentPage-1)*pageSize;
			int end=pageSize;
			map.clear();
			map.put("start", start );
			map.put("end", end);
			System.out.println(start  +" QQQQQQQ "+end);
			return  this.getSqlSession().getMapper(UserMapper.class).getByPage(map);
		}
		return new ArrayList<User>();
	}
	
	public  List<User> getUsersByIds(List<UserStat> ids) {
		List<Integer> userIds=new ArrayList<Integer> ();  
		for (UserStat stat : ids) {
			userIds.add(stat.getUserid());
		}
		return this.getSqlSession().getMapper(UserMapper.class).getByUserIds(userIds);
	}
	
	/**
	 * count(String where, Object... params)的简版，目前只有User.count("")的调用
	 * @param where
	 * @return
	 */
	public  int count(String where, Object... params) {
		return this.getSqlSession().getMapper(UserMapper.class).count();
	}
	
	public <T> int updateByPair( String name, T val,String conditionName ,T conditionValue) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("field", name);
		map.put("value", " '"+val+"' ");
		map.put("conditionName", conditionName);
		map.put("conditionValue", " '"+conditionValue+"' ");
		return this.getSqlSession().getMapper(UserMapper.class).updateByPair(map);
	}
	
	
	public <T> User selectByPair(String conditionName ,T conditionValue){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("conditionName", conditionName);
		map.put("conditionValue", " '"+conditionValue+"' ");
		return this.getSqlSession().getMapper(UserMapper.class).selectByPair(map);
	}
	
	/**
	 * updatePassword 从 updateByPair中抽离出来
	 * @param password
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public  int updatePassword( String password,Integer id) throws Exception  {
		User record=new User();
		record.setId(id);
		String token =TokenUtils.getToken(id,password);
		record.setToken(token);
		record.setPassword(Md5Util.md5AsLowerHex(password));
		return this.getSqlSession().getMapper(UserMapper.class).updateSomeField(record);
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
		User record=new User();
		record.setId(id);
		String token =TokenUtils.getToken(id,password);
		record.setToken(token);
		record.setPassword(Md5Util.md5AsLowerHex(password));
		record.setUpdatePwdFlag(flag.byteValue());
		return this.getSqlSession().getMapper(UserMapper.class).updatePasswordAndFlag(record);
	}
	
	public int updateSourceByOpenid(Integer id)  {
		return updateSource(1,id.intValue());
	}

	public int updateSource(Integer source,Integer id)  {
		User record=new User();
		record.setId(id.intValue());
		record.setSource(source);
		return this.getSqlSession().getMapper(UserMapper.class).updateSomeField(record);
	}
	

    public int updateRandomToken(String randomId, String productId ,String randomToken,String mobilePhone) {
    	User record=new User();
		record.setRandomId(randomId);
		record.setProductId(productId);
		record.setRandomToken(randomToken);
		Date tokencreatetime=time(System.currentTimeMillis());
		record.setTokencreatetime(tokencreatetime);
		record.setMobilephone(mobilePhone);
		return this.getSqlSession().getMapper(UserMapper.class).updateRandomToken(record);
    }
    
    public User getUserByOpenId(String openId){
    	return this.getSqlSession().getMapper(UserMapper.class).getUserByOpenId(openId);
    }
    
    public ExtraUser getExtraUserByOpenId(String openId)  {
    	System.out.println("openId "+openId);
    	if(StringUtils.isEmpty(openId)){
    		return null;
    	}
    	ExtraUser extrauser=new ExtraUser();
    	extrauser.setOpenId(openId);
    	List<ExtraUser> list= this.getSqlSession().getMapper(UserMapper.class).getExtraUserByCondition(extrauser);
    	if(list.size()>0||!list.isEmpty()){
    		return list.get(0);
    	}else{
    		return null;
    	}
	}
    
    
    public ExtraUser getUserByOpenIdExceptPre( String openId){
    	System.out.println("openId "+openId);
    	if(StringUtils.isEmpty(openId)){
    		return null;
    	}
    	ExtraUser extrauser=new ExtraUser();
    	extrauser.setOpenId(openId);
    	return this.getSqlSession().getMapper(UserMapper.class).getUserByOpenIdExceptPre(extrauser);
    }
    
    public  ExtraUser getExtraUserByMobilePhone(String mobilePhone)  {
    	if(StringUtils.isEmpty(mobilePhone)){
    		return null;
    	}
    	ExtraUser extrauser=new ExtraUser();
    	extrauser.setMobilephone(mobilePhone);
    	List<ExtraUser> list= this.getSqlSession().getMapper(UserMapper.class).getExtraUserByCondition(extrauser);
    	if(list.size()>0||!list.isEmpty()){
    		return list.get(0);
    	}else{
    		return null;
    	}
	}
    
    public ExtraUser getExtraUserByUserId(Integer userId)  {
    	if(userId==null||userId.intValue()<=0){
    		return null;
    	}
    	ExtraUser extrauser=new ExtraUser();
    	extrauser.setId(userId);
    	List<ExtraUser> list= this.getSqlSession().getMapper(UserMapper.class).getExtraUserByCondition(extrauser);
    	if(list.size()>0||!list.isEmpty()){
    		return list.get(0);
    	}else{
    		return null;
    	}
    }
    
    
    public List<ExtraUser> getExtraUserByAreaId(Integer areaId){
    	ExtraUser extrauser=new ExtraUser();
    	if(areaId==null||areaId.intValue()<=0){
    		return new ArrayList<ExtraUser>();
    	}
    	extrauser.setAreaId(areaId);
    	return this.getSqlSession().getMapper(UserMapper.class).getExtraUserByCondition(extrauser);
    }
    
    
    
    public ExtraUser getExtraUserByMobileForInnerJoin(String mobilePhone){
    	if(StringUtils.isEmpty(mobilePhone)){
    		return null;
    	}
    	ExtraUser extrauser=new ExtraUser();
    	extrauser.setMobilephone(mobilePhone);
    	List<ExtraUser> list= this.getSqlSession().getMapper(UserMapper.class).getExtraUserByConditionForInnerJoin(extrauser);
    	if(list.size()>0||!list.isEmpty()){
    		return list.get(0);
    	}else{
    		return null;
    	}
	}
    
    
    public  List<UserGold> selectOrderByGold(int retNum) {
    	return this.getSqlSession().getMapper(UserMapper.class).selectOrderByGold(retNum);
	}
    
    
    /**
     * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
     * @param record
     * @return
     */
    private User validate(User record){
    	if(record==null){
    		return new User();
    	}else{
    		return record;
    	}
    }
    
    public User verifyBaseUser(String username, String password){
    	Map<String,Object> map=new HashMap<String,Object>();
		map.put("username", username);
		map.put("password", password);
		return this.getSqlSession().getMapper(UserMapper.class).verifyBaseUser(map);
    }
    
}
