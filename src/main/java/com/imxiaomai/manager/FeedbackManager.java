package com.imxiaomai.manager;


public interface FeedbackManager {
	public  int insert( Long userId, String userInfo, String userName,  String feedText, String telphone, String date);
}