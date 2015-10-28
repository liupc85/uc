package com.imxiaomai.entity;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.anno.Comment;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

@SuppressWarnings("serial")
@Comment("快递价格表-顺丰")
public class ExpressPriceSf extends BaseEntity {

	public static final int STATUS_NORMAL = 1;

	public long id;
	public long expressId = 18;
	public long fromAreaId;
	public long toAreaId;
	public long price1;
	public long price2;
	public long price3;
	public long price4;
	public long price5;
	public long landPrice1;
	public long landPrice2;
	public long landPrice3;
	public long landPrice4;
	public long landPrice5;
	public long waterBasicPrice;
	public long waterAddedPrice;
	public long airBasicPrice;
	public long airAddedPrice;
	public long createTime;
	public int status;

	public long totalPrice;

	public static List<ExpressPriceSf> getList(String sql, Object... params)
			throws SQLException {
		return db.select(sql, params);
	}

	public static ExpressPriceSf getByFromAreaIdAndToAreaId(long fromAreaId, long toAreaId) throws SQLException {
		return db.selectOne("where `fromAreaId` = ? and `toAreaId` = ? and `status` = ?", fromAreaId, toAreaId, ExpressPriceSf.STATUS_NORMAL);
	}

	public long calcTotalPrice(double weight) {
		long totalCost = 0;

		if (weight <= 1d) {
			totalCost = this.price1;
		} else if (weight <= 50d) {
			totalCost = (long)(this.price1 + (weight - 1) * this.price2);
		} else if (weight <= 100d) {
			totalCost = (long)(this.price1 + (weight - 1) * this.price3);
		} else if (weight <= 300d) {
			totalCost = (long)(this.price1 + (weight - 1) * this.price4);
		} else {
			totalCost = (long)(this.price1 + (weight - 1) * this.price5);
		}

		return (long)Math.ceil(totalCost / 100d) * 100;
	}

	@Override
	public JsonObject toJson() {
		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("id", id);
		jsonObject.addProperty("expressId", expressId);
		jsonObject.addProperty("fromAreaId", fromAreaId);
		jsonObject.addProperty("toAreaId", toAreaId);
		jsonObject.addProperty("price1", price1);
		jsonObject.addProperty("price2", price2);
		jsonObject.addProperty("price3", price3);
		jsonObject.addProperty("price4", price4);
		jsonObject.addProperty("price5", price5);
		jsonObject.addProperty("landPrice1", landPrice1);
		jsonObject.addProperty("landPrice2", landPrice2);
		jsonObject.addProperty("landPrice3", landPrice3);
		jsonObject.addProperty("landPrice4", landPrice4);
		jsonObject.addProperty("landPrice5", landPrice5);
		jsonObject.addProperty("totalPrice", totalPrice);

		return jsonObject;
	}
	
	@Override
    public String toString(){
        return toJson().toString();
    }

	private static final DBType1<ExpressPriceSf> db = Table.expressPriceSfDB;
}
