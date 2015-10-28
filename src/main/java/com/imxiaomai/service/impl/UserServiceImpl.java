package com.imxiaomai.service.impl;

import static com.imxiaomai.base._.trimToEmpty;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.JsonObject;
import com.imxiaomai.manager.CollegeManager;
import com.imxiaomai.manager.UserManager;
import com.imxiaomai.manager.UserStatManager;
import com.imxiaomai.persistence.domain.College;
import com.imxiaomai.persistence.domain.ExtraUser;
import com.imxiaomai.persistence.domain.User;
import com.imxiaomai.persistence.domain.UserGold;
import com.imxiaomai.persistence.domain.UserStat;
import com.imxiaomai.service.UserService;

public class UserServiceImpl implements UserService{
	
	@Autowired UserManager userManager;
	@Autowired UserStatManager userStatManager ;
	@Autowired CollegeManager collegeManager;
	
//	private final static int expir = ConfigUtil.getIntValue("codis.expir");
//	private final static int tryNum = ConfigUtil.getIntValue("codis.trynum");
//	private static CommonClient commonClient = new CommonClient(PoolType.roundRobin,tryNum);
//	private final static String codisPre = ConfigUtil.getStringValue("codis.dataPre")+"_user_";
	@Override
	@Deprecated
	public long insert(String mobilePhone, String password, int collegeId,
			String realName, String deviceType, String uid, int source)
			throws SQLException {

/*		try {
			//createTime和updateTime放到了dao层
			User user = new User();
			user.setMobilephone(mobilePhone);
			user.setPassword(password);
			user.setCollegeid(collegeId);
			user.setRealname(realName);
			user.setPhonevalidate(new Integer(1).byteValue());
			user.setToken("");
			user.setIspre(new Integer(0).byteValue());//非红包预生成用户
			String mac = "";
			String uuid = "";

			long userId =userManager.insert(user, uid, mac, uuid);
			putCacheById(userId);
			return userId;
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return 0;
	}
	
	public  User validate( String mobilePhone,  String password){
		return userManager.validate(mobilePhone,password);
	}
	
    public ExtraUser getExtraUserByOpenId(final String openId){
    	return userManager.getExtraUserByOpenId(openId);
    }

    public ExtraUser getUserByOpenIdExceptPre(final String openId){
    	return userManager.getUserByOpenIdExceptPre(openId);
    }
    
    public ExtraUser getExtraUserByMobilePhone(final String mobilePhone){
    	return userManager.getExtraUserByMobilePhone(mobilePhone);
    }
    
    public ExtraUser getExtraUserByUserId(final Integer userId){
    	return userManager.getExtraUserByUserId(userId);
    }
	
    public List<ExtraUser> getExtraUserByAreaId(final Integer areaId){
    	return userManager.getExtraUserByAreaId(areaId);
    }
    
    public ExtraUser getExtraUserByMobileForInnerJoin(String mobilePhone){
    	return userManager.getExtraUserByMobileForInnerJoin(mobilePhone);
    }
    
	public <T> int updateByPair( String name, T val,String conditionName ,T conditionValue) {
		
		int res=userManager.updateByPair(  name,  val, conditionName , conditionValue);
		/*if(res>0){//此方法加入缓存需要查询2次库
			User  user=userManager.selectByPair( conditionName , conditionValue);
			if(user!=null){
				putCacheById(new Long(user.getId()));
			}
		}*/
		return res;
	}
	
	/**
	 * 为红包开发，已弃用，故此处不修改userSource表的手机号
	 */
	@Deprecated
	public Map<Object,Object> updateBindPhone(String openId,String mobilePhone){
		 Map<Object,Object> map=new HashMap<Object,Object>();
		 try{
				ExtraUser user=getExtraUserByMobilePhone(mobilePhone);
				System.out.println("getExtraUserByMobilePhone : "+user);
				if(user!=null){
					if(user.getId()>0){
						if(openId.equalsIgnoreCase(user.getOpenId())){
							map.put("code", -1);
							map.put("desc", "手机号已经和openId绑定");
						}else{
							map.put("code", -1);
							map.put("desc", "手机号已经和其他openId进行了绑定,不能再绑");
						}
					}
				}else{//更新绑定关系
					user=getExtraUserByOpenId(openId);
					if(user!=null){
						int userId=user.getId();
						int res=updateByPair("mobilePhone", mobilePhone, "id", userId);
						if(res>0){
//							putCacheById(new Long(userId));
							map.put("code", 0);
							map.put("desc", "修改成功");
						}else{
							map.put("code", -1);
							map.put("desc", "修改失败");
						}
					}else{
						map.put("code", -1);
						map.put("desc", "openId不存在");
					}
				}
			}catch(Exception e){
				System.out.println("Exception: "+e);
				map.put("code", -1);
				map.put("desc", "发生错误");
			}
		 return map;
	 }
	
	 public User getUserByOpenId(String openId){
		 return userManager.getUserByOpenId(openId);
	 }
	 
	 public int updateRandomToken(String randomId, String productId ,String randomToken,String mobilePhone){
		 int res=userManager.updateRandomToken(randomId, productId ,randomToken,mobilePhone);
		/* if(res>0){
			 putCacheByPhone(mobilePhone);
		 }*/
		 return res;
	 }

	@Override
	public long insert(User record, String uid, String mac, String uuid)throws Exception {
		long id=userManager.insert(record, uid, mac, uuid);
		/*if(id>0){
			putCacheById(id);
		}*/
		
		return id;
	}

	@Override
	public User grant(String mobilePhone, String token) {
		return userManager.grant(mobilePhone, token) ;
	}

	@Override
	public int update(User record) {
		int res=userManager.update(record);
/*		long id=new Long(record.getId());
		putCacheById(id);*/
		return  res;
	}

	@Override
	public User getById(Long id) {
/*		byte[] sObject = commonClient.get((codisPre+id.toString()).getBytes());
		if(sObject == null){
			User u =  putCacheById(id);
			return u;
		}else{
			User ur = (User) RedisUtil.unserialize(sObject);
			return ur;
		}*/
		
		return userManager.getById(id);
	}

	@Override
	public User getByPhone(String mobilePhone) {
/*		byte[] sObject = commonClient.get((codisPre+mobilePhone).getBytes());
		if(sObject == null){
			return putCacheByPhone(mobilePhone);
		
		}else{
			User ur = (User) RedisUtil.unserialize(sObject);
			return ur;
		}*/
		return userManager.getByPhone(mobilePhone);
	}

	@Override
	public List<User> getUsers(Integer pageSize, Integer currentPage) {
		return userManager.getUsers(pageSize, currentPage) ;
	}

	@Override
	public List<User> getUsersByIds(List<UserStat> ids) {
		return userManager.getUsersByIds(ids) ;
	}

	@Override
	public int count(String where, Object... params) {
		return userManager.count(where, params); 
	}

	@Override
	public int updatePassword(String password, Integer id) throws Exception {
		int res=userManager.updatePassword(password, id); 
/*		if(res>0){
			putCacheById(new Long(id));
		}	*/
		return res;
	}
	
	/**
	 * 
	 * @param password
	 * @param id
	 * @param flag 原微信用户已经通过注册流程修改了密码的标记位
	 * @return
	 */
	@Override
	public  int updatePasswordAndFlag( String password,Integer id,Integer flag) throws Exception{
		int res= userManager.updatePasswordAndFlag(password, id,flag); 
/*		if(res>0){
			putCacheById(new Long(id));
		}	*/
		return res;
	}

	@Override
	public int updateSourceByOpenid(Integer id) {
		int res=  userManager.updateSourceByOpenid( id); 
/*		if(res>0){
			putCacheById(new Long(id));
		}*/	
		return res;
	}

	@Override
	public int updateSource(Integer source, Integer id) {
		int res=   userManager.updateSource(source, id); 
/*		if(res>0){
			putCacheById(new Long(id));
		}*/	
		return res;
	}

	@Override
	public  List<UserGold> selectOrderByGold(int retNum){
		return userManager.selectOrderByGold(retNum); 
	}
	
	
/*	private User putCacheById(Long id){
		User u =  userManager.getById(id);
		putCacheByUser(u);
		return u;
	}
	
	
	private User putCacheByPhone(String mobilePhone){
		User u =  userManager.getByPhone(mobilePhone);
		putCacheByUser(u);
		return u;
	}

	private void putCacheByUser(User user){
		if(user != null){
			commonClient.setex((codisPre+user.getId().toString()).getBytes(), expir, RedisUtil.serialize(user));
			commonClient.setex((codisPre+user.getMobilephone()).getBytes(), expir, RedisUtil.serialize(user));
		}
	}*/
	
	
	@Override
	public JsonObject toJson(User user) {
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id",user.getId());
		jsonObject.addProperty("mobilePhone",user.getMobilephone());
		jsonObject.addProperty("password",user.getPassword());
		jsonObject.addProperty("token",user.getToken());
		jsonObject.addProperty("collegeId",user.getCollegeid());
		College college =collegeManager.getById(new Long(user.getCollegeid()));
		jsonObject.addProperty("collegeName", college != null ? college.getName(): "");
		jsonObject.addProperty("realName",trimToEmpty(user.getRealname()));
		jsonObject.addProperty("userName",trimToEmpty(user.getUsername()));
		jsonObject.addProperty("createTime",user.getCreatetime()!=null?user.getCreatetime().getTime():0L);
		jsonObject.addProperty("updateTime",user.getUpdatetime()!=null?user.getUpdatetime().getTime():0L);
		jsonObject.addProperty("email",user.getEmail());
		jsonObject.addProperty("sex",user.getSex());
		jsonObject.addProperty("birthday",user.getBirthday()!=null?user.getBirthday().getTime():0L);
		jsonObject.addProperty("phoneValidate",user.getPhonevalidate());
		jsonObject.addProperty("emailValidate",user.getEmailvalidate());
		jsonObject.addProperty("source",user.getSource());
		jsonObject.addProperty("isdel",user.getIsdel());
		jsonObject.addProperty("ispre",user.getIspre());
		jsonObject.addProperty("updatePwdflag",user.getUpdatePwdFlag());
		jsonObject.addProperty("productId",user.getProductId());
		jsonObject.addProperty("randomId",user.getRandomId());
		jsonObject.addProperty("randomToken",user.getRandomToken());
		jsonObject.addProperty("tokenCreateTime",user.getTokencreatetime()!=null?user.getTokencreatetime().getTime():0L);
		
		try {
			UserStat userStat = userStatManager.getByUserId(new Long(user.getId()));
			JsonObject jsonObject1 = new JsonObject();
			if(userStat !=null){
				jsonObject1.addProperty("userId",userStat.getUserid());
				jsonObject1.addProperty("headImgUrl",userStat.getHeadimgurl());
				jsonObject1.addProperty("score",userStat.getScore());
				jsonObject1.addProperty("gold",userStat.getGold());
				jsonObject1.addProperty("versionCode",userStat.getVersioncode());
				jsonObject1.addProperty("uid",userStat.getUid());
				jsonObject1.addProperty("modifiedTime",userStat.getModifiedtime()!=null?userStat.getModifiedtime().getTime():0L);
				jsonObject1.addProperty("isGift",userStat.getIsgift());
				jsonObject1.addProperty("mac",userStat.getMac());
				jsonObject1.addProperty("uuid",userStat.getUuid());
				jsonObject1.addProperty("inviteCount",userStat.getInvitecount());
				jsonObject1.addProperty("inviteHitCount",userStat.getInvitehitcount());
			}else{
				jsonObject1.addProperty("userId",0);
				jsonObject1.addProperty("headImgUrl","");
				jsonObject1.addProperty("score",0);
				jsonObject1.addProperty("gold",0);
				jsonObject1.addProperty("versionCode","");
				jsonObject1.addProperty("uid","");
				jsonObject1.addProperty("modifiedTime",0L);
				jsonObject1.addProperty("isGift",0);
				jsonObject1.addProperty("mac","");
				jsonObject1.addProperty("uuid","");
				jsonObject1.addProperty("inviteCount",0);
				jsonObject1.addProperty("inviteHitCount",0);

			}

			jsonObject.add("stat", jsonObject1);
		}catch (Exception e){
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	@Override
	public Map<String ,Object> toMap(User user) {
		
		Map<String ,Object> map= new HashMap<String ,Object> ();
		map.put("id",user.getId());
		map.put("mobilePhone",user.getMobilephone());
		map.put("password",user.getPassword());
		map.put("token",user.getToken());
		map.put("collegeId",user.getCollegeid());
		College college =collegeManager.getById(new Long(user.getCollegeid()));
		map.put("collegeName", college != null ? college.getName(): "");
		map.put("realName",trimToEmpty(user.getRealname()));
		map.put("userName",trimToEmpty(user.getUsername()));
		map.put("createTime",user.getCreatetime()!=null?user.getCreatetime().getTime():0L);
		map.put("updateTime",user.getUpdatetime()!=null?user.getUpdatetime().getTime():0L);
		map.put("email",user.getEmail());
		map.put("sex",user.getSex());
		map.put("birthday",user.getBirthday()!=null?user.getBirthday().getTime():0L);
		map.put("phoneValidate",user.getPhonevalidate());
		map.put("emailValidate",user.getEmailvalidate());
		map.put("source",user.getSource());
		map.put("isdel",user.getIsdel());
		map.put("ispre",user.getIspre());
		map.put("updatePwdflag",user.getUpdatePwdFlag());
		map.put("productId",user.getProductId());
		map.put("randomId",user.getRandomId());
		map.put("randomToken",user.getRandomToken());
		map.put("tokenCreateTime",user.getTokencreatetime()!=null?user.getTokencreatetime().getTime():0L);
		
		try {
			UserStat userStat = userStatManager.getByUserId(new Long(user.getId()));
			Map<String ,Object> map1= new HashMap<String ,Object> ();
			if(userStat !=null){
				map1.put("userId",userStat.getUserid());
				map1.put("headImgUrl",userStat.getHeadimgurl());
				map1.put("score",userStat.getScore());
				map1.put("gold",userStat.getGold());
				map1.put("versionCode",userStat.getVersioncode());
				map1.put("uid",userStat.getUid());
				map1.put("modifiedTime",userStat.getModifiedtime()!=null?userStat.getModifiedtime().getTime():0L);
				map1.put("isGift",userStat.getIsgift());
				map1.put("mac",userStat.getMac());
				map1.put("uuid",userStat.getUuid());
				map1.put("inviteCount",userStat.getInvitecount());
				map1.put("inviteHitCount",userStat.getInvitehitcount());
			}else{
				map1.put("userId",0);
				map1.put("headImgUrl","");
				map1.put("score",0);
				map1.put("gold",0);
				map1.put("versionCode","");
				map1.put("uid","");
				map1.put("modifiedTime",0L);
				map1.put("isGift",0);
				map1.put("mac","");
				map1.put("uuid","");
				map1.put("inviteCount",0);
				map1.put("inviteHitCount",0);
			}
			map.put("stat", map1);
//			_.asMap("stat", map1);
		}catch (Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	
	
	
}
