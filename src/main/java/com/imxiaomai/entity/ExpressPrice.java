package com.imxiaomai.entity;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.anno.Comment;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

@SuppressWarnings("serial")
@Comment("快递价格表")
public class ExpressPrice extends BaseEntity {
    
    public static final long STATUS_NORMAL = 1;
    public static final long STATUS_DEL = 2;
    
    
    public long id;
    
    public long expressId;
    
    public long sourceProvinceId;
    
    public long sourceCityId;
    
    public long sourceAreaId;
    
    public long sourceStoreId;
    
    public long targetProvinceId;
    
    public long targetCityId;
    
    public long targetAreaId;
    
    public long targetStoreId;
    
    public long price1;
    
    public long price2;
    
    public long price3;
    
    public long price4;
    
    public long price5;
    
    public long createTime;
    
    public long updateTime;
    
    public long status;
    
    //价格，分为单位
    public long totalPrice;
    
    public long insert() throws SQLException {
        long insertId = db.insertRetKey("insert into "+db.tab()+" (`expressId`, `sourceProvinceId`, `sourceCityId`, `sourceAreaId`, "
                + "`sourceStoreId`, `targetProvinceId`, `targetCityId`, `targetAreaId`, `targetStoreId`, "
                + "`price1`, `price2`, `price3`, `price4`, `price5`, `createTime`, `updateTime`, `status`) "+
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
             expressId, sourceProvinceId, sourceCityId, sourceAreaId, sourceStoreId, 
             targetProvinceId, targetCityId, targetAreaId, targetStoreId, price1, price2, price3, 
             price4, price5, time(createTime), time(updateTime), status);
        
        return insertId;
    }
    
    public static int getCount(String sql, Object... params)
            throws SQLException {
        return db.selectCount(sql, params);
    }
    
    @Deprecated
    public static List<ExpressPrice> getExpressListByArea2Area(long sourceAreaId, 
            long targetAreaId) throws SQLException {
        
        return getList("where `sourceAreaId` = ? and `targetAreaId` = ? and `status` = ?", sourceAreaId, targetAreaId, ExpressPrice.STATUS_NORMAL);
        
    }
    
    @Deprecated
    public static List<ExpressPrice> getExpressListByProvince2Province(long sourceProvinceId, 
            long targetProvinceId) throws SQLException {
        
        return getList("where `sourceProvinceId` = ? and `targetProvinceId` = ? and `status` = ?", sourceProvinceId, targetProvinceId, ExpressPrice.STATUS_NORMAL);
        
    }
    
    public static List<ExpressPrice> getExpressPriceListByStoreIdAndTargetCityId(long storeId,
            long targetCityId) throws SQLException {
        
        return getList("where `sourceStoreId` = ? and `targetCityId` = ? and `status` = ?", storeId, targetCityId, ExpressPrice.STATUS_NORMAL);
    }
    
    public static List<ExpressPrice> getExpressPriceListByStoreIdAndTargetProvinceId(long storeId,
            long targetProvinceId) throws SQLException {
        
        return getList("where `sourceStoreId` = ? and `targetProvinceId` = ? and `status` = ?", storeId, targetProvinceId, ExpressPrice.STATUS_NORMAL);
    }
    
    public static List<ExpressPrice> getList(String sql, Object... params)
            throws SQLException {
        return db.select(sql, params);
    }

	public long calcTotalPrice(double weight) {
		long totalCost = 0;
		double baseWeight = 1.0;
		double addedWeight = weight - baseWeight;

		if (weight <= baseWeight) {
			totalCost = this.price1;
		} else {
			totalCost = (long)(this.price1 + addedWeight * this.price2);
		}
		
		return (long)Math.ceil(totalCost / 100d) * 100;
	}

	@Override
	public JsonObject toJson() {
		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("id", id);
		jsonObject.addProperty("expressId", expressId);
		jsonObject.addProperty("sourceProvinceId", sourceProvinceId);
		jsonObject.addProperty("sourceCityId", sourceCityId);
		jsonObject.addProperty("sourceAreaId", sourceAreaId);
		jsonObject.addProperty("sourceStoreId", sourceStoreId);
		jsonObject.addProperty("targetProvinceId", targetProvinceId);
		jsonObject.addProperty("targetCityId", targetCityId);
		jsonObject.addProperty("targetAreaId", targetAreaId);
		jsonObject.addProperty("targetStoreId", targetStoreId);
		jsonObject.addProperty("price1", price1);
		jsonObject.addProperty("price2", price2);
		jsonObject.addProperty("price3", price3);
		jsonObject.addProperty("price4", price4);
		jsonObject.addProperty("price5", price5);
		jsonObject.addProperty("totalPrice", totalPrice);

		return jsonObject;
	}

	@Override
	public String toString() {
		return toJson().toString();
	}

	private static final DBType1<ExpressPrice> db = Table.expressPriceDB;

}
