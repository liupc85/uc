package com.imxiaomai.entity;

import static com.imxiaomai.base._.trimToEmpty;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.JsonObject;
import com.imxiaomai.base.BaseEntity;
import com.imxiaomai.base._;
import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;
import com.imxiaomai.base.digt.Md5Util;
import com.imxiaomai.util.TokenUtils;

public class User extends BaseEntity{

	public long id;

	public String mobilePhone;

	public String password;

	public String token;

	public int collegeId;

	public String realName;

	public String userName;

	public long createTime;

	public long updateTime;

	public String email;

	public int sex;

	public long birthday;

	public boolean phoneValidate;

	public boolean emailValidate;

	public int source;

	public boolean isdel;

	//产品id
	public String productId;
	//随机id
	public String randomId;
	//根据随机id生成的随机token，现在的app的要求是token不能固定
	public String randomToken;
	//随机token的生成时间
	public long tokenCreateTime;
	
	public volatile transient UserStat userStat;
	

	public long insert(String uid, String mac, String uuid) throws UnsupportedEncodingException, SQLException {
		this.createTime = System.currentTimeMillis();
		this.updateTime = System.currentTimeMillis();
		long userId = db.insertRetKey("insert into " + db.tab() +"(`mobilePhone`,`password`,`token`,`collegeId`,`realName`,`userName`," +
				"`createTime`,`updateTime`,`email`,`sex`,`birthday`,`phoneValidate`,`emailValidate`," +
				"`source`,`isdel`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",mobilePhone, Md5Util.md5AsLowerHex(password),
				"",collegeId,realName,userName,time(createTime),time(updateTime),
				email,sex,time(createTime),phoneValidate ? 1 : 0,emailValidate ? 1 : 0,source,0);
		this.id = userId;
		updateByPair("password",password);
		UserStat.newStat(userId, uid, mac, uuid);
		return userId;
	}

	public static User validate(final String mobilePhone, final String password) throws SQLException {
		return db.selectOne("where `mobilePhone` = ? and `password` = ?",mobilePhone,Md5Util.md5AsLowerHex(password));
	}

	public static User grant(final String mobilePhone, final String token) throws SQLException {
		return db.selectOne("where `mobilePhone` = ? and `token` = ?",mobilePhone,token);
	}

	public int update() throws UnsupportedEncodingException, SQLException {
		this.updateTime = System.currentTimeMillis();
		return db.update("`mobilePhone` = ?,`password` = ?,`token` = ?,`collegeId` = ?,`realName` = ?,`userName` = ?," +
				"`createTime` = ?,`updateTime` = ?,`email` = ?,`sex` = ?,`birthday` = ?,`phoneValidate` = ?," +
				"`emailValidate` = ?,`source` = ? where `id` = ?",mobilePhone,Md5Util.md5AsLowerHex(password),TokenUtils.getToken(id,password),
				collegeId,realName,userName,time(createTime),time(updateTime),email,sex,time(birthday),phoneValidate,
				emailValidate,source,id);
	}
	
	

	public static User getById(final long id) throws SQLException {
		return db.selectOne("where `id` = ?",id);
	}

	public static User getByPhone(final String mobilePhone) throws SQLException {
		return db.selectOne("where `mobilePhone` = ?",mobilePhone);
	}

	public static List<User> getUsers(final int pageSize,final int currentPage) throws SQLException{
		return db.select("limit ? ,? ", (currentPage-1)*pageSize,pageSize) ;
	}
	
	public static List<User> getUsersByIds(List<UserStat> ids) throws SQLException{
		StringBuffer sb = new StringBuffer() ;
		sb.append("(") ;
		for (UserStat id : ids) {
			sb.append(id.userId);
			sb.append(",") ;
		}
		sb.deleteCharAt(sb.lastIndexOf(",")) ;
		sb.append(")") ;
		return db.select("where `id` in " + sb.toString()) ;
	}
	
	public static int count(String where, Object... params) throws SQLException{
		return db.selectCount(where,params) ;
	}
	public <T> int updateByPair(final String name,final T val) throws SQLException, UnsupportedEncodingException {
		if("password".equals(name))
			return db.update(_.f("`%s` = ?,`token` = ? where `id` = ?",name),
					Md5Util.md5AsLowerHex(String.valueOf(val)),TokenUtils.getToken(id,String.valueOf(val)) ,id);
		return db.update(_.f("`%s` = ? where `id` = ?",name),val,id);
	}
	
	//直接使用UserStat.geByUserId(id)方法，dao中未加
	public UserStat getUserStat() throws SQLException {
		if( userStat == null ){
			userStat = UserStat.geByUserId(id);
		}
		return userStat;
	}
	
	public int updateSourceByOpenid() throws SQLException {
		return updateSource(1);
	}

	public int updateSource(int source) throws SQLException {
		return db.update("`source` = ? where `id` = ?", source, id);
	}
	
	@Override
	public JsonObject toJson() throws SQLException {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id",id);
		jsonObject.addProperty("mobilePhone",mobilePhone);
		//jsonObject.addProperty("password",password);
		jsonObject.addProperty("token",token);
		jsonObject.addProperty("collegeId",collegeId);
		CollegeInfo collegeInfo = CollegeInfo.getById(collegeId);
		jsonObject.addProperty("collegeName", collegeInfo != null ? collegeInfo.name : "");
		jsonObject.addProperty("realName",trimToEmpty(realName));
		jsonObject.addProperty("userName",trimToEmpty(userName));
		jsonObject.addProperty("createTime",createTime);
		//jsonObject.addProperty("updateTime",updateTime);
		jsonObject.addProperty("email",email);
		jsonObject.addProperty("sex",sex);
		//jsonObject.addProperty("birthday",birthday);
		jsonObject.addProperty("phoneValidate",phoneValidate);
		//jsonObject.addProperty("emailValidate",emailValidate);
		//jsonObject.addProperty("source",source);
		try {
			userStat = getUserStat();
			jsonObject.add("stat", userStat.toJson());
		}catch (Exception e){
			e.printStackTrace();
		}
		return jsonObject;
	}

    public int updateRandomToken() throws Exception {
        return db.update("`randomToken` = ?,`productId` = ?,`randomId` = ?,`tokenCreateTime` = ? where `mobilePhone` = ?"
                ,randomToken,productId,randomId,time(tokenCreateTime),mobilePhone);
    }
	@Override
	public String toString(){
		try {
			return toJson().toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("tostring error");
	}

	private static final DBType1<User> db = Table.userDB;
}
