package com.imxiaomai.entity;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

import java.sql.SQLException;
import java.util.List;

public class CountryInfo extends BaseEntity {
    public long id;

    public String name;

    public String enName;

    public String code;

    public long parentId;

    public int level;

    public long createTime;

    public int isdel;

    public static List<CountryInfo> getAllCountry() throws SQLException {
        return db.select("where `level` = ? and `isdel` = 0", 1);
    }

    @Override
    public JsonObject toJson() throws SQLException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", id);
        jsonObject.addProperty("name", name);
        jsonObject.addProperty("enName", enName);
        jsonObject.addProperty("code", code);
        jsonObject.addProperty("parentId", parentId);
        jsonObject.addProperty("level", level);
        return jsonObject;
    }

    @Override
    public String toString() {
        try {
            return toJson().toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("tostring error~");
    }

    private static final DBType1<CountryInfo> db = Table.countryInfo;
}
