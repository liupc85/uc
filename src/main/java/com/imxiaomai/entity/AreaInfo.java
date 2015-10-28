package com.imxiaomai.entity;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

import java.sql.SQLException;
import java.util.List;

public class AreaInfo extends BaseEntity{

//	        +---------+-------------+------+-----+---------+-------+
//			| Field   | Type        | Null | Key | Default | Extra |
//			+---------+-------------+------+-----+---------+-------+
//			| id      | int(11)     | NO   | PRI | NULL    |       |
//			| name    | varchar(50) | NO   |     | NULL    |       |
//			| city_id | int(11)     | NO   |     | NULL    |       |
//			+---------+-------------+------+-----+---------+-------+

	public long id;

	public String name;

	public long city_id;

	public static List<AreaInfo> getByCityId(final long cityId) throws SQLException {
		return db.select("where `city_id` = ?",cityId);
	}

	public static AreaInfo getById(final long id) throws SQLException {
		return db.selectOne("where `id` = ?",id);
	}

	public static List<AreaInfo> getAll() throws SQLException {
		return db.select("");
	}

	@Override
	public JsonObject toJson() throws SQLException {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id",id);
		jsonObject.addProperty("name",name);
		jsonObject.addProperty("city_id",city_id);
		jsonObject.addProperty("cityName",CityInfo.getById(city_id).name);
		return jsonObject;
	}

	@Override
	public String toString(){
		try {
			return toJson().toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("tostring error~");
	}

	private static final DBType1<AreaInfo> db = Table.areaInfo;
}
