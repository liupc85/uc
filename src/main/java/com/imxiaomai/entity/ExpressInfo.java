package com.imxiaomai.entity;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;
/**
 * 基础信息-快递
 * @author zhang-shuai
 *
 */
public class ExpressInfo extends BaseEntity {
    
	private static final long serialVersionUID = 6974918384606306175L;
/*
	Field       Type          Collation        Null    Key     Default  Extra   Privileges                       Comment                    
	----------  ------------  ---------------  ------  ------  -------  ------  -------------------------------  ---------------------------
	id          int(11)       (NULL)           NO      PRI     (NULL)           select,insert,update,references                             
	name        varchar(100)  utf8_unicode_ci  NO              (NULL)           select,insert,update,references                             
	short_name  char(10)      utf8_unicode_ci  NO              (NULL)           select,insert,update,references                             
	type        tinyint(2)    (NULL)           NO              0                select,insert,update,references  0:快递；1:电商        
	isdel       tinyint(2)    (NULL)           NO              0                select,insert,update,references  是否删除，1：删除  

*/
	public long id;
	
	public String name;
	
	public String short_name;
	
	public int type;
	
	public int isdel;
	
//构造方法	
	public ExpressInfo(){super();}
	
	
/*----------------------插入------------------------*/
	/**
	 * 插入时，不插入code,另外license_activate_num默认为100，license_activated_num默认为0
	 * @return
	 * @throws SQLException
	 */
	public long insert() throws SQLException {
		long insertId = db
		        .insertRetKey(
		                "insert into `"+db.tab()+"` (`name`,`short_name`,`type`)"
		                        + "values (?,?,?)",
				                name,short_name,type);
		return insertId;
	}

/*----------------------更新------------------------*/	
	//不更新编码
	public int update() throws SQLException {
        return db.update("`name` = ?,`short_name` = ?,`type` = ? WHERE id = ?",
				                name,short_name,type,id);
    }
	/**
	 * 根据id更新特定key
	 * @param key
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static int updateKey(final Object key,final Object value,final Object id) throws SQLException {
        return db.update(key + " = ? where `id` = ? ",value,id);
    }	
/*----------------------查询------------------------*/	
	public static ExpressInfo getById(final long id) throws SQLException {
		return db.selectOne("where `id`=?", id);
	}
	
	public static List<ExpressInfo> getAll() throws SQLException {
		return getList("where `isdel` = 0");
	}
	
	public static List<ExpressInfo> getByshortName(String shortName) throws SQLException {
		return getList("where `isdel` = 0 and `short_name` = ?",shortName);
	}
	
	public static List<ExpressInfo> getAllByType(int type) throws SQLException {
		return getList("where `type` = ? AND `isdel` = 0",type);
	}
	
	private static List<ExpressInfo> getList(String sql, Object... params)
	        throws SQLException {
		return db.select(sql, params);
	}
/*----------------------判断是否存在------------------------*/		
	public static boolean existById(final long id) throws SQLException {
	    ExpressInfo express = db.selectOne("where `id` = ? ", id);
	    if(express == null){
	    	return false;
	    }
	    return true;
	}

	public static boolean existByName(final String name) throws SQLException {
	    ExpressInfo express = db.selectOne("where `name` = ? ", name);
	    if(express == null){
	    	return false;
	    }
	    return true;
	}

/*----------------------统计数量------------------------*/	
	public static int getCount(String sql, Object... params) throws SQLException {
		return db.selectCount(sql,params);
	}

/*----------------------删除------------------------*/		
	public int delete() throws SQLException {
        return db.delete(" where `id` = ? ", id);
    }
	
	@Override
	public JsonObject toJson() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", id);
		jsonObject.addProperty("name", name);
		jsonObject.addProperty("short_name", short_name);
		jsonObject.addProperty("type", type);
		jsonObject.addProperty("isdel", isdel);
		return jsonObject;
	}

	private static final DBType1<ExpressInfo> db = Table.expressInfo;
}