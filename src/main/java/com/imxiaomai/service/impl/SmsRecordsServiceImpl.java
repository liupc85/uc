package com.imxiaomai.service.impl;


import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import com.imxiaomai.manager.SmsRecordsManager;
import com.imxiaomai.persistence.domain.SmsRecords;
import com.imxiaomai.service.SmsRecordsService;

public class SmsRecordsServiceImpl implements SmsRecordsService {
	
	private static final int EXPIRE_SEC = 5*60*1000;
	
	@Resource 
	SmsRecordsManager smsRecordsManager;

	@Override
	public String getSmsCode(String telPhone, String action) {
		//此手机最新的一条
		String smsCode = getSmsCode();
		SmsRecords sms = smsRecordsManager.getNewsByTelPhone(telPhone, action);
		if(sms == null){
			//还没有验证码
			smsRecordsManager.insert(telPhone, smsCode, action);
		}else{
			if( System.currentTimeMillis() - sms.getCreatetime().getTime() > EXPIRE_SEC ){
				//超过了一条验证码的最大时间，新生成一条
				smsRecordsManager.insert(telPhone, smsCode, action);
			}else{
				//验证码还在有效期内
				smsCode = sms.getSmscode();
			}
		}
		return smsCode;
	}
	
	
	private String getSmsCode(){
		String smsCode = "";
		for( int i = 0 ; i < 4 ; i ++ ){
			smsCode += randInt(9);
		}
		return smsCode;
	}
	
	static final Random rand = new Random();
	public static int randInt(int n) {
		return rand.nextInt(n);
	}


	@Override
	public  SmsRecords getNewsByTelPhone(String telPhone,
			String action) {
		return smsRecordsManager.getNewsByTelPhone(telPhone, action);
	}

	@Override
	public  int insert( String telPhone, String smsCode,String action){
		return smsRecordsManager.insert( telPhone, smsCode,action);
	}


	@Override
	public List<SmsRecords> getByTelPhone(String telPhone) {
		return smsRecordsManager.getByTelPhone( telPhone);
	}
}
