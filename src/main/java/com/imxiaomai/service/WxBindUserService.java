package com.imxiaomai.service;

import java.util.List;

import com.imxiaomai.persistence.domain.WxBindUser;

public interface WxBindUserService {
	
	
	public <T> int updateByPair( String name, T val,String conditionName ,T conditionValue);
    
	public int updateUserId( Long userId,  String icode,Long id);

	public  long newRecord(String openId, String nickName, Integer sex, String headimgurl,int bind ,int userId);

	public  WxBindUser getByUserId(Long userId);
	
	public  List<WxBindUser> getByUserIds(List<Long> userIds);

	public  WxBindUser getByOpenId( String openId );
	
	public  WxBindUser getByUnionId( String unionId );
	
	public  WxBindUser getById( Long id) ;
}
