package com.imxiaomai.dao.impl;

import java.util.List;



import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.SmsRecordsDao;
import com.imxiaomai.persistence.domain.SmsRecords;
import com.imxiaomai.persistence.mapper.SmsRecordsMapper;


public class SmsRecordsDaoImpl extends BaseDao implements SmsRecordsDao {
	
	public  List<SmsRecords> getByTelPhone( String telPhone){
		SmsRecords record=new SmsRecords();
		record.setTelphone(telPhone);
		return this.getSqlSession().getMapper(SmsRecordsMapper.class).getByTelPhone(record);
	}

	public  SmsRecords getNewsByTelPhone( String telPhone, String action){
		SmsRecords record=new SmsRecords();
		record.setTelphone(telPhone);
		record.setAction(action);
		return this.getSqlSession().getMapper(SmsRecordsMapper.class).getNewsByTelPhone(record);
//		return validate(tmp);
	}
	
	public  int insert( String telPhone, String smsCode,String action){
		SmsRecords record=new SmsRecords();
		record.setTelphone(telPhone);
		record.setSmscode(smsCode);
		record.setAction(action);
		record.setCreatetime(time(System.currentTimeMillis()));
		return this.getSqlSession().getMapper(SmsRecordsMapper.class).insert(record);
	}
	
	/**
	  * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
	  * @param record
	  * @return
	  */
	 private SmsRecords validate(SmsRecords record){
	 	if(record==null){
	 		return new SmsRecords();
	 	}else{
	 		return record;
	 	}
	 }
	
}
