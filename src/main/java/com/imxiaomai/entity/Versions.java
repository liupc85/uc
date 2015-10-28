package com.imxiaomai.entity;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

import java.sql.SQLException;

public class Versions extends BaseEntity{
	
	public long id;
	
	public String type;

	public String version;   // 版本

	public int flag;

	public String downloadUrl;

	public String versionDesc;  // 升级文案
	
	public String pubType;
	
	
	public static Versions getNewestOne(String type) throws SQLException {
		return db.selectOne("where `type` = ? order by version desc limit 1",type);
	}

	
	public static Versions getNewestOne(String type, String pubType) throws SQLException {
		return db.selectOne("where `type` = ? and `pubType` = ? order by version desc limit 1",type, pubType);
	}
	
	public static Versions getById(long vid, String type, String pubType) throws SQLException{
		return db.selectOne("where `id` = ? and `type` = ? and `pubType` = ? ", vid, type, pubType);
	}
	
	public static Versions getByVersion(String version, String type, String pubType) throws SQLException{
		return db.selectOne("where `version` = ? and `type` = ? and `pubType` = ? ", version, type, pubType);
	}
	
	private static final DBType1<Versions> db = Table.versionDB;

	@Override
	public JsonObject toJson() throws SQLException {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("version",version);
		jsonObject.addProperty("flag",flag);    //0 没有更新  1可选  2强制
		jsonObject.addProperty("downloadUrl",downloadUrl);
		jsonObject.addProperty("versionDesc",versionDesc);
		jsonObject.addProperty("pubType", pubType);
		jsonObject.addProperty("type", type);
		return jsonObject;
	}
}
