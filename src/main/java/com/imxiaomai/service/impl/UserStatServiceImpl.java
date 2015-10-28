package com.imxiaomai.service.impl;

import static com.imxiaomai.base._.trimToEmpty;

import java.util.Date;

import javax.annotation.Resource;

import com.google.gson.JsonObject;
import com.imxiaomai.manager.UserStatManager;
import com.imxiaomai.persistence.domain.College;
import com.imxiaomai.persistence.domain.UserStat;
import com.imxiaomai.service.UserStatService;

public class UserStatServiceImpl implements UserStatService{
	@Resource 
	private UserStatManager userStatManager;
	    
	//	public int insert();
	
	public  int newStat( Integer userId, String uid, String mac, String uuid){
		return userStatManager.newStat( userId, uid, mac, uuid);
	}
	
	/*----------bingo  14-11-22----------*/
	public  int updateVersionCode( String versionCode,  String uid,  String mac,  String uuid,  Long userId,  Date modifiedTime){
		return userStatManager.updateVersionCode(versionCode,uid,mac,uuid,userId,modifiedTime);
	}
	
	
	
	public int update(String headImgUrl,Long score ,Long gold ,Long userId){
		return userStatManager.update(headImgUrl,score ,gold ,userId);
	}
	
	public  UserStat getByUserId( Long userId){
		return userStatManager.getByUserId(userId);
	}
	
	public  int uidCount(String uid){
		return userStatManager.uidCount(uid);
	}
	
	public  int macCount(String mac){
		return userStatManager.macCount(mac);
	}
	
	public  int uuidCount(String uuid){
		return userStatManager.uuidCount(uuid);
	}
	
	public <T> int updateByPair( String key,  T val ,Integer userId){
		return userStatManager.updateByPair( key,  val ,userId);
	}
	
	public int updateIcon( String headImgUrl,Long userId){
		return userStatManager.updateIcon(  headImgUrl,userId);
	}
	
	public JsonObject toJson(UserStat userStat ){
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("userId",userStat.getUserid());
		jsonObject.addProperty("headImgUrl",userStat.getHeadimgurl());
		jsonObject.addProperty("score",userStat.getScore());
		jsonObject.addProperty("gold",userStat.getGold());
		jsonObject.addProperty("versionCode",userStat.getVersioncode());
		jsonObject.addProperty("uid",userStat.getUid());
		jsonObject.addProperty("modifiedTime",userStat.getModifiedtime()!=null?userStat.getModifiedtime().getTime():0L);
		jsonObject.addProperty("isGift",userStat.getIsgift());
		jsonObject.addProperty("mac",userStat.getMac());
		jsonObject.addProperty("uuid",userStat.getUuid());
		jsonObject.addProperty("inviteCount",userStat.getInvitecount());
		jsonObject.addProperty("inviteHitCount",userStat.getInvitehitcount());
		return jsonObject;
	
	}
	
}