package com.imxiaomai.entity;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

public class Upgrade extends BaseEntity{
	
	public long id;
	
	public String version;
	
	public long opid;
	
	public long vid;
	
	public static List<Upgrade> selectLargeVersion(final long version) throws SQLException{
		log.info("select larger version = {}", version);
		return db.select("where version> ? group by vid", version);
	}

	public static List<Upgrade> selectByVid(final long vid) throws SQLException{
		log.info("select upgrade by vid = {}", vid);
		return db.select("where vid =  ? ", vid);
	}
	
	private static final DBType1<Upgrade> db = Table.upgradeDB;
	
	@Override
	public JsonObject toJson() throws SQLException {
		return null;
	}
	
	private static Logger log = LoggerFactory.getLogger(Upgrade.class);
	
}
