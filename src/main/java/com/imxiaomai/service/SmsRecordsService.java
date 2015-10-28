package com.imxiaomai.service;

import java.util.List;

import com.imxiaomai.persistence.domain.SmsRecords;


public interface SmsRecordsService {
	
	public  String  getSmsCode(String telPhone,String action);
	
	public  SmsRecords  getNewsByTelPhone(String telPhone,String action);

	public  List<SmsRecords> getByTelPhone( String telPhone);
	
	public  int insert( String telPhone, String smsCode,String action);
}
