package com.imxiaomai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


//import com.imxiaomai.fw.client.codis.CommonClient;
//import com.imxiaomai.fw.client.codis.pool.PoolType;
import com.imxiaomai.manager.WxBindUserManager;
import com.imxiaomai.persistence.domain.WxBindUser;
import com.imxiaomai.service.WxBindUserService;
//import com.imxiaomai.util.ConfigUtil;
//import com.imxiaomai.util.RedisUtil;

public class WxBindUserServiceImpl implements  WxBindUserService {
	
//	private final static int expir = ConfigUtil.getIntValue("codis.expir");
//	private final static int tryNum = ConfigUtil.getIntValue("codis.trynum");
//	private static CommonClient commonClient = new CommonClient(PoolType.roundRobin,tryNum);
//	private final static String codisPre = ConfigUtil.getStringValue("codis.dataPre")+"_wxBind_";
	
	
	@Autowired WxBindUserManager wxBindUserManager;
	
	public  WxBindUser getById( Long id) {

/*		byte[] sObject = commonClient.get((codisPre+id).getBytes());
		if(sObject == null){
			WxBindUser u =  putCacheById(id);
			return u;
		}else{
			WxBindUser ur = (WxBindUser) RedisUtil.unserialize(sObject);
			return ur;
		}*/
		
		return wxBindUserManager.getById(id);
	
	}
	
	
	public  WxBindUser getByOpenId( String openId ){
/*		byte[] sObject = commonClient.get((codisPre+openId).getBytes());
		if(sObject == null){
			WxBindUser u =  putCacheByOpenId(openId);
			return u;
		}else{
			WxBindUser ur = (WxBindUser) RedisUtil.unserialize(sObject);
			return ur;
		}*/
		
		return   wxBindUserManager.getByOpenId(openId);
	}
	
	public  WxBindUser getByUnionId( String unionId ){
		return   wxBindUserManager.getByUnionId(unionId);
	}
	
	
	public <T> int updateByPair( String name, T val,String conditionName ,T conditionValue) {
		//此缓存需查询2次库
		int res= wxBindUserManager.updateByPair(name, val, conditionName,conditionValue);
/*		WxBindUser wx=wxBindUserManager.selectByPair(conditionName, conditionValue);
		if(res>0){
			putCacheByUserId(new Long(wx.getUserid()));
		}*/
		return res;
		
	}
	
	public int updateUserId( Long userId,  String icode,Long id){
		int res=wxBindUserManager.updateUserId( userId,  icode,id);
/*		if(res>0){
			putCacheByUserId(userId);
		}*/
		return res;
	}

	public  long newRecord(String openId, String nickName, Integer sex, String headimgurl,int bind ,int userId){
		long res= wxBindUserManager.newRecord( openId,  nickName,  sex,  headimgurl,bind,userId);
/*		if(res>0){
			putCacheByUserId(new Long(userId));
		}*/
		return res;
	}

	public  WxBindUser getByUserId(Long userId){
/*		byte[] sObject = commonClient.get((codisPre+userId.toString()).getBytes());
		if(sObject == null){
			WxBindUser u =  putCacheByUserId(userId);
			return u;
		}else{
			WxBindUser ur = (WxBindUser) RedisUtil.unserialize(sObject);
			return ur;
		}*/
		
		return wxBindUserManager.getByUserId(userId);
	}
	
	public  List<WxBindUser> getByUserIds(List<Long> userIds){
		return wxBindUserManager.getByUserIds(userIds);
	}
	
/*	private WxBindUser putCacheById(Long Id){
		WxBindUser wx =  wxBindUserManager.getById(Id);
		putCacheByWxBind(wx);
		return wx;
	}
	
	private WxBindUser putCacheByUserId(Long userId){
		WxBindUser u =  wxBindUserManager.getByUserId(userId);
		putCacheByWxBind(u);
		return u;
	}
	
	
	private WxBindUser putCacheByOpenId(String openId){
		WxBindUser wx =  wxBindUserManager.getByOpenId(openId);
		putCacheByWxBind(wx);
		return wx;
	}

	private void putCacheByWxBind(WxBindUser wx){
		if(wx != null){
			commonClient.setex((codisPre+wx.getId().toString()).getBytes(), expir, RedisUtil.serialize(wx));
			commonClient.setex((codisPre+wx.getUserid().toString()).getBytes(), expir, RedisUtil.serialize(wx));
			commonClient.setex((codisPre+wx.getOpenid()).getBytes(), expir, RedisUtil.serialize(wx));
		}
	}*/
	
}
