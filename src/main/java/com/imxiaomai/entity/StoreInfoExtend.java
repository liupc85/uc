package com.imxiaomai.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imxiaomai.base._;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;
/**
 * 基础信息-门店
 * @author zhang-shuai
 *
 */
public class StoreInfoExtend extends BaseEntity {
    
	public static Logger log = LoggerFactory.getLogger(StoreInfoExtend.class);
	
	private static final long serialVersionUID = 6974918384606306175L;
/*
	Field                  Type          Collation        Null    Key     Default              Extra           Privileges                       Comment                                                                 
	---------------------  ------------  ---------------  ------  ------  -------------------  --------------  -------------------------------  ------------------------------------------------------------------------
	id                     int(11)       (NULL)           NO      PRI     (NULL)               auto_increment  select,insert,update,references  ID                                                                      
	name                   varchar(100)  utf8_general_ci  NO                                                   select,insert,update,references  门店名称                                                            
	short_name             varchar(100)  utf8_general_ci  NO                                                   select,insert,update,references  门店简称                                                            
	owner                  varchar(100)  utf8_general_ci  NO                                                   select,insert,update,references  门店所有人                                                         
	license                varchar(100)  utf8_general_ci  NO                                                   select,insert,update,references  门店许可码                                                         
	license_activate_num   int(11)       (NULL)           NO              0                                    select,insert,update,references  门店激活总数                                                      
	license_activated_num  int(11)       (NULL)           NO              0                                    select,insert,update,references  门店已激活总数                                                   
	phone                  varchar(100)  utf8_general_ci  NO                                                   select,insert,update,references  门店电话                                                            
	take_express_phone     varchar(100)  utf8_general_ci  NO                                                   select,insert,update,references  上门取件电话                                                      
	status                 int(11)       (NULL)           NO              0                                    select,insert,update,references  门店状态                                                            
	province_id            int(11)       (NULL)           NO              0                                    select,insert,update,references  门店所在省                                                         
	city_id                int(11)       (NULL)           NO              0                                    select,insert,update,references  门店所在市                                                         
	area_id                int(11)       (NULL)           NO              0                                    select,insert,update,references  门店所在区                                                         
	college_id             int(11)       (NULL)           NO      MUL     0                                    select,insert,update,references  门店所在学校                                                      
	address                varchar(100)  utf8_general_ci  NO                                                   select,insert,update,references  门店详细地址                                                      
	isjoin                 int(1)        (NULL)           NO              0                                    select,insert,update,references  是否加盟                                                            
	create_time            datetime      (NULL)           NO              CURRENT_TIMESTAMP                    select,insert,update,references  添加时间                                                            
	isdel                  int(1)        (NULL)           NO              0                                    select,insert,update,references  是否删除                                                            
	isP2p                  int(1)        (NULL)           NO              0                                    select,insert,update,references  是否P2P门店                                                         
	short_address          varchar(40)   utf8_general_ci  NO                                                   select,insert,update,references  门店短地址                                                         
	latest_business_time   varchar(50)   utf8_general_ci  NO              18                                   select,insert,update,references  最晚营业时间                                                      
	collect_id             int(11)       (NULL)           NO              -1                                   select,insert,update,references  门店采集表id                                                       
	code                   varchar(50)   utf8_general_ci  NO                                                   select,insert,update,references  门店编码                                                            
	operate_type           tinyint(2)    (NULL)           NO              -1                                   select,insert,update,references  门店经营类型：0加盟/1合作直营/2自建直营/3校企合作  
	space                  varchar(50)   utf8_general_ci  NO                                                   select,insert,update,references  门店面积，默认为数字（平方米）                           
	level                  tinyint(2)    (NULL)           NO              -1                                   select,insert,update,references  门店等级，0:A++;1:A+;2:A;3:B;4:C                                   
	region_id              int(11)       (NULL)           NO              0                                    select,insert,update,references  大区id                                                                
	receive_ids            varchar(200)  utf8_general_ci  NO                                                   select,insert,update,references  已有揽件                                                            
	dispatch_ids           varchar(200)  utf8_general_ci  NO                                                   select,insert,update,references  已有派件                                                            
	start_time             varchar(50)   utf8_general_ci  NO                                                   select,insert,update,references  运营开始时间                                                      
	end_time               varchar(50)   utf8_general_ci  NO                                                   select,insert,update,references  运营结束时间                                                      
	create_staff_id        int(11)       (NULL)           NO              -1                                   select,insert,update,references  创建人                                                               
	update_staff_id        int(11)       (NULL)           NO              -1                                   select,insert,update,references  修改人                                                               
	ct_ids                 varchar(100)  utf8_general_ci  NO                                                   select,insert,update,references  被勾选关联的合同                                                
	update_time            timestamp     (NULL)           NO              0000-00-00 00:00:00                  select,insert,update,references  修改时间                                                            
*/
	public long id;
	
	public long collect_id;
	
	public String code;
	
	public String name;

	public String short_name;

	public String owner;

	public String license;
	
	public long license_activate_num;

	public long license_activated_num;
	
	public long region_id;
	
	//public RegionInfo region_bean;
	
	public long province_id;
	
	//public ProvinceInfo province_bean;
	
	public long city_id;
	
	//public CityInfo city_bean;
	
	public long area_id;
	
	//public AreaInfo area_bean;
	
	public long college_id;
	
	//public CollegeInfo college_bean;
	
	public String address;

	public String short_address;

	public String phone;
	
	public String take_express_phone;

	public int operate_type;
	
	public String space;

	public int level;

	public int status;
	
	public String receive_ids;
	
	public String dispatch_ids;
	
	public String start_time;
	
	public String end_time;

	public String latest_business_time;
	
	public int isdel;
	
	public int isP2p;
	
	public long create_staff_id;
	
	//public Staff create_staff_bean;
	
	public long update_staff_id;
	
	//public Staff update_staff_bean;
	
	public String ct_ids;
	
	//public List<ContractIndex> ct_beans;

	public long update_time;

	public long create_time;
	
//构造方法	
	public StoreInfoExtend(){super();}
	
/*----------------------插入------------------------*/
	/**
	 * 插入时，不插入code,另外license_activate_num默认为100，license_activated_num默认为0
	 * @return
	 * @throws SQLException
	 */
	public long insert() throws SQLException {
		long insertId = db
		        .insertRetKey(
		                "insert into `"+db.tab()+"` (`collect_id`,`name`,`short_name`,`owner`,`license`,`license_activate_num`,`license_activated_num`,`region_id`,`province_id`,`city_id`,"
		                		+ "`area_id`,`college_id`,`address`,`short_address`,`phone`,`take_express_phone`,`operate_type`,"
		                		+ "`space`,`level`,`status`,`receive_ids`,`dispatch_ids`,`start_time`,`end_time`,"
		                		+ "`latest_business_time`,`isdel`,`isP2p`,`create_staff_id`,`update_staff_id`,`create_time`,`update_time`) "
		                        + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW(),NOW())",
				                collect_id,name,short_name,owner,license,license_activate_num,license_activated_num,region_id,province_id,city_id,
				                area_id,college_id,address,short_address,phone,take_express_phone,operate_type,
				                space,level,status,receive_ids,dispatch_ids,start_time,end_time,
				                latest_business_time,isdel,isP2p,create_staff_id,update_staff_id);
		return insertId;
	}

/*----------------------更新------------------------*/	
	//不更新编码
	public int update() throws SQLException {
        return db.update("`name` = ?,`short_name` = ?,`owner` = ?,`license` = ?,`license_activate_num` = ?,`license_activated_num` = ?,`region_id` = ?,`province_id` = ?,`city_id` = ?,"
		                		+ "`area_id` = ?,`college_id` = ?,`address` = ?,`short_address` = ?,`phone` = ?,`take_express_phone` = ?,`operate_type` = ?,"
		                		+ "`space` = ?,`level` = ?,`status` = ?,`receive_ids` = ?,`dispatch_ids` = ?,`start_time` = ?,`end_time` = ?,"
		                		+ "`latest_business_time` = ?,`isdel` = ?,`isP2p` = ?,`update_staff_id` = ?,`update_time` = NOW() WHERE id = ?",
				                name,short_name,owner,license,license_activate_num,license_activated_num,region_id,province_id,city_id,
				                area_id,college_id,address,short_address,phone,take_express_phone,operate_type,
				                space,level,status,receive_ids,dispatch_ids,start_time,end_time,
				                latest_business_time,isdel,isP2p,update_staff_id,id);
	}

	public void updateSelective() throws Exception {
		StringBuilder subSql = new StringBuilder();
		List<Object> params = new ArrayList<>();

		Class<StoreInfoExtend> clazz = StoreInfoExtend.class;
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (Modifier.isStatic(field.getModifiers())) {
				continue;
			}
			if ("id".equals(field.getName())) {
				continue;
			}
			if ("update_time".equals(field.getName())) {
				continue;
			}

			Object value = field.get(this);
			if (value == null) {
				continue;
			}
			if (value instanceof String && value.equals("")) {
				continue;
			}
			if (value instanceof Long && Long.parseLong(value + "") <= 0) {
				continue;
			}
			if (value instanceof Integer && Integer.parseInt(value + "") <= 0) {
				continue;
			}

			subSql.append("`").append(field.getName()).append("`=?,");
			params.add(value);
		}

		if (_.isEmpty(subSql.toString())) {
			return;
		}

		subSql.append("`update_time`=NOW() WHERE id=?");
		params.add(id);

		db.update(subSql.toString(), params.toArray());
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
	public static StoreInfoExtend getById(final long id) throws SQLException {
		StoreInfoExtend store = db.selectOne("where `id`=? and `isdel` = ?", id,0);
		completeInfo(store);
		return  store;
	}
	
	public static StoreInfoExtend getByName(final String name) throws SQLException {
		StoreInfoExtend store = db.selectOne("where `name` = ? and `isdel` = ?", name,0);
		completeInfo(store);
		return  store;
	}
	
	public static StoreInfoExtend getByCode(final String code) throws SQLException {
		StoreInfoExtend store = db.selectOne("where `code` = ? and `isdel` = ?", code,0);
		completeInfo(store);
		return  store;
	}
	
	public static List<StoreInfoExtend> getAll() throws SQLException {
		return getList("where `isdel` = ?",0);
	}
	
	private static List<StoreInfoExtend> getList(String sql, Object... params)
	        throws SQLException {
		List<StoreInfoExtend> list = db.select(sql, params);
		for(StoreInfoExtend store : list){
			completeInfo(store);
		}
		return list;
	}
/*----------------------判断是否存在------------------------*/		
	public static boolean existById(final long id) throws SQLException {
		StoreInfoExtend depart = db.selectOne("where `id` = ? and `isdel` = ?", id,0);
		if(depart == null){
			return false;
		}
		return true;
	}
	public static boolean existByCode(final String code) throws SQLException {
	    StoreInfoExtend depart = db.selectOne("where `code` = ? and `isdel` = ?", code,0);
	    if(depart == null){
	    	return false;
	    }
	    return true;
	}
	public static boolean existByName(final String name) throws SQLException {
	    StoreInfoExtend depart = db.selectOne("where `name` = ? and `isdel` = ?", name,0);
	    if(depart == null){
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

	public static void completeInfo(StoreInfoExtend store) throws SQLException{
		/*if(store != null){
			store.region_bean = RegionInfo.getById(store.region_id);
			store.province_bean = ProvinceInfo.getById(store.province_id);
			store.city_bean = CityInfo.getById(store.city_id);
			store.area_bean = AreaInfo.getById(store.area_id);
			store.college_bean = CollegeInfo.getById(store.college_id);
			store.create_staff_bean = Staff.getById(store.create_staff_id);
			store.update_staff_bean = Staff.getById(store.update_staff_id);
			
			String[] cts = _.trimToEmpty(store.ct_ids).split(",");
			if(cts != null && cts.length != 0){
				List<ContractIndex> ctList = new ArrayList<ContractIndex>();
				ContractIndex temp = null;
				for(String s : cts){
					temp = ContractIndex.getById(_.toInt(s));
					if(temp != null){
						ctList.add(temp);
					}
				}
				store.ct_beans = ctList;
			}
		}*/
	}

	@Override
	public JsonObject toJson() throws SQLException {
		try {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("id", id);
			jsonObject.addProperty("name", name);
			jsonObject.addProperty("short_name", short_name);
			jsonObject.addProperty("owner", owner);
			jsonObject.addProperty("phone", phone);
			jsonObject.addProperty("province_id", province_id);

			ProvinceInfo provinceInfo = ProvinceInfo.getById(province_id);
			jsonObject.addProperty("province_name", provinceInfo == null ? "" : provinceInfo.name);
			jsonObject.addProperty("city_id", city_id);

			CityInfo cityInfo = CityInfo.getById(city_id);
			jsonObject.addProperty("city_name", cityInfo != null ? cityInfo.name : "");

			jsonObject.addProperty("area_id", area_id);
			AreaInfo areaInfo = AreaInfo.getById(area_id);
			jsonObject.addProperty("area_name", areaInfo != null ? areaInfo.name : "");

			jsonObject.addProperty("college_id", college_id);
			CollegeInfo collegeInfo = CollegeInfo.getById(college_id);
			jsonObject.addProperty("college_name", collegeInfo != null ? collegeInfo.name : "");
			jsonObject.addProperty("address", address);
			jsonObject.addProperty("short_address",short_address);
			jsonObject.addProperty("take_express_phone",take_express_phone);
			jsonObject.addProperty("latest_business_time",latest_business_time);
			jsonObject.addProperty("start_time",start_time);
			jsonObject.addProperty("end_time",end_time);
			jsonObject.addProperty("create_time", create_time);
			//新加入门店揽件、派件、类型、级别、状态、编码
			jsonObject.addProperty("receive_ids", receive_ids);
			jsonObject.addProperty("dispatch_ids", dispatch_ids);
			jsonObject.addProperty("operate_type", operate_type);
			jsonObject.addProperty("level", level);
			jsonObject.addProperty("status", status);
			jsonObject.addProperty("code", code);
			jsonObject.addProperty("isP2p", isP2p);
			return jsonObject;
		}catch (Exception e){
			System.err.println("error in getStore,");
			e.printStackTrace();
		}
		return null;
	}

	private static final DBType1<StoreInfoExtend> db = Table.storeInfoExtend;
}