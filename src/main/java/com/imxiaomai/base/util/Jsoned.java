package com.imxiaomai.base.util;

import com.google.gson.JsonObject;

import java.sql.SQLException;

public interface Jsoned {

	public JsonObject toJson() throws SQLException;

}
