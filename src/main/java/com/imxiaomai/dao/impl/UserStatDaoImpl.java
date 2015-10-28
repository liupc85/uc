package com.imxiaomai.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.ScorelistDao;
import com.imxiaomai.dao.UserStatDao;
import com.imxiaomai.persistence.domain.Scorelist;
import com.imxiaomai.persistence.domain.UserStat;
import com.imxiaomai.persistence.mapper.UserStatMapper;

public class UserStatDaoImpl extends BaseDao implements UserStatDao{
	    
	@Autowired ScorelistDao scorelistDao;
	
	//	public int insert() {
	//	return db.insert("(`userId`,`headImgUrl`,`score`,`gold`) values(?,?,?,?)",userId,headImgUrl,score,gold);
	//}
	
	public  int newStat( Integer userId, String uid, String mac, String uuid) {
		
		scorelistDao.insert(userId, 100L, new Long(Scorelist.SCORE_TYPE), new Long(Scorelist.ACTIVITY_IDENTIFY), new Long(userId.intValue()), "新用户注册");
		//fix:暂时去掉新手任务
	//	int isGift = 1;
		Integer isGift = 0;
	//	if( uidCount(uid) > 0 || macCount(mac) > 0 || uuidCount(uuid) > 0)
	//		isGift = 0;
		
		UserStat record=new UserStat();
		record.setUserid(userId);
		record.setHeadimgurl("");
		record.setScore(100);
		record.setGold(0);
		record.setMac(mac);
		record.setUuid(uuid);
		record.setIsgift(isGift.byteValue());
		record.setModifiedtime(time(System.currentTimeMillis()));
		return this.getSqlSession().getMapper(UserStatMapper.class).insert(record);
	}
	
	/*----------bingo  14-11-22----------*/
	public  int updateVersionCode( String versionCode,  String uid,  String mac,  String uuid,  Long userId,  Date modifiedTime) {
		UserStat record=new UserStat();
		record.setVersioncode(versionCode);
		record.setUid(uid);
		record.setMac(mac);
		record.setUuid(uuid);
		record.setModifiedtime(modifiedTime);
		record.setUserid(userId.intValue());
		return this.getSqlSession().getMapper(UserStatMapper.class).updateVersionCode(record);
	}
	
	public int update(String headImgUrl,Long score ,Long gold ,Long userId) {
		UserStat record=new UserStat();
		record.setHeadimgurl(headImgUrl);
		record.setScore(score.intValue());
		record.setGold(gold.intValue());
		record.setUserid(userId.intValue());
		return this.getSqlSession().getMapper(UserStatMapper.class).update(record);
	}
	
	public  UserStat getByUserId( Long userId) {
		return this.getSqlSession().getMapper(UserStatMapper.class).selectByPrimaryKey(userId.intValue());
//		return validate(tmp);
	}
	
	public int updateIcon( String headImgUrl,Long userId) {
		UserStat record=new UserStat();
		record.setHeadimgurl(headImgUrl);
		record.setUserid(userId.intValue());
		return this.getSqlSession().getMapper(UserStatMapper.class).updateIcon(record);
	}
	
	public  int uidCount(String uid) {
		if(!StringUtils.isEmpty(uid)){
			UserStat record=new UserStat();
			record.setUid(uid);
			return this.getSqlSession().getMapper(UserStatMapper.class).countByCondition(record);
		}else{
			return 0;
		}
	}
	
	public  int macCount(String mac) {
		if(!StringUtils.isEmpty(mac)){
			UserStat record=new UserStat();
			record.setMac(mac);
			return this.getSqlSession().getMapper(UserStatMapper.class).countByCondition(record);
		}else{
			return 0;
		}
	}
	
	public  int uuidCount(String uuid) {
		if(!StringUtils.isEmpty(uuid)){
			UserStat record=new UserStat();
			record.setUuid(uuid);
			return this.getSqlSession().getMapper(UserStatMapper.class).countByCondition(record);
		}else{
			return 0;
		}
	}
	
	
	public  <T> int updateByPair( String name, T val,Integer id)  {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("field", name);
		map.put("value", " '"+val+"' ");
		map.put("id", id);
		return this.getSqlSession().getMapper(UserStatMapper.class).updateByPair(map);
	}
	
	/**
	  * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
	  * @param record
	  * @return
	  */
	 private UserStat validate(UserStat record){
	 	if(record==null){
	 		return new UserStat();
	 	}else{
	 		return record;
	 	}
	 }
		
}