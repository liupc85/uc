package com.imxiaomai.dao;


public interface FeedbackDao {
	public  int insert( Long userId, String userInfo, String userName,  String feedText, String telphone, String date);
}