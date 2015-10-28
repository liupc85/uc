package com.imxiaomai.entity;

import java.sql.SQLException;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

public class FeedBack extends BaseEntity{

	public long id;

	public long userId;

	public String userName;

	public String userInfo;

	public String feedText;
	 
	public String telphone ;
	/* date pattern : 2014-11-10 */
	public String date ;

	public static int insert(final long userId,final String userInfo, String userName, final String feedText,final String telphone,final String date) throws SQLException {
		return db.insert("(`userId`,`userInfo`,`userName`,`feedText`,`telphone`,`date`) values(?,?,?,?,?,?)",userId,userInfo,userName,feedText,telphone,date);
	}

	@Override
	public JsonObject toJson() throws SQLException {
		return null;
	}

	private static final DBType1<FeedBack> db = Table.feedBack;
}
