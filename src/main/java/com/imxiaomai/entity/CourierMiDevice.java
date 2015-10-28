package com.imxiaomai.entity;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base._;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

public class CourierMiDevice extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

	public long id;

	public long userId;

	public String mobilePhone;

	public String deviceId;
	
	public String platform;

	public String version;

	public String srcChannel;

	public long createTime;
	
	public long updateTime;

	public String regId;   // 小米推送id

	public int insert() throws SQLException {
		return db.insert("(`userId`,`mobilePhone`,`deviceId`,`platform`,`version`," +
				"`srcChannel`,`createTime`,`updateTime`,`regId`) " +
				"values(?,?,?,?,?,?,?,?,?)",userId,mobilePhone,deviceId,platform,version,
				srcChannel,time(System.currentTimeMillis()),time(System.currentTimeMillis()),regId);
	}

	public <T> int updateByPair(final String name,final T val) throws SQLException {
		return db.update(_.f("`%s` = ?,`updateTime` = ? where `id` = ?", name),val,time(System.currentTimeMillis()), id);
	}

	public static int update(String mobilePhone, String deviceId, String platform, String version, String srcChannel, String regId, long id) throws SQLException {
		return db.update("`mobilePhone` = ?,`deviceId` = ?,`platform` = ?,`version` = ?," +
				"`srcChannel` = ?,`updateTime` = ?,`regId` = ? where `id` = ?",
				mobilePhone,deviceId,platform,version,srcChannel,time(System.currentTimeMillis()),
				regId,id);
	}
	

	public static List<CourierMiDevice> getByUserId(final long userId) throws SQLException {
		return db.select("where `userId` = ?", userId);
	}

	public static CourierMiDevice getNewByUserId(final long userId) throws SQLException {
		return db.selectOne("where `userId` = ? order by `updateTime` desc limit 1",userId);
	}

	public static CourierMiDevice getById(final long id) throws SQLException {
		return db.selectOne("where `id` = ?",id);
	}
	
	public static CourierMiDevice getByDeviceId(final String deviceId) throws SQLException {
		return db.selectOne("where `deviceId` = ?", deviceId);
	}
	
	public static CourierMiDevice getByDeviceIdAndMobilePhone(final String deviceId, final String mobilePhone) throws SQLException {
		return db.selectOne("where `deviceId` = ? and mobilePhone = ?", deviceId, mobilePhone);
	}
	
	private static final DBType1<CourierMiDevice> db = Table.courierMiDevice;

	@Override
	public JsonObject toJson() {	
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id",id);
		jsonObject.addProperty("userId",userId);
		jsonObject.addProperty("mobilePhone",mobilePhone);
		jsonObject.addProperty("deviceId",deviceId);
		jsonObject.addProperty("platform",platform);
		jsonObject.addProperty("version",version);
		jsonObject.addProperty("srcChannel",srcChannel);
		jsonObject.addProperty("createTime",createTime);
		jsonObject.addProperty("updateTime",updateTime);
		jsonObject.addProperty("regId",regId);
		return jsonObject;
	}

	@Override
	public String toString(){
		return toJson().toString();
	}

}
