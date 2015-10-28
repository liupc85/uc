package com.imxiaomai.dao.impl;


import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.FeedbackDao;
import com.imxiaomai.persistence.domain.Feedback;
import com.imxiaomai.persistence.mapper.FeedbackMapper;

public class FeedbackDaoImpl extends BaseDao implements FeedbackDao {
	public  int insert( Long userId, String userInfo, String userName,  String feedText, String telphone, String date){
	
		Feedback record=new Feedback();
		
		record.setUserid(userId.intValue());
		record.setUserinfo(userInfo);
		record.setUsername(userName);
		record.setFeedtext(feedText);
		record.setTelphone(telphone);
		record.setDate(date);
		return this.getSqlSession().getMapper(FeedbackMapper.class).insert(record);
		
		
	}
	
	
}