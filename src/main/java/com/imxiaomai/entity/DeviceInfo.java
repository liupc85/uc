package com.imxiaomai.entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base._;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

public class DeviceInfo extends BaseEntity{

	public long id;

	public long userId;

	public String mobilePhone;

	public String deviceId;
	
	public String channelId;

	public String source;

	public String platform;

	public String version;

	public String srcChannel;

	public String lastUpdateChannel;

	public long createTime;

	public long updateTime;

	public String baiduUserId;

	public int insert() throws SQLException {
		return db.insert("(`userId`,`mobilePhone`,`deviceId`,`channelId`,`source`,`platform`,`version`," +
				"`srcChannel`,`lastUpdateChannel`,`createTime`,`updateTime`,`baiduUserId`) " +
				"values(?,?,?,?,?,?,?,?,?,?,?,?)",userId,mobilePhone,deviceId,channelId,source,platform,version,
				srcChannel,lastUpdateChannel,time(createTime),time(updateTime),baiduUserId);
	}

	public <T> int updateByPair(final String name,final T val) throws SQLException {
		return db.update(_.f("`%s` = ?,`updateTime` = ? where `id` = ?", name),val,time(System.currentTimeMillis()), id);
	}

	public int update() throws SQLException {
		return db.update("`mobilePhone` = ?,`deviceId` = ?,`channelId` = ?,`source` = ?,`platform` = ?,`version` = ?," +
				"`srcChannel` = ?,`lastUpdateChannel` = ?,`updateTime` = ?,`baiduUserId` = ? where `id` = ?",
				mobilePhone,deviceId,channelId,source,platform,version,srcChannel,lastUpdateChannel,time(System.currentTimeMillis()),
				baiduUserId,id);
	}
	
	public int updateById(final long id) throws SQLException {
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		
		if (userId > 0) {
			sql.append(",`userId` = ?");
			params.add(userId);
		}
		
		if (StringUtils.hasText(mobilePhone)) {
			sql.append(",`mobilePhone` = ?");
			params.add(mobilePhone);
		}
		
		if (StringUtils.hasText(channelId)) {
			sql.append(",`channelId` = ?");
			params.add(channelId);
		}
		
		if (StringUtils.hasText(source)) {
			sql.append(",`source` = ?");
			params.add(source);
		}
		
		if (StringUtils.hasText(platform)) {
			sql.append(",`platform` = ?");
			params.add(platform);
		}
		
		if (StringUtils.hasText(version)) {
			sql.append(",`version` = ?");
			params.add(version);
		}
		
		if (StringUtils.hasText(srcChannel)) {
			sql.append(",`srcChannel` = ?");
			params.add(srcChannel);
		}
		
		if (StringUtils.hasText(lastUpdateChannel)) {
			sql.append(",`lastUpdateChannel` = ?");
			params.add(lastUpdateChannel);
		}
		
		if (StringUtils.hasText(baiduUserId)) {
			sql.append(",`baiduUserId` = ?");
			params.add(baiduUserId);
		}
		
		if (updateTime > 0) {
			sql.append(",`updateTime` = ?");
			params.add(new Date(updateTime));
		}
		
		if (!StringUtils.hasText(sql.toString())) {
			return 0;
		}
		
		sql.append(" where `id` = ?");
		params.add(id);
		return db.update(sql.toString().substring(1), params.toArray());
	}

	public static List<DeviceInfo> getByUserId(final long userId) throws SQLException {
		return db.select("where `userId` = ?", userId);
	}

	public static List<DeviceInfo> getNewByUserId(final long userId) throws SQLException {
		return db.select("where `userId` = ? order by `updateTime` desc limit 1",userId);
	}

	public static DeviceInfo getById(final long id) throws SQLException {
		return db.selectOne("where `id` = ?",id);
	}
	
	public static DeviceInfo getByDeviceId(final String deviceId) throws SQLException {
		return db.selectOne("where `deviceId` = ?", deviceId);
	}
	
	public static DeviceInfo getByDeviceIdAndMobilePhone(final String deviceId, final String mobilePhone) throws SQLException {
		return db.selectOne("where `deviceId` = ? and mobilePhone = ?", deviceId, mobilePhone);
	}
	
	private static final DBType1<DeviceInfo> db = Table.deviceInfo;

	@Override
	public JsonObject toJson() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id",id);
		jsonObject.addProperty("userId",userId);
		jsonObject.addProperty("mobilePhone",mobilePhone);
		jsonObject.addProperty("deviceId",deviceId);
		jsonObject.addProperty("channelId",channelId);
		jsonObject.addProperty("source",source);
		jsonObject.addProperty("platform",platform);
		jsonObject.addProperty("version",version);
		jsonObject.addProperty("srcChannel",srcChannel);
		jsonObject.addProperty("lastUpdateChannel",lastUpdateChannel);
		jsonObject.addProperty("createTime",createTime);
		jsonObject.addProperty("updateTime",updateTime);
		jsonObject.addProperty("baiduUserId",baiduUserId);
		return jsonObject;
	}

	@Override
	public String toString(){
		return toJson().toString();
	}

}
