package com.imxiaomai.dao;

import java.util.List;

import com.imxiaomai.persistence.domain.SmsRecords;



public interface SmsRecordsDao {
	public  List<SmsRecords> getByTelPhone( String telPhone);

	public  SmsRecords getNewsByTelPhone( String telPhone, String action);
	
	public  int insert( String telPhone, String smsCode,String action);
}
