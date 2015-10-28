package com.imxiaomai.entity;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.anno.Comment;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

import java.sql.SQLException;
import java.util.List;

@Comment("快递价格说明")
public class ExpressPriceInfo extends BaseEntity{

	public long id;

	public String expressName;

	public long exampleWeight;

	public long examplePrice;

	public String execScript;

	public int insert() throws SQLException {
		return db.insert("(`expressName`,`exampleWeight`,`examplePrice`,`execScript`) values(?,?,?,?)",
				expressName, exampleWeight, examplePrice, execScript);
	}

	public static List<ExpressPriceInfo> getAll() throws SQLException {
		return db.select("");
	}

	public static ExpressPriceInfo getById(final long id) throws SQLException {
		return db.selectOne("where `id` = ?",id);
	}

	public static ExpressPriceInfo getByName(final String name) throws SQLException {
		return db.selectOne("where `expressName` = ?",name);
	}

	@Override
	public JsonObject toJson() throws SQLException {
		JsonObject result = new JsonObject();
		result.addProperty("expressName",expressName);
		result.addProperty("exmapleWeight",exampleWeight);
		result.addProperty("examplePrice",examplePrice);
//		result.addProperty("execScript",execScript);
		return result;
	}

	private static final DBType1<ExpressPriceInfo> db = Table.expressPriceInfo;
}
