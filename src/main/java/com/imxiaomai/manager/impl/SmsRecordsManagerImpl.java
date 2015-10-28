package com.imxiaomai.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.SmsRecordsDao;
import com.imxiaomai.manager.SmsRecordsManager;
import com.imxiaomai.persistence.domain.SmsRecords;



public class SmsRecordsManagerImpl  extends BaseManager implements  SmsRecordsManager{
	
	@Resource
	private SmsRecordsDao smsRecordsDao;

	@Override
	public List<SmsRecords> getByTelPhone(String telPhone) {
		if(telPhone == null || ("").equals(telPhone)){
			return new ArrayList<SmsRecords>();
			
		}
		return smsRecordsDao.getByTelPhone(telPhone);
	}

	@Override
	public SmsRecords getNewsByTelPhone(String telPhone, String action) {
		if(telPhone == null || ("").equals(telPhone)){
			return null;
			
		}
		if(action == null || ("").equals(action)){
			return null;
			
		}
		return smsRecordsDao.getNewsByTelPhone(telPhone, action);
	}

	@Override
	public int insert(String telPhone, String smsCode, String action) {
		return smsRecordsDao.insert(telPhone, smsCode, action);
	}
	
	
}
