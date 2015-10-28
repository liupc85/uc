package com.imxiaomai.entity;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

import java.sql.SQLException;
import java.util.List;

public class ProvinceInfo extends BaseEntity{

//	        +-------+-------------+------+-----+---------+-------+
//			| Field | Type        | Null | Key | Default | Extra |
//			+-------+-------------+------+-----+---------+-------+
//			| id    | int(11)     | NO   | PRI | NULL    |       |
//			| name  | varchar(50) | NO   |     | NULL    |       |
//			+-------+-------------+------+-----+---------+-------+

	public long id;

	public String name;

	public static List<ProvinceInfo> getAll() throws SQLException {
		return db.select("");
	}

	public static ProvinceInfo getById(final long id) throws SQLException {
		return db.selectOne("where `id` = ?",id);
	}

	@Override
	public JsonObject toJson() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id",id);
		jsonObject.addProperty("name",name);
		return jsonObject;
	}

	@Override
	public String toString() {
		return toJson().toString();
	}

	private static final DBType1<ProvinceInfo> db = Table.provinceInfo;
}
