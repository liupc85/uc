package com.imxiaomai.entity;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

import java.sql.SQLException;
import java.util.List;

public class ScoreList extends BaseEntity{

	public long id;

	public long userId;

	public int score;

	public int type;    // 1:表示积分记录  2:表示金币记录

	public int identify;    // 1表示来自商城  2表示来自取件 3表示来自寄件

	public int outId;   //外部标识

	public String tips;

	public long time;

	public static final int GOLD_TYPE = 2;

	public static final int SCORE_TYPE = 1;

	public static final int SHOP_IDENTIFY = 1;

	public static final int QUJIAN_IDENTIFY = 2;

	public static final int JIJIAN_IDENTIFY = 3;

	public static final int ACTIVITY_IDENTIFY = 4;

	public static int insert(final long userId, final int score,final int type,final int identify,final int outId, final String tips) throws SQLException {
		return db.insert("(`userId`,`score`,`type`,`identify`,`outId`,`tips`,`time`) values(?,?,?,?,?,?,?)",userId,score,type,identify,outId, tips,time(System.currentTimeMillis()));
	}

	public static List<ScoreList> getByUserId(final long userId) throws SQLException {
		return db.select("where `userId` = ? order by time",userId);
	}

	public static List<ScoreList> getByUserIdAndType(final long userId,final int type) throws SQLException {
		return db.select("where `userId` = ? and `type` = ? order by time",userId,type);
	}

	public static ScoreList getByIdentify(final long userId, final int type,final int identify,final int outId) throws SQLException {
		return db.selectOne("where `userId` = ? and `type` = ? and `identify` = ? and `outId` = ?",userId, type,identify,outId);
	}

	private static final DBType1<ScoreList> db = Table.scoreList;

	@Override
	public JsonObject toJson() throws SQLException {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("userId",userId);
		jsonObject.addProperty("score",score);
		jsonObject.addProperty("type",type);
		jsonObject.addProperty("tips",tips);
		jsonObject.addProperty("time",time);
		jsonObject.addProperty("outId",outId);
		jsonObject.addProperty("identify",identify);
		return jsonObject;
	}
}
