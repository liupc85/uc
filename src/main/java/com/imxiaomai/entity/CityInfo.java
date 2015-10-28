package com.imxiaomai.entity;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

import java.sql.SQLException;
import java.util.List;

public class CityInfo extends BaseEntity{

//	        +-------------+-------------+------+-----+---------+-------+
//			| Field       | Type        | Null | Key | Default | Extra |
//			+-------------+-------------+------+-----+---------+-------+
//			| id          | int(11)     | NO   | PRI | NULL    |       |
//			| name        | varchar(50) | NO   |     | NULL    |       |
//			| province_id | int(11)     | NO   |     | NULL    |       |
//			| code        | varchar(10) | YES  |     | NULL    |       |
//			+-------------+-------------+------+-----+---------+-------+

	public long id;

	public String name;

	public long province_id;

	public String code;

	public static List<CityInfo> getByProvinceId(final long province_id) throws SQLException {
		return db.select("where `province_id` = ?",province_id);
	}

	public static CityInfo getById(final long id) throws SQLException {
		return db.selectOne("where `id` = ?", id);
	}

	public static List<CityInfo> getAll() throws SQLException {
		return db.select("");
	}

	@Override
	public JsonObject toJson() throws SQLException {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id",id);
		jsonObject.addProperty("name",name);
		jsonObject.addProperty("province_id",province_id);
		jsonObject.addProperty("province_name",ProvinceInfo.getById(province_id).name);
		jsonObject.addProperty("code",code);
		return jsonObject;
	}

	@Override
	public String toString() {
		try {
			return toJson().toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("tostring error~");
	}

	private static final DBType1<CityInfo> db = Table.cityInfo;
}
