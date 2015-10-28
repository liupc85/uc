package com.imxiaomai.entity;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base._;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

import java.sql.SQLException;
import java.util.List;

import static com.imxiaomai.base._.trimToEmpty;

public class WxUnBindUser extends BaseEntity{

	public long id;

	public String openId;

	public String nickName;

	public int sex;

	public String headimgurl;

	public int bind;

	public long userId;

	public String icode;

	public long createTime;

	public long updateTime;

	public int updateUserId(final long userId, final String icode) throws SQLException {
		return db.update("`bind` = 1, `icode` = ?, `userId` = ? where `id` = ?", trimToEmpty(icode), userId, id);
	}

	public static long newRecord(String openId, String nickName, int sex, String headimgurl) throws SQLException {
		return db.insert("(`openId`,`nickName`,`sex`,`headimgurl`,`bind`,`userId`,`createTime`) values(?,?,?,?,?,?,?)",openId,
				nickName, sex, headimgurl, 0, 0, time(System.currentTimeMillis()));
	}

	public static WxUnBindUser getByUserId(long userId) throws SQLException {
		return db.selectOne("where `userId` = ?",userId);
	}
	
	public static List<WxUnBindUser> getByUserIds(List<Long> userIds) throws SQLException {
		return db.select("where `userId` in ("+ _.join(userIds, ",") +")");
	}

	public static WxUnBindUser getByOpenId( String openId ) throws SQLException {
		return db.selectOne("where `openId` = ?",openId);
	}

	@Override
	public JsonObject toJson() throws SQLException {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", id);
		jsonObject.addProperty("openId", openId);
		jsonObject.addProperty("nickName", nickName);
		jsonObject.addProperty("sex", sex);
		jsonObject.addProperty("headimgurl", headimgurl);
		jsonObject.addProperty("bind", bind);
		jsonObject.addProperty("userId", userId);
		jsonObject.addProperty("createTime", createTime);
		jsonObject.addProperty("updateTime", updateTime);
		jsonObject.addProperty("icode", icode);
		return jsonObject;
	}

	@Override
	public String toString(){
		try {
			return toJson().toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("tostring error");
	}

	
	private static final DBType1<WxUnBindUser> db = Table.wxUnBindUserDB;

}
