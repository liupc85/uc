package com.imxiaomai.entity;

import java.sql.SQLException;
import java.util.Date;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base._;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

public class UserStat extends BaseEntity{

	public long userId;

	public String headImgUrl;

	public int score;

	public int gold;
	
	public String versionCode;
	
	public String uid;
	
	public String mac;
	
	public String uuid;
	
	public long modifiedTime;
	
	public int isGift;
	
	
//	public int insert() throws SQLException {
//		return db.insert("(`userId`,`headImgUrl`,`score`,`gold`) values(?,?,?,?)",userId,headImgUrl,score,gold);
//	}

	public static int newStat(final long userId, String uid, String mac, String uuid) throws SQLException {
		ScoreList.insert(userId,100,ScoreList.SCORE_TYPE,ScoreList.ACTIVITY_IDENTIFY,(int)userId,"新用户注册");
		//fix:暂时去掉新手任务
//		int isGift = 1;
		int isGift = 0;
//		if( uidCount(uid) > 0 || macCount(mac) > 0 || uuidCount(uuid) > 0)
//			isGift = 0;
		return db.insert("(`userId`,`headImgUrl`,`score`,`gold`,`isGift`) values(?,?,?,?,?)", userId, "", 100, 0, isGift);
	}
	/*----------bingo  14-11-22----------*/
	public static int updateVersionCode(final String versionCode, final String uid, final String mac, final String uuid, final long userId, final Date modifiedTime) throws SQLException{
		return db.update("`versionCode` = ? , `uid` = ? , `mac` = ?, `uuid` = ? , `modifiedTime` = ? where `userId` = ?", versionCode, uid, mac, uuid, modifiedTime, userId) ;
	}

	public int update() throws SQLException {
		return db.update("`headImgUrl` = ? ,`score` = ?,`gold` = ? where `userId` = ?",
				headImgUrl,score,gold,userId);
	}

	public static UserStat geByUserId(final long userId) throws SQLException {
		return db.selectOne("where `userId` = ?",userId);
	}

	public static int uidCount(String uid) throws SQLException {
		return db.selectCount("where `uid` = ?",uid);
	}
	
	public static int macCount(String mac) throws SQLException {
		return db.selectCount("where `mac` = ?",mac);
	}
	
	public static int uuidCount(String uuid) throws SQLException {
		return db.selectCount("where `uuid` = ?",uuid);
	}

	public <T> int updateByPair(final String key, final T val) throws SQLException {
		return db.update(_.f("`%s` = ? where `userId` = ?",key),val,userId);
	}
	
	public int updateIcon(final String headImgUrl) throws SQLException {
		return db.update( "`headImgUrl` = ? where `userId` = ?", headImgUrl, userId);
	}


	@Override
	public JsonObject toJson() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("userId",userId);
		jsonObject.addProperty("headImgUrl",headImgUrl);
		jsonObject.addProperty("score",score);
		jsonObject.addProperty("gold",gold);
		return jsonObject;
	}
	

	@Override
	public String toString(){
		return toJson().toString();
	}

	private static final DBType1<UserStat> db = Table.userStatDB;
}
