package com.imxiaomai.service.impl;

import javax.annotation.Resource;

import com.imxiaomai.base.toolkit.DateUtil;
import com.imxiaomai.manager.FeedbackManager;
import com.imxiaomai.manager.UserManager;
import com.imxiaomai.persistence.domain.User;
import com.imxiaomai.service.FeedBackService;

public class FeedBackServiceImpl implements FeedBackService {

	@Resource
	UserManager userManager;
	
	@Resource
	FeedbackManager feedBackManager;
	
	@Override
	public int feedBack(long userId, String userInfo, String feedText) {
		User user = userManager.getById(userId) ;
		String telphone = "" ;
		String userName = "";
		if ( null != user ) {
			telphone = user.getMobilephone() ;
			userName = user.getRealname();
		}
		final String date = DateUtil.format(System.currentTimeMillis(),"yyyyMMdd") ;
		int index = feedBackManager.insert(userId,userInfo,userName, feedText,telphone,date);
		return index;
	}

}
