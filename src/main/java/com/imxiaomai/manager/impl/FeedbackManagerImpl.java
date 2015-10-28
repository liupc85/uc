package com.imxiaomai.manager.impl;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.FeedbackDao;
import com.imxiaomai.manager.FeedbackManager;


public class FeedbackManagerImpl  extends BaseManager implements  FeedbackManager{
	
	@Resource
	private FeedbackDao feedbackDao;

	@Override
	public int insert(Long userId, String userInfo, String userName,
			String feedText, String telphone, String date) {
		// TODO Auto-generated method stub
		return feedbackDao.insert(userId, userInfo, userName, feedText, telphone, date);
	}
	
	
}