package com.imxiaomai.entity;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.anno.Comment;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

import java.sql.SQLException;
import java.util.List;

@Comment("门店优惠活动表")
public class StoreFavorable extends BaseEntity{
	private static final long serialVersionUID = 6551172562810371845L;

	public long storeId;    //门店id

	public int delPrice;    //减免价格 or 赠送的积分

	public String tips;     //tips

	public int type;    //type = 2代表取件,此时delPrice为赠送的积分  type=3代表寄件,此时delPrice为减免

	public long startTime;

	public long endTime;

	public int insert() throws SQLException {
		return db.insert("(`storeId`,`delPrice`,`type`,`tips`,`startTime`,`endTime`) values(?,?,?,?,?,?)",
				storeId,delPrice,type,tips,startTime,endTime);
	}

	public static List<StoreFavorable> getAll() throws SQLException {
		return db.select("");
	}

	public static StoreFavorable getByStoreId(final long storeId,final int type) throws SQLException {
		return db.selectOne("where `storeId` = ? and `type` = ?",storeId,type);
	}

	@Override
	public JsonObject toJson() throws SQLException {
		JsonObject result = new JsonObject();
		result.addProperty("storeId",storeId);
		result.addProperty("delPrice",delPrice);
		result.addProperty("tips",tips);
		result.addProperty("type",type);
		result.addProperty("startTime",startTime);
		result.addProperty("endTime",endTime);
		return result;
	}

	private static final DBType1<StoreFavorable> db = Table.storeFavorable;
}
