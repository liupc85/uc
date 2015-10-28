package com.imxiaomai.entity;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

public class UpgradePloy extends BaseEntity{

	public long opid;
	
	public String upgradeName;
	
	public String upgradeValue;
	
	public int isUse;

	public static List<UpgradePloy> selectOne(final long op) throws SQLException{
		log.info("select upgradeploy by op = {}", op);
		return db.select("where opid = ? and isUse = 1", op);
	}
	
	public static UpgradePloy select(final long op) throws SQLException{
		log.info("select upgradeploy by op = {}", op);
		return db.selectOne("where opid = ? and isUse = 1", op);
	}
	
	private static final DBType1<UpgradePloy> db = Table.upgradeployDB;
	
	@Override
	public JsonObject toJson() throws SQLException {
		return null;
	}
	
	private static Logger log = LoggerFactory.getLogger(UpgradePloy.class);
	
}
