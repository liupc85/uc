package com.imxiaomai.entity;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.anno.Comment;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

@Comment("门店快递业务")
public class StoreExpress extends BaseEntity {
	private static final long serialVersionUID = -132766775697561733L;
	
	public long storeId;
	public String deliveryExpIds;
	public String receivedExpIds;
	
	public int insert() throws SQLException {
		return db.insert("(`storeId`,`deliveryExpIds`,`receivedExpIds`) values(?,?,?)",
				storeId, deliveryExpIds, receivedExpIds);
	}

	public static List<StoreExpress> getAll() throws SQLException {
		return db.select("");
	}

	public static StoreExpress getByStoreId(final long storeId) throws SQLException {
		return db.selectOne("where `storeId` = ?",storeId);
	}
	
	@Override
	public JsonObject toJson() throws SQLException {
		JsonObject result = new JsonObject();
		result.addProperty("storeId",storeId);
		result.addProperty("deliveryExpIds",deliveryExpIds);
		result.addProperty("receivedExpIds",receivedExpIds);
		return result;
	}
	
	private static final DBType1<StoreExpress> db = Table.storeExpressDB;
}
