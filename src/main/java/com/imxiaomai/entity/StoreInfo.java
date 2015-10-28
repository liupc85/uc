package com.imxiaomai.entity;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

public class StoreInfo extends BaseEntity{

//	        +-----------------------+--------------+------+-----+-------------------+----------------+
//			| Field                 | Type         | Null | Key | Default           | Extra          |
//			+-----------------------+--------------+------+-----+-------------------+----------------+
//			| id                    | int(11)      | NO   | PRI | NULL              | auto_increment |
//			| name                  | varchar(100) | NO   |     |                   |                |
//			| short_name            | varchar(100) | NO   |     |                   |                |
//			| owner                 | varchar(100) | NO   |     |                   |                |
//			| license               | varchar(100) | NO   |     |                   |                |
//			| license_activate_num  | int(11)      | NO   |     | 0                 |                |
//			| license_activated_num | int(11)      | NO   |     | 0                 |                |
//			| phone                 | varchar(100) | NO   |     |                   |                |
//			| take_express_phone    | varchar(100) | NO   |     |                   |                |
//			| status                | int(11)      | NO   |     | 0                 |                |
//			| province_id           | int(11)      | NO   |     | 0                 |                |
//			| city_id               | int(11)      | NO   |     | 0                 |                |
//			| area_id               | int(11)      | NO   |     | 0                 |                |
//			| college_id            | int(11)      | NO   |     | 0                 |                |
//			| address               | varchar(100) | NO   |     |                   |                |
//			| isjoin                | int(1)       | NO   |     | 0                 |                |
//			| create_time           | datetime     | NO   |     | CURRENT_TIMESTAMP |                |
//			| isdel                 | int(1)       | NO   |     | 0                 |                |
//			+-----------------------+--------------+------+-----+-------------------+----------------+

	public long id;
	public String name;
	public String short_name;
	public String owner;
	public String license;
	public int license_activate_num;
	public int license_activated_num;
	public String phone;
	public String take_express_phone;
	public int status;
	public int province_id;
	public int city_id;
	public int area_id;
	public int college_id;
	public String address;
	public String short_address;
	public String latest_business_time;
	public boolean isjoin;
	public long create_time;
	public boolean isdel;

	public static StoreInfo getById(final long id) throws SQLException {
		return db.selectOne("where `id` = ? and `isdel` = ?",id,0);
	}

	public static List<StoreInfo> getAll() throws SQLException {
		return db.select("where `isdel` = ?",0);
	}

	public static StoreInfo getByCollegeId(final long collegeId) throws SQLException {
		return db.selectOne("where `college_id` = ?",collegeId);
	}

	public static int update(final long id,final String short_address,final String telphone) throws SQLException {
		return db.update("`short_address` = ?,`take_express_phone` = ? where `id` = ?",short_address,telphone,id);
	}
	
	public static int update(final long id, final String short_address, final String take_express_phone, final String latest_business_time) throws SQLException {
		return db.update("`short_address` = ?,`take_express_phone` = ?,`latest_business_time` = ? where `id` = ?",
				short_address, take_express_phone, latest_business_time, id);
	}

	@Override
	public JsonObject toJson() {
		try {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("id", id);
			jsonObject.addProperty("name", name);
			jsonObject.addProperty("short_name", short_name);
			jsonObject.addProperty("owner", owner);
			jsonObject.addProperty("phone", phone);
			jsonObject.addProperty("province_id", province_id);

			ProvinceInfo provinceInfo = ProvinceInfo.getById(province_id);
			jsonObject.addProperty("province_name", provinceInfo == null ? "" : provinceInfo.name);
			jsonObject.addProperty("city_id", city_id);

			CityInfo cityInfo = CityInfo.getById(city_id);
			jsonObject.addProperty("city_name", cityInfo != null ? cityInfo.name : "");

			jsonObject.addProperty("area_id", area_id);
			AreaInfo areaInfo = AreaInfo.getById(area_id);
			jsonObject.addProperty("area_name", areaInfo != null ? areaInfo.name : "");

			jsonObject.addProperty("college_id", college_id);
			CollegeInfo collegeInfo = CollegeInfo.getById(college_id);
			jsonObject.addProperty("college_name", collegeInfo != null ? collegeInfo.name : "");
			jsonObject.addProperty("address", address);
			jsonObject.addProperty("short_address",short_address);
			jsonObject.addProperty("take_express_phone",take_express_phone);
			jsonObject.addProperty("latest_business_time",latest_business_time);
			jsonObject.addProperty("create_time", create_time);
			return jsonObject;
		}catch (Exception e){
			System.err.println("error in getStore,");
			e.printStackTrace();
		}
		return null;
	}

	public void setIsjoin(boolean isjoin){
		this.isjoin = isjoin;
	}

	private static final DBType1<StoreInfo> db = Table.storeInfo;
}
