package com.imxiaomai.entity;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

import java.sql.SQLException;
import java.util.List;

public class SmsRecords extends BaseEntity {

	public long id;

	public String telPhone;

	public String smsCode;

	public String action;    //{}

	public long createTime;

	public static List<SmsRecords> getByTelPhone(final String telPhone) throws SQLException {
		return db.select("where `telPhone` = ?",telPhone);
	}

	public static SmsRecords getNewsByTelPhone(final String telPhone,final String action) throws SQLException {
		return db.selectOne("where `telPhone` = ? and `action` = ? order by createTime desc limit 1",telPhone,action);
	}

	public static int insert(final String telPhone,final String smsCode,String action) throws SQLException {
		return db.insert("(`telPhone`,`smsCode`,`action`,`createTime`) values(?,?,?,?)",telPhone,smsCode,action,time(System.currentTimeMillis()));
	}

	private static final DBType1<SmsRecords> db = Table.smsRecords;

	@Override
	public JsonObject toJson() throws SQLException {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id",id);
		jsonObject.addProperty("telPhone", telPhone);
		jsonObject.addProperty("smsCode", smsCode);
		jsonObject.addProperty("action", action);
		jsonObject.addProperty("createTime", createTime);

		return jsonObject;
	}
}
