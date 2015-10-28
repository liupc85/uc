package com.imxiaomai.entity;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CollegeInfo extends BaseEntity{

//	        +----------+--------------+------+-----+-------------------+----------------+
//			| Field    | Type         | Null | Key | Default           | Extra          |
//			+----------+--------------+------+-----+-------------------+----------------+
//			| id       | int(11)      | NO   | PRI | NULL              | auto_increment |
//			| name     | varchar(100) | NO   |     | NULL              |                |
//			| address  | varchar(100) | NO   |     | NULL              |                |
//			| isdel    | int(1)       | NO   |     | 0                 |                |
//			| add_time | datetime     | NO   |     | CURRENT_TIMESTAMP |                |
//			+----------+--------------+------+-----+-------------------+----------------+

	public long id;

	public String name;

	public String address;

	public long add_time;

	public boolean isdel;

	public static List<CollegeInfo> getAll() throws SQLException {
		return db.select("where isdel = 0");
	}

	public static CollegeInfo getById(final long id) throws SQLException {
		return db.selectOne("where `id` = ? and isdel = 0",id);
	}

	public static List<CollegeInfo> getByProvinceId(final long pid) throws SQLException {
		return db.select("where id in (select college_id from store_info where province_id=?) and isdel = 0",pid);
	}

    /*public static List<CollegeInfo> getByAreaId(final long areaId) throws SQLException {
        return db.select("where id in (select college_id from store_info where area_id=?) and isdel = 0", areaId);
    }*/

    public static Map<Long, Map<Long, String>> getAllWithColleges() throws SQLException {
        String sql = "SELECT store_info.province_id, college_info.id, college_info.`name` FROM college_info LEFT JOIN store_info ON college_info.id=store_info.college_id WHERE college_info.isdel=0 AND store_info.isdel=0 AND province_id>0";
        return db.queryKeyeds(sql);
    }

	@Override
	public JsonObject toJson() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id",id);
		jsonObject.addProperty("name",name);
		jsonObject.addProperty("address",address);
//		jsonObject.addProperty("isdel",isdel);
//		jsonObject.addProperty("add_time",add_time);
		return jsonObject;
	}

	@Override
	public String toString() {
		return toJson().toString();
	}

	private static final DBType1<CollegeInfo> db = Table.collegeInfo;
}
