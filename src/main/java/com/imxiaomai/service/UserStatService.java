package com.imxiaomai.service;

import java.util.Date;

import com.google.gson.JsonObject;
import com.imxiaomai.persistence.domain.User;
import com.imxiaomai.persistence.domain.UserStat;



public interface UserStatService{
	    
	//	public int insert();
	
	public  int newStat( Integer userId, String uid, String mac, String uuid);
	
	/*----------bingo  14-11-22----------*/
	public  int updateVersionCode( String versionCode,  String uid,  String mac,  String uuid,  Long userId,  Date modifiedTime);
	
	public int update(String headImgUrl,Long score ,Long gold ,Long userId) ;
	
	public  UserStat getByUserId( Long userId);
	
	public  int uidCount(String uid);
	
	public  int macCount(String mac);
	
	public  int uuidCount(String uuid) ;
	
	public <T> int updateByPair( String key,  T val ,Integer userId) ;
	
	public int updateIcon( String headImgUrl,Long userId) ;
	
    public JsonObject toJson(UserStat userStat ) ;
	
}