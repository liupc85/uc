package com.imxiaomai.web;

import static com.imxiaomai.base._.asMap;
import static com.imxiaomai.base._.isEmpty;
import static com.imxiaomai.base._.toInt;
import static com.imxiaomai.base._.trimToEmpty;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.imxiaomai.base._;
import com.imxiaomai.base.crawler.Crawler;
import com.imxiaomai.base.digt.Md5Util;
import com.imxiaomai.base.infrastructure.Config;
import com.imxiaomai.base.util.JsonUtil;
import com.imxiaomai.constants.Constant;
//import com.imxiaomai.entity.MiDevice;
//import com.imxiaomai.entity.ScoreList;
//import com.imxiaomai.entity.ScoreList;
//import com.imxiaomai.entity.StoreInfo;
//import com.imxiaomai.entity.User;
//import com.imxiaomai.entity.UserGold;
//import com.imxiaomai.entity.UserStat;
//import com.imxiaomai.entity.WxUnBindUser;
import com.imxiaomai.persistence.domain.Device;
import com.imxiaomai.persistence.domain.ExtraUser;
import com.imxiaomai.persistence.domain.Midevice;
import com.imxiaomai.persistence.domain.Scorelist;
import com.imxiaomai.persistence.domain.Store;
import com.imxiaomai.persistence.domain.User;
import com.imxiaomai.persistence.domain.UserGold;
import com.imxiaomai.persistence.domain.UserSource;
import com.imxiaomai.persistence.domain.UserStat;
import com.imxiaomai.persistence.domain.WxBindUser;
import com.imxiaomai.service.DeviceService;
import com.imxiaomai.service.MiDeviceService;
import com.imxiaomai.service.ScorelistService;
import com.imxiaomai.service.StoreService;
import com.imxiaomai.service.UserService;
import com.imxiaomai.service.UserSourceService;
import com.imxiaomai.service.UserStatService;
import com.imxiaomai.service.WxBindUserService;
import com.imxiaomai.web.base.BaseController;

@Controller
public class UserAction extends BaseController{
	
	@Autowired UserService userService;
	@Autowired UserSourceService userSourceService;
	@Autowired UserStatService userStatService;
	@Autowired WxBindUserService wxBindUserService;
	@Autowired ScorelistService scorelistService;
	@Autowired StoreService storeService;
	@Autowired DeviceService deviceService;
	@Autowired MiDeviceService  miDeviceService;
	private static final Logger log = LoggerFactory.getLogger(UserAction.class);

	@RequestMapping("/user/init4wx")
	@ResponseBody
	public Object initWxPage( HttpServletRequest request) throws SQLException, IOException {
	
		long userId = -1;
		int code = 0;
		String msg = "";
		
		String data = getDataFromRequest(request);	
		log.info("post user.imxiaomai.com/user/init4wx \t", data);
		JsonNode jsonNode = JsonUtil.parse(data);
		final String openid = jsonNode.findValue("openid") == null ? "" : jsonNode.findValue("openid").asText();
		String nickname = jsonNode.findValue("nickname") == null ? "" : jsonNode.findValue("nickname").asText();
		final String sex = jsonNode.findValue("sex") == null ? "" : jsonNode.findValue("sex").asText();
		final String headimgurl = jsonNode.findValue("headimgurl") == null ? "" : jsonNode.findValue("headimgurl").asText();
		
		// 判断用户是否已经注册
		WxBindUser unBindUser = wxBindUserService.getByOpenId(openid);
		if( unBindUser == null) {//没有微信绑定记录，插入
//			System.out.println("nickname "+nickname);
			if(!StringUtils.isEmpty(nickname)){
//				nickname=EmojiFilter.filter(nickname);//.filterEmoji(nickname);
//				System.out.println("nickname "+nickname);
			}
//			System.out.println("filter nickname "+nickname);
//			WxBindUser.newRecord(openid, trimToEmpty(nickname), toInt(sex), trimToEmpty(headimgurl));
			wxBindUserService.newRecord(openid, trimToEmpty(nickname), toInt(sex), trimToEmpty(headimgurl),0,0);
			//调用微信的接口，根据openId获取UnionID，app微信登录需要用UnionID，不能用openId
			String url =Config.of("wxUrl", "/uid/getByAppOpenId").get();
			String unionId=getUnionID(url,openid);
			wxBindUserService.updateByPair("unionId", unionId, "openId", openid);
			
		} else {
			if(unBindUser.getUserid()!= 0){
				userId = unBindUser.getUserid();
				//判断是否是预生成用户
				User user=userService.getById(userId);
				if(user==null){
					userId =-1;
				}else{
					if(user.getIspre()==null||new Integer(user.getIspre()).intValue()==1){//ispre=1 说明是预生成用户，仍然走注册流程
						userId =-1;
					}
				}
			}
			log.info("user.imxiaomai.com/user/init4wx return \t", userId);
		}
		if(unBindUser == null){
			return buildJson(code, msg, _.asMap("userId", userId,"updateTime",""));
		}else{
			return buildJson(code, msg, _.asMap("userId", userId,"updateTime",unBindUser.getUpdatetime()));
		}
		
	}

	
	@RequestMapping("/user/bind4wx")
	@ResponseBody
	public Object bind4wx(HttpServletRequest request) throws Exception {
		Map<String, Object> result = _.asMap();
		
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);
		log.debug("post user.imxiaomai.com/user/bind 参数 \t"+ data);
		
		String telphone = jsonNode.findValue("telphone") == null ? "" : jsonNode.findValue("telphone").asText();
		String smsCode = jsonNode.findValue("smsCode") == null ? "" : jsonNode.findValue("smsCode").asText();
		String openid = jsonNode.findValue("openid") == null ? "" : jsonNode.findValue("openid").asText();
		int collegeId = jsonNode.findValue("collegeId") == null ? 0 : jsonNode.findValue("collegeId").asInt();
		String icode = jsonNode.findValue("icode") == null ? "" : jsonNode.findValue("icode").asText();
		
		String deviceType = "";
		String uid = "";
		int source = 3;
		
		if( isEmpty(openid) ){
			return buildJson(-1, "参数错误");
		}

		if(isEmpty(telphone) || isEmpty(smsCode))
			return buildJson(-2, "电话号码或者验证码不能为空");


		//新增用户
		WxBindUser wxUser = wxBindUserService.getByOpenId(openid);
		if(wxUser == null) {
			//不能走到这一步，因为前一个请求一定已经加入了用户的微信信息了
			log.error("错误！/user/bind4wx中发现没有找到openid的用户信息,openid:{}", openid);
			return buildJson(-3, "系统错误");
		}

		if (wxUser.getUserid()!=null&&wxUser.getUserid()> 0) {
			//已经绑定用户了
			User user=userService.getById(new Long(wxUser.getUserid()));
			if(user==null||user.getIspre().intValue()==1){//预生成用户，需要走下面的注册流程
				System.out.println("user is "+user);
			}else{
				result = _.asMap("userId", wxUser.getUserid());
				return buildJson(0, "校验成功", result);
			}
		}

		String randomPwd = Md5Util.md5AsLowerHex(String.valueOf(System.currentTimeMillis()));
		String realName = (wxUser != null ? wxUser.getNickname(): "");

		long userId = 0;
		//要保证微信号和手机号一对一的关系
		//判断此手机号是否已经被其他用户绑定过了，如果是，不允许继续绑定。
//		User oldUser = User.getByPhone(telphone);
		User oldUser =userService.getByPhone(telphone);
		if (oldUser != null) {
			WxBindUser oldBindedWxUser = wxBindUserService.getByUserId(new Long(oldUser.getId()));
			if(oldBindedWxUser != null){
				if(oldUser.getIspre()==1){
					//修改预生成标记位为2，说明走了注册流程
					userService.updateByPair("ispre", 2, "id", oldUser.getId());
					//红包预生成时已经插入了userSource表,故此处不再插入
					//预生成用户，关联关系都已经建立，直接返回成功提示
					result = _.asMap("userId",oldUser.getId());
					return buildJson(0, "校验成功", result);
				}else{
					//此手机号已经绑定过了，不能换绑
					return buildJson(-3, "您的手机号已经绑定其他用户了，请联系客服");
				}

			}else{//app用户，关注了微信，但是尚未关联，通过openid和userid建立关联关系
				if(oldUser.getIspre()==1){//预生成用户
					//红包预生成时已经插入了userSource表,故此处不再插入
					//修改预生成标记位为2，说明走了注册流程
					userService.updateByPair("ispre", 2, "id", oldUser.getId());
				}else{//app用户，关注了微信,插入用户来源表
					UserSource userSource=new UserSource();
					userSource.setUserid(new Long(oldUser.getId()).intValue());
					userSource.setMobilephone(telphone);
					userSource.setSourcecode(new Integer(Constant.USER_SOURCE_WX).byteValue());
					userSourceService.insertUserSource(userSource);
				}
				wxBindUserService.updateByPair("userId", oldUser.getId(), "openId", openid);
				wxBindUserService.updateByPair("bind", 1, "openId", openid);
			}
			userId = oldUser.getId();
		}else{
			//还没有此用户
			//使用下面的insert方法
//			userId =userService.insert(telphone, randomPwd, collegeId, realName, deviceType, uid, source);
			User user = new User();
			user.setMobilephone(telphone);
			user.setPassword(randomPwd);
			user.setCollegeid(collegeId);
			user.setRealname(realName);
			user.setPhonevalidate(new Integer(1).byteValue());
			user.setToken("");
			user.setIspre(new Integer(0).byteValue());//非红包预生成用户
			String mac = "";
			String uuid = "";
			//通过app注册(不区分麦客和商城)，updatePwdFlag设置为2，通过微信注册，设置为0，微信注册后，再走app注册，改为1
			user.setUpdatePwdFlag(new Integer(0).byteValue());
			userId =userService.insert(user, uid, mac, uuid);
			if(userId>0){//插入用户来源表
				UserSource userSource=new UserSource();
				userSource.setMobilephone(telphone);
				userSource.setUserid(new Long(userId).intValue());
				userSource.setSourcecode(new Integer(Constant.USER_SOURCE_WX).byteValue());
				userSourceService.insertUserSource(userSource);
			}
			if( userId <= 0 ){
				return buildJson(-4, "添加用户校验失败");
			}
		}

		// 修改头像 && 增加user表source && 修改wxUnBindUser userId
//		User user = User.getById(userId);
		if( wxUser != null ) {
//			user.getUserStat().updateIcon(trimToEmpty(wxUser.getHeadimgurl()));
//			user.updateSource(source);
			userStatService.updateIcon(trimToEmpty(wxUser.getHeadimgurl()), userId);
			userService.updateSource(source, (int)userId);
		}
		int id=wxUser.getId();
		wxBindUserService.updateUserId(userId, icode, new Long(id).longValue());

		result = _.asMap("userId", userId);
		return buildJson(0, "校验成功", result);
	}

	

	/**
	 * 根据微信的openid获得用户id
	 * 目前系统中，openid和用户id应该是一一对应的关系
	 *
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/user/getUserIdByWxOpenId")
	@ResponseBody
	public Object getUserIdByWxOpenId(HttpServletRequest request) throws SQLException, IOException {

		String data = getDataFromRequest(request);
		log.info("{}, data:{}", request.getRequestURI(), data);

		JsonNode jsonNode = JsonUtil.parse(data);
		String openId = jsonNode.findValue("openId") == null ? "" : jsonNode.findValue("openId").asText();

		if(isEmpty(openId)){
			return buildJson(-1, "openId不能为空");
		}

//		WxUnBindUser wxUser = WxUnBindUser.getByOpenId(openId);
		 WxBindUser wxUser=wxBindUserService.getByOpenId(openId);
		if(wxUser == null){//未查询到数据,返回空对象
			//还没有绑定，没有对应的用户id
			return buildJson(0, "", asMap("userId", 0));
		}else{
			//已经绑定，有对应的用户id
			return buildJson(0, "", asMap("userId", wxUser.getUserid()));
		}
	}
	
	/**
	 * 根据微信的openid获得用户id
	 * 目前系统中，openid和用户id应该是一一对应的关系
	 *
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/user/getWxOpenIdByUserId")
	@ResponseBody
	public Object getWxOpenIdByUserId(HttpServletRequest request) throws SQLException, IOException {

		String data = getDataFromRequest(request);
		log.info("{}, data:{}", request.getRequestURI(), data);

		JsonNode jsonNode = JsonUtil.parse(data);
		String userIdStr = jsonNode.findValue("userId") == null ? "" : jsonNode.findValue("userId").asText();

		if(isEmpty(userIdStr)){
			return buildJson(-1, "userId不能为空,且是Long类型");
		}
		
		long userId = _.toLong(userIdStr, 0L);
		
		if(userId <= 0){
			return buildJson(-1, "userId不能为空,且是Long类型");
		}

//		WxUnBindUser wxUser = WxUnBindUser.getByUserId(userId);
		WxBindUser wxUser=wxBindUserService.getByUserId(userId);
		if(wxUser == null || isEmpty(wxUser.getOpenid())){
			//还没有绑定，没有对应的用户id
			return buildJson(0, "", asMap("openId", 0));
		}else{
			//已经绑定，有对应的用户id
			return buildJson(0, "", asMap("openId", wxUser.getOpenid()));
		}
	}
	
	@RequestMapping("/user/getWxOpenIdsByUserIds")
	@ResponseBody
	public Object getWxOpenIdsByUserIds(HttpServletRequest request) throws SQLException, IOException {

		String data = getDataFromRequest(request);
		log.info("{}, data:{}", request.getRequestURI(), data);

		JsonNode jsonNode = JsonUtil.parse(data);
		
		List<Long> userIds = new ArrayList<>();
        JsonNode userIdsNode = jsonNode.get("userIds");
        if(userIdsNode.isArray()) {
        	for (final JsonNode objNode : userIdsNode) {
        		userIds.add(_.toLong(objNode.asText()));
        	}
        }

		if(_.isEmpty(userIds)){
			return buildJson(-1, "userIds不能为空,且都是Long类型");
		}
		
//		List<WxUnBindUser> wxUsers = WxUnBindUser.getByUserIds(userIds);
		List<WxBindUser> wxUsers = wxBindUserService.getByUserIds(userIds);
		Map<Object, Object> datas = new HashMap<Object, Object>();
		if(_.isEmpty(wxUsers)){
			//还没有绑定，没有对应的用户id
			return buildJson(0, "", datas);
		}else{
			
			for(WxBindUser wxUser : wxUsers) {
				datas.put(wxUser.getUserid(), wxUser.getOpenid());
			}
			
			//已经绑定，有对应的用户id
			return buildJson(0, "", datas);
		}
	}
	
	@RequestMapping("/user/getById")
	@ResponseBody
	public Object getUserById(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);
		final long userId = jsonNode.findValue("userId") == null ? 0 : jsonNode.findValue("userId").asLong();
		User user = userService.getById(userId);
		if( user != null ) {
//			JsonObject result = new JsonObject();
//			result.addProperty("code", 0);
//			result.addProperty("msg", "");
//			result.add("data", user.toJson());
//			result.add("data", userService.toJson(user));
//			return result.toString();
//			return result;
//			return buildJson(0,"",userService.toJson(user));
//			System.out.println("-----------"+userService.toJson(user));
//			System.out.println(buildJson(0,"",userService.toJson(user).toString() ));
//			Gson g=new Gson ();
//			String s=g.toJson(result);
//			System.out.println("s "+s);
//			return s;
//			return buildJson(0,"",userService.toJson(user));
//			return userService.toJson(user).toString();
			
//			return buildJson(0,"",new String(userService.toJson(user).toString().getBytes("UTF-8"),"UTF-8"));

			return buildJson(0,"",userService.toMap(user));
		}
//		return buildErrJson(-1,"未找到此用户").toString();
		return buildJson(-1,"未找到此用户");
	}

	@RequestMapping("/user/getUserStatById")
	@ResponseBody
	public Object getUserStatById(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);
		final long userId = jsonNode.findValue("userId") == null ? 0 : jsonNode.findValue("userId").asLong();
		
		UserStat us = userStatService.getByUserId(userId) ;
		if( us != null ) {
//			JsonObject result = new JsonObject();
//			result.addProperty("code", 0);
//			result.addProperty("msg", "");
////			result.add("data", user.toJson());
//			result.add("data", userStatService.toJson(us));
//			return result.toString();
			return buildJson(0,"",us);
		}
//		return buildErrJson(-1,"未找到此用户").toString();
		return buildJson(-1,"未找到此用户");
	}
	
	
	@RequestMapping("/user/getByPhone")
	@ResponseBody
	public Object getByPhone(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);
		final String mobilePhone = jsonNode.findValue("mobilePhone") == null ? "" : jsonNode.findValue("mobilePhone").asText();
//		User user = User.getByPhone(mobilePhone);
		User user = userService.getByPhone(mobilePhone);
		if( user != null ) {
//			JsonObject result = new JsonObject();
//			result.addProperty("code", 0);
//			result.addProperty("msg", "");
////			result.add("data", user.toJson());
//			result.add("data", userService.toJson(user));
//			return result.toString();
//			return buildJson(0,"",userService.toJson(user));
			return buildJson(0,"",userService.toMap(user));
		}
//		return buildErrJson(-1,"未找到此用户~").toString();
		return buildJson(-1,"未找到此用户");
	}
	
	/**
	 * 根据电话查询用户信息，user和wx_bind_user内连接，暂时只有门店使用（2015-09-14）
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	@RequestMapping("/user/getExtraUserByPhoneForInnerJoin")
	@ResponseBody
	public Object getExtraUserByPhoneForInnerJoin(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);
		final String mobilePhone = jsonNode.findValue("mobilePhone") == null ? "" : jsonNode.findValue("mobilePhone").asText();
		ExtraUser user = userService.getExtraUserByMobileForInnerJoin(mobilePhone);
		if( user != null ) {
			return buildJson(0,"",user);
		}
		return buildJson(-1,"未找到此用户");
	}
	

	//麦客注册时会调用此方法，判断是否已注册麦客
	@RequestMapping("/user/getByPhoneForCourier")
	@ResponseBody
	public Object getByPhoneForCourier(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);
		final String mobilePhone = jsonNode.findValue("mobilePhone") == null ? "" : jsonNode.findValue("mobilePhone").asText();
//		User user = User.getByPhone(mobilePhone);
		User user = userService.getByPhone(mobilePhone);
		if(user!= null){
			int userId=user.getId();
			List<UserSource> users=userSourceService.queryUserSourceByUserId(userId);
			boolean isCourier=false;
			if(!users.isEmpty()&&users.size()>0){
				int len=users.size();
				for(int i=0;i<len;i++){
					if(users.get(i).getSourcecode()==Constant.USER_SOURCE_COURIER){
						isCourier=true;
						break;
					}
				}
			}
			if(isCourier){//已注册麦客APP,提示已注册
				return buildJson(0,"",userService.toMap(user));
			}else{
				return buildJson(-1,"未找到此用户");
			}
		}
		return buildJson(-1,"未找到此用户");
		
	}
	
	
	
	@RequestMapping("/user/getStoreInfo")
	@ResponseBody
	public Object getStoreInfo(HttpServletRequest request) throws IOException, SQLException {
		final String rawData = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(rawData);
		final long userId = jsonNode.findValue("userId").asLong();
//		User user = User.getById(userId);
		User user = userService.getById(userId);
		if( user == null ){
			return buildJson(-1,"参数错误~");
		}
//		StoreInfo storeInfo = StoreInfo.getByCollegeId(user.getCollegeid());
		Store bean =new Store();
		bean.setCollegeId(user.getCollegeid());
		bean.setIsdel(0);//以前沒有isdel條件，為0是未刪除
		Store store=storeService.getByCollegeId(bean);
//		return buildRetJson(0,"",store);
		if(store==null){
			store=new Store();
		}
		return buildJson(0,"",store);
	}

	
	//接口为麦客APP开发
	@RequestMapping("/user/add")
	@ResponseBody
	public Object addUser(HttpServletRequest request) throws Exception {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);

		String device = jsonNode.findValue("deviceType") != null ? jsonNode.findValue("deviceType").asText() : "";
		String uid = jsonNode.findValue("uid") != null ? jsonNode.findValue("uid").asText() : "";
		String mac = jsonNode.findValue("mac") != null ? jsonNode.findValue("mac").asText() : "";
		String uuid = jsonNode.findValue("uuid") != null ? jsonNode.findValue("uuid").asText() : "";
		String mobilePhone = jsonNode.findValue("mobilePhone").asText();
		String password = jsonNode.findValue("password").asText();
		int  collegeId = jsonNode.findValue("collegeId").asInt();
		String realName = jsonNode.findValue("realName").asText();
		
		User temp=userService.getByPhone(mobilePhone);
		if(temp!= null){
			int userId=temp.getId();
			List<UserSource> users=userSourceService.queryUserSourceByUserId(userId);
			boolean isCourier=false;
			if(!users.isEmpty()&&users.size()>0){
				int len=users.size();
				for(int i=0;i<len;i++){
					if(users.get(i).getSourcecode()==Constant.USER_SOURCE_COURIER){
						isCourier=true;
						break;
					}
				}
			}
			if(isCourier){//已注册麦客APP,提示已注册
				return buildJson(-1,"该手机号已经存在，请更换手机号重新注册或点击登录并找回密码~");
			}
		}
		if(temp==null){//user表无数据
			User record= new User();
			record.setMobilephone(mobilePhone);
			record.setPassword(password);
			record.setCollegeid(collegeId);
			record.setRealname(realName);
			record.setPhonevalidate(new Integer(1).byteValue());
			record.setToken("");
			record.setIspre(new Integer(0).byteValue());//非红包预生成用户
			//通过微信注册，设置为0，微信注册后，再走app注册，改为1,通过app注册(不区分麦客和商城)，updatePwdFlag设置为2，
			record.setUpdatePwdFlag(new Integer(2).byteValue());
//			long userId = user.insert(uid, mac, uuid);
			long userId = userService.insert(record, uid, mac, uuid);
			if( userId > 0 ){
				//插入用户来源表
				UserSource userSource=new UserSource();
				userSource.setUserid(new Long(userId).intValue());
				userSource.setMobilephone(mobilePhone);
				userSource.setSourcecode(new Integer(Constant.USER_SOURCE_COURIER).byteValue());
				userSourceService.insertUserSource(userSource);
				
				User user = userService.getById(userId);
				UserStat us = userStatService.getByUserId(userId) ;
				
				Map<String,Object> map=userService.toMap(user);
				if (isAndroid(device)) {  // android
					if( user.getCollegeid()== 9 )
						map.put("isGift", us.getIsgift());
				}
				return buildJson(0,"",map);
			}
		}else{//user表有数据，只插入用户来源表
			int userId= temp.getId();
			UserSource userSource=new UserSource();
			userSource.setUserid(userId);
			userSource.setMobilephone(mobilePhone);
			userSource.setSourcecode(new Integer(Constant.USER_SOURCE_COURIER).byteValue());
			userSourceService.insertUserSource(userSource);
			
			User user = userService.getById(new Long(userId).longValue());
			UserStat us = userStatService.getByUserId(new Long(userId).longValue()) ;
			Map<String,Object> map=userService.toMap(user);
			if (isAndroid(device)) {  // android
				if( user.getCollegeid()== 9 )
					map.put("isGift", us.getIsgift());
			}
			return buildJson(0,"",map);
		}
		return buildJson(-1,"添加失败~");
	}
	
	private boolean isAndroid(String device){
		if ("Android".equalsIgnoreCase(device)) {
			return true ;
		}
		return false ;
	}

	@RequestMapping("/user/update")
	@ResponseBody
	public Object updateUser(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);

		final String mobilePhone = jsonNode.findValue("mobilePhone").asText();
		final String key = jsonNode.findValue("key").asText();
		final String val = jsonNode.findValue("value").asText();

//		User user = User.getByPhone(mobilePhone);
//		user.updateByPair(key,val);
		User user =userService.getByPhone(mobilePhone);
		if( user == null ){
			return buildJson(-1,"参数错误~");
		}
		userService.updateByPair(key, val, "id", user.getId());
//		return buildRetJson(0,"修改成功~",userService.getByPhone(mobilePhone));
		return buildJson(0,"修改成功~",userService.getByPhone(mobilePhone));
	}

	@RequestMapping("/user/resetPassword")
	@ResponseBody
	public Object resetPwd(HttpServletRequest request) throws Exception {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);

		final String mobilePhone = jsonNode.findValue("mobilePhone").asText();
		final String password = jsonNode.findValue("password").asText();

//		User user = User.getByPhone(mobilePhone);
		User user =userService.getByPhone(mobilePhone);
		if( user == null ){
			return buildJson(-1,"参数错误~");
		}
//		user.updateByPair("password",password);
		userService.updatePassword(password, user.getId());
//		return buildRetJson(0,"",userService.getByPhone(mobilePhone));
		return buildJson(0,"",userService.getByPhone(mobilePhone));
	}

	@RequestMapping("/user/updateStat")
	@ResponseBody
	public Object updateStat(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);

		final long userId = jsonNode.findValue("userId").asLong();
		final String key = jsonNode.findValue("key").asText();
		final String val = jsonNode.findValue("value").asText();
		final String tips = jsonNode.findValue("tips").asText();
		final int identify = jsonNode.findValue("identify").asInt();
		final int outId = jsonNode.findValue("outId").asInt();

//		UserStat stat = User.getById(userId).getUserStat();
		UserStat stat = userStatService.getByUserId(userId);
		if(stat ==null){
			stat =new UserStat();
		}
		if( "score".equalsIgnoreCase(key) ) {
//			stat.updateByPair("score", stat.getScore()+ _.toInt(val));
//			ScoreList.insert(userId,_.toInt(val),ScoreList.SCORE_TYPE,identify,outId,tips);
			userStatService.updateByPair("score", stat.getScore()+ _.toInt(val), (int)userId);
			scorelistService.insert((int)userId, _.toLong(val), new Long(Scorelist.SCORE_TYPE), new Long(identify), new Long(outId),tips);
		}
		else if( "gold".equalsIgnoreCase(key) ) {
//			stat.updateByPair("gold", stat.gold + _.toInt(val));
//			ScoreList.insert(userId,_.toInt(val),ScoreList.GOLD_TYPE,identify,outId,tips);
			userStatService.updateByPair("gold", stat.getGold()+ _.toInt(val), (int)userId);
			scorelistService.insert((int)userId, _.toLong(val), new Long(Scorelist.GOLD_TYPE), new Long(identify), new Long(outId), tips);
		}
		else{
//			stat.updateByPair(key,val);
			userStatService.updateByPair(key,val, (int)userId);
		}

//		return buildRetJson(0,"",userService.getById(userId));
		return buildJson(0,"",userService.getById(userId));
	}

	@RequestMapping("/user/getScoreByIdentify")
	@ResponseBody
	public Object getScoreByIdentify(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);

		final long type = jsonNode.findValue("type").asLong();
		final long identify = jsonNode.findValue("identify").asLong();
		final long outId = jsonNode.findValue("outId").asLong();
		final long userId = jsonNode.findValue("userId").asLong();

//		ScoreList scoreList = ScoreList.getByIdentify(userId, type,identify,outId);
		Scorelist scoreList =scorelistService.getByIdentify(userId, type, identify, outId);
		if( scoreList == null ){
			return buildJson(0,"");
		}
		return buildJson(0,"",scoreList);
	}

	@RequestMapping("/user/grant")
	@ResponseBody
	public Object grantUser(HttpServletRequest request) throws IOException, SQLException {

		final String mobilePhone = request.getParameter("mobilePhone");
		final String password = request.getParameter("password");

//		User user = User.grant(mobilePhone,password);
		User user = userService.grant(mobilePhone, password);
		if( user != null ){
			JsonObject result = new JsonObject();
			result.addProperty("code",0);
			result.addProperty("msg","");
			result.addProperty("token",user.getToken());
			return result.toString();
		}
		return buildJson(-1,"用户名或者密码错误~");
	}

	@RequestMapping("/user/scoreList")
	@ResponseBody
	public Object getScoreList(HttpServletRequest request) throws IOException, SQLException {
		final String rawData = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(rawData);
		final long userId = jsonNode.findValue("userId").asLong();
		final long type = jsonNode.findValue("type").asLong();
//		List<ScoreList> scoreLists = ScoreList.getByUserIdAndType(userId,type);
		List<Scorelist> scoreLists =scorelistService.getByUserIdAndType(userId, type);
		return buildJsonAddFoo(0, "", scoreLists);
//		return buildJson(0,"",scoreLists);
	}

	@RequestMapping("/user/validate")
	@ResponseBody
	public Object validateUser(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);

		final String mobilePhone = jsonNode.findValue("mobilePhone")!=null ?jsonNode.findValue("mobilePhone").asText():"";
		final String password = jsonNode.findValue("password")!=null ?jsonNode.findValue("password").asText():"";
		final String device = jsonNode.findValue("deviceType")!=null ? jsonNode.findValue("deviceType").asText():"";
//		final String device = request.getHeader("deviceType");

//		User user = User.validate(mobilePhone,password);
		User user = userService.validate(mobilePhone, password);
		if( user != null ){
//			return buildRetJson(0,"",user);
//			JsonObject result = new JsonObject();
//			result.addProperty("code",0);
//			result.addProperty("msg","");
//			UserStat us = user.getUserStat() ;
			UserStat us =userStatService.getByUserId(new Long(user.getId())); 
//			JsonObject json1 = user.toJson() ;
//			JsonObject json1 =userService.toJson(user);
//			if (isAndroid(device)) {  // android
//				if( user.getCollegeid()== 9 )
//					json1.addProperty("isGift", us.getIsgift());
//			}
//			result.add("data",json1);
//			return result.toString();
			
			Map<String,Object> map=userService.toMap(user);
			if (isAndroid(device)) {  // android
				if( user.getCollegeid()== 9 )
					map.put("isGift", us.getIsgift());
			}
			return buildJson(0,"",map);
			
			
		}
		return buildJson(-1,"用户名或者密码错误~");
	}

	@RequestMapping("/user/del")
	@ResponseBody
	public String delUser(HttpServletRequest request){
		return "";
	}
 
	@RequestMapping("/user/getUsers")
	@ResponseBody
	public Object getUsers(HttpServletRequest request,Integer pageSize,Integer currentPage) throws IOException,SQLException{
		if (null==pageSize||pageSize<=0) {
			pageSize=200;
		}
		if (null==currentPage||currentPage<=0) {
			System.out.println(currentPage);
//			final int count = User.count("");
			final int count = userService.count("");
			int totalPage =  count%pageSize==0 ? count/pageSize: count/pageSize+1;
			JsonObject json = new JsonObject() ;
			json.addProperty("code", 0);
			json.addProperty("msg","");
			json.addProperty("totalPage", totalPage);
			return json.toString();	
		}
		
//		List<User> users = User.getUsers(pageSize, currentPage) ;
		List<User> users = userService.getUsers(pageSize, currentPage);
		if(!isEmpty(users)  ){
//			return buildRetJson(0,"",users);
			return buildJsonAddFoo(0,"",users);
		}
		return buildErrJson("查询用户错误");
	}
	
	@RequestMapping("/user/getUserGold")
	@ResponseBody
	public Object getUserOrderGold(HttpServletRequest request,final int retUserNum)throws SQLException{
		List<UserGold> us = userService.selectOrderByGold(retUserNum) ;
//		List<Long> uids = CollUtil.mapNotNull(us, new Function<UserStat, Long>() {
//
//			@Override
//			public Long apply(UserStat input) {
//				return input.userId;
//			}
//		});
		
		if (!isEmpty(us)) {
			return toPropertyJson(us) ;
		}
		return buildErrJson("查询用户错误");
	}
	
	/**
	 * 通过OpenId查询用户
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/user/getExtraUserByOpenId")
	@ResponseBody
	public Object getExtraUserByOpenId(HttpServletRequest request)throws SQLException{
		String openId=request.getParameter("openId");
		log.info("openId: {}"+openId);
		System.out.println("syso  openId: "+openId);
		if(StringUtils.isEmpty(openId)){
			return buildJson(-1,"openId为空");
		}
		ExtraUser user=userService.getExtraUserByOpenId(openId);
		System.out.println("syso  getExtraUserByOpenId user: "+user);
//		log.info("getExtraUserByOpenId user.getId(): {}"+user.getId());
		if(user==null){
			return buildJson(-1,"根据openId未查找到数据");
		}else{
			return buildJson(0,"",_.asMap("userInfo",user));
		}
	}
	
	/**
	 * 通过UserId查询用户
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/user/getExtraUserByUserId")
	@ResponseBody
	public Object getExtraUserByUserId(HttpServletRequest request)throws SQLException{
		String id=request.getParameter("userId");
		log.info("userId: {}"+id);
		if(StringUtils.isEmpty(id)){
			return buildJson(-1,"userId为空");
		}
		int userId=Integer.parseInt(id);
		ExtraUser user=userService.getExtraUserByUserId(userId);
		log.info("getExtraUserByUserId user.getId(): {}"+user);
		if(user==null){
			return buildJson(-1,"根据userId未查找到数据");
		}else{
			return buildJson(0,"",_.asMap("userInfo",user));
		}
	}
	
	/**
	 * 通过手机号和openId查询用户，查不到，新建
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/user/getExtraUserByMobilePhone")
	@ResponseBody
	public Object getExtraUserByMobilePhone(HttpServletRequest request)throws Exception{
		String openId=request.getParameter("openId");
		String mobilePhone=request.getParameter("mobilePhone");
		String type=request.getParameter("type");
		log.debug("type :{}"+type);
		int source=0;
		if(StringUtils.isEmpty(type)){
			source=Constant.USER_SOURCE_WX;
		}else{
			source=Constant.USER_SOURCE_APP;
		}
		log.debug("mobilePhone: "+mobilePhone);
		log.debug("openId: "+openId);
		if(StringUtils.isEmpty(mobilePhone)||StringUtils.isEmpty(openId)){
			return buildJson(-1,"mobilePhone或者openId为空");
		}
		
		User user=userService.getByPhone(mobilePhone);
		System.out.println("userService.getByPhone user.getId(): {}"+user);
		if(user==null){//根据手机号未查找到用户,说明user表里无数据
			WxBindUser wx=wxBindUserService.getByOpenId(openId);
			System.out.println("=wxBindUserService.getByOpenId: {}"+wx);
			if(wx==null){//根据openId也未查询到数据，那么先插入wx_bind_user,后插入user表，最后更新wx_bind_user表的userId和bind字段
				//插入wx_bind_user表
				System.out.println("插入wx_bind_user表");
				long re=wxBindUserService.newRecord(openId, "", 0, "",0,0);
				System.out.println("re "+re);
				if(re>0){//插入用户表user
					String randomPwd = Md5Util.md5AsLowerHex(String.valueOf(System.currentTimeMillis()));
					User record=new User();
					record.setMobilephone(mobilePhone);
					record.setPassword(randomPwd);
					record.setCollegeid(0);
					record.setPhonevalidate(new Integer(1).byteValue());
					record.setToken("");
					record.setIspre(new Integer(1).byteValue());//预生成用户标记位
					//通过app注册(不区分麦客和商城)，updatePwdFlag设置为2，通过微信注册，设置为0，微信注册后，再走app注册，改为1
					record.setUpdatePwdFlag(new Integer(0).byteValue());//微信途径预生成用户
					String uid="";
					String mac="";
					String uuid="";
					long userId=userService.insert(record, uid, mac, uuid);
					if(userId>0){
						//插入用户来源表
						UserSource userSource=new UserSource();
						userSource.setUserid(new Long(userId).intValue());
						userSource.setMobilephone(mobilePhone);
						userSource.setSourcecode(new Integer(source).byteValue());
						userSourceService.insertUserSource(userSource);
						
						WxBindUser wxUser=wxBindUserService.getByOpenId(openId);
						if( wxUser != null ) {
							//头像是空的，所以此处不更新userStat表的头像
//							userStatService.updateIcon(trimToEmpty(wxUser.getHeadimgurl()), userId);
//							int source = 999;//1,3是微信用户
//							userService.updateSource(source, (int)userId);
						}
						int id=wxUser.getId();
						wxBindUserService.updateUserId(userId, "", new Long(id));
						return buildJson(0,"",_.asMap("userId",userId,"isNew",1));
					}else{//插入用户表失败
						return buildJson(-1,"插入用户表失败","");
					}
				}else{//插入绑定表失败
					return buildJson(-1,"插入绑定表失败","");
				}
			}else{//绑定表已存在数据
				int userIdByOpenId=wx.getUserid();
				if(userIdByOpenId==0){
					//插入用户表user
					String randomPwd = Md5Util.md5AsLowerHex(String.valueOf(System.currentTimeMillis()));
					User record=new User();
					record.setMobilephone(mobilePhone);
					record.setPassword(randomPwd);
					record.setCollegeid(0);
					record.setPhonevalidate(new Integer(1).byteValue());
					record.setIspre(new Integer(1).byteValue());//预生成用户标记位
					//通过app注册(不区分麦客和商城)，updatePwdFlag设置为2，通过微信注册，设置为0，微信注册后，再走app注册，改为1
					record.setUpdatePwdFlag(new Integer(0).byteValue());//微信途径预生成用户
					record.setToken("");
					String uid="";
					String mac="";
					String uuid="";
					long userId=userService.insert(record, uid, mac, uuid);
					if(userId>0){
						//插入用户来源表
						UserSource userSource=new UserSource();
						userSource.setUserid(new Long(userId).intValue());
						userSource.setMobilephone(mobilePhone);
						userSource.setSourcecode(new Integer(source).byteValue());
						userSourceService.insertUserSource(userSource);
						
						WxBindUser wxUser=wxBindUserService.getByOpenId(openId);
						if( wxUser != null ) {
							userStatService.updateIcon(trimToEmpty(wxUser.getHeadimgurl()), userId);
//							int source = 999;//1,3是微信用户
//							userService.updateSource(source, (int)userId);
						}
						int id=wxUser.getId();
						wxBindUserService.updateUserId(userId, "", new Long(id));
						return buildJson(0,"",_.asMap("userId",userId,"isNew",1));
					}else{//插入用户表失败
						return buildJson(-1,"插入用户表失败","");
					}
				}else{
					return buildJson(0,"",_.asMap("userId",userIdByOpenId,"isNew",0));
				}
			}
		}else{//已注册，需要判断是否是麦客注册
			return buildJson(0,"",_.asMap("userId",user.getId(),"isNew",0));
		}
		
	}
	
	/**
	 * 通过手机号查询用户，查不到，新建
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/user/checkUserIdByMobilePhone")
	@ResponseBody
	public Object checkUserIdByMobilePhone(HttpServletRequest request)throws Exception{
		String type=request.getParameter("type");
		log.debug("type :{}"+type);
		int source=0;
		if(StringUtils.isEmpty(type)){
			source=Constant.USER_SOURCE_WX;
		}else{
			source=Constant.USER_SOURCE_APP;
		}
		String mobilePhone=request.getParameter("mobilePhone");
		System.out.println("mobilePhone: "+mobilePhone);
		if(StringUtils.isEmpty(mobilePhone)){
			return buildJson(-1,"checkUserIdByMobilePhone mobilePhone为空");
		}
		
		User user=userService.getByPhone(mobilePhone);
		System.out.println("userService.getByPhone user.getId(): {}"+user);
		if(user==null){ //插入用户表user
			
			String randomPwd = Md5Util.md5AsLowerHex(String.valueOf(System.currentTimeMillis()));
			User record=new User();
			record.setMobilephone(mobilePhone);
			record.setPassword(randomPwd);
			record.setCollegeid(0);
			record.setPhonevalidate(new Integer(1).byteValue());
			record.setToken("");
			record.setIspre(new Integer(1).byteValue());//预生成用户标记位
			//通过app注册(不区分麦客和商城)，updatePwdFlag设置为2，通过微信注册，设置为0，微信注册后，再走app注册，改为1
			record.setUpdatePwdFlag(new Integer(2).byteValue());//app途径预生成用户
			String uid="";
			String mac="";
			String uuid="";
			long userId=userService.insert(record, uid, mac, uuid);
			if(userId>0){
				//插入用户来源表
				UserSource userSource=new UserSource();
				userSource.setUserid(new Long(userId).intValue());
				userSource.setMobilephone(mobilePhone);
				userSource.setSourcecode(new Integer(source).byteValue());
				userSourceService.insertUserSource(userSource);
				
				return buildJson(0,"",_.asMap("userId",userId,"isNew",1));
			}else{//插入用户表失败
				return buildJson(-1,"插入用户表失败","");
			}
		}else{//已注册，需要判断是否是麦客注册
			return buildJson(0,"",_.asMap("userId",user.getId(),"isNew",0));
		}
		
	}
	
	
	
	
	/**
	 * 根据多个userId,查询用户
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/user/getUserByMutiUserId")
	@ResponseBody
	public Object getPhoneByUserId(HttpServletRequest request)throws SQLException{
		String userIds=request.getParameter("userIds");
		log.info("userIds: {}"+userIds);
		if(StringUtils.isEmpty(userIds)){
			return buildJson(-1,"传入的用户id为空");
		}
		List<ExtraUser> list=new ArrayList<ExtraUser> ();
		String []ids=userIds.split(",");
		for(int i=0;i<ids.length;i++){
			int userId=Integer.parseInt(ids[i]);
			ExtraUser user=userService.getExtraUserByUserId(userId);
			log.info("getExtraUserByUserId user.getId(): {}"+user);
			if(user!=null){
				list.add(user);
			}
		}
		//return gson.toJson(_.asMap("code", 0, "msg", "", "data", list));
		 return buildJsonAddFoo(0, "", list);
	}
	
	
	/**
	 * 根据多个手机号查询用户
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/user/getUsersByMutiPhone")
	@ResponseBody
	public Object getUsersByMutiPhone(HttpServletRequest request)throws SQLException{
		String phones=request.getParameter("phones");
		log.info("phones: {}"+phones);
		if(StringUtils.isEmpty(phones)){
			return buildJson(-1,"传入的手机号为空");
		}
		List<ExtraUser> list=new ArrayList<ExtraUser> ();
		String []phone=phones.split(",");
		for(int i=0;i<phone.length;i++){
			ExtraUser user=userService.getExtraUserByMobilePhone(phone[i]);
			log.info("getExtraUserByMobilePhone user.getId(): {}"+user);
			if(user!=null){
				list.add(user);
			}
		}
		//return gson.toJson(_.asMap("code", 0, "msg", "", "data", list));
		return buildJsonAddFoo(0, "", list);
	}
	
	/**
	 * 根据多个区域ID查询用户
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/user/getUserByMutiAreaId")
	@ResponseBody
	public Object getUserByMutiAreaId(HttpServletRequest request)throws SQLException{
		String areaIds=request.getParameter("areaIds");
		log.info("areaIds: {}"+areaIds);
		if(StringUtils.isEmpty(areaIds)){
			return buildJson(-1,"传入的区域为空");
		}
		List<ExtraUser> list=new ArrayList<ExtraUser> ();
		String []areaId=areaIds.split(",");
		for(int i=0;i<areaId.length;i++){
			List<ExtraUser> users=userService.getExtraUserByAreaId(Integer.parseInt(areaId[i]));
			int len=users.size();
			if(len>0){
				for(int j=0;j<len;j++){
					ExtraUser user=users.get(j);
					log.info("getExtraUserByMobilePhone user: {}"+user);
					if(user!=null){
						list.add(user);
					}
				}
			}
		}
		//return gson.toJson(_.asMap("code", 0, "msg", "", "data", list));
		 return buildJsonAddFoo(0, "", list);
	}
	
	
	
	/**
	 * 验证多个手机号，返回库里不存在的
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/user/validateMutiPhone")
	@ResponseBody
	public Object validateMutiPhone(HttpServletRequest request)throws SQLException{
		String phones=request.getParameter("phones");
		log.info("phones: {}"+phones);
		if(StringUtils.isEmpty(phones)){
			return buildJson(-1,"传入的手机号为空");
		}
		List<String> list=new ArrayList<String> ();
		String []phone=phones.split(",");
		try{
			for(int i=0;i<phone.length;i++){
				ExtraUser user=userService.getExtraUserByMobilePhone(phone[i]);
				log.info("getExtraUserByMobilePhone user.getId(): {}"+user);
				if(user==null){
					list.add(phone[i]);	
				}
			}
//			 return gson.toJson(_.asMap("code", 0, "msg", "", "data", list));
			return  buildJsonAddFoo(0, "", list);
		}catch(Exception e){
			log.info("Exception: {}"+e);
			return buildJson(-1,"发生错误");
		}
	}
	
	
	/**为红包开发，已弃用，故此处不修改userSource表的手机号
	 * 修改绑定手机
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@Deprecated
	@RequestMapping("/user/updateBindPhone")
	@ResponseBody
	public Object updateBindPhone(HttpServletRequest request)throws SQLException{
		String openId=request.getParameter("openId");
		String mobilePhone=request.getParameter("mobilePhone");
		if(StringUtils.isEmpty(openId)||StringUtils.isEmpty(mobilePhone)){
			return buildJson(-1,"手机号或openId为空");
		}
		Map<Object,Object> map=userService.updateBindPhone( openId,mobilePhone);
		return buildJson((Integer)map.get("code"),(String)map.get("desc"));
	}
	
	/**
	 * 根据微信的openid获得用户信息
	 * 目前系统中，openid和用户id应该是一一对应的关系
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/user/getUserByOpenId")
	@ResponseBody
	public Object getUserByOpenId(HttpServletRequest request) throws SQLException, IOException {
		String openId=request.getParameter("openId");
		if(isEmpty(openId)){
			return buildJson(-1, "openId不能为空");
		}
		User user=userService.getUserByOpenId(openId);
		if(user==null){
			return buildJson(-1,"根据openId未查找到数据");
		}else{
			return buildJson(0,"",_.asMap("userInfo",user));
		}
	}
	
	/**
	 * 根据微信的openid获得用户信息，排除红包预生成用户
	 * 目前系统中，openid和用户id应该是一一对应的关系
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/user/getUserByOpenIdExceptPre")
	@ResponseBody
	public Object getUserByOpenIdExceptPre(HttpServletRequest request) throws SQLException, IOException {
		String openId=request.getParameter("openId");
		if(isEmpty(openId)){
			return buildJson(-1, "openId不能为空");
		}
		ExtraUser user=userService.getUserByOpenIdExceptPre(openId);
		if(user==null){
			return buildJson(-1,"根据openId未查找到数据");
		}else{
			return buildJson(0,"",_.asMap("userInfo",user));
		}
	}
	
	
	
	
	
	@RequestMapping("/user/getNewestDeviceByUserId")
	@ResponseBody
	public Object getByUserId(HttpServletRequest request) throws IOException, SQLException {
		String id=request.getParameter("userId");
		System.out.println("userId  "+id);
		if(StringUtils.isEmpty(id)){
			return buildJson(-1, "userId为空", "");
		}
//		JsonNode jsonNode = JsonUtil.parse(data);
//		final long userId = jsonNode.findValue("userId").asLong();
		final long userId = Long.parseLong(id);
		if(userId <=0){
			return buildJson(-1, "userId为负", "");
		}
		List<Object> list=new ArrayList<Object>();
		
		List<Device> tmp=deviceService.getNewByUserId(userId);
		if(tmp.size()>0&&!tmp.isEmpty()){
			Device device=tmp.get(0);//sql代码只返回一条记录，不改变返回值是为保证之前的调用方法正确
			list.add(device);
			if(device.getPlatform().equalsIgnoreCase("android")){
				Midevice midevice=miDeviceService.getNewByUserId(userId);
				if(midevice!=null){
					list.add(midevice);
				}
			}
		}else{
			Midevice midevice=miDeviceService.getNewByUserId(userId);
			if(midevice!=null){
				list.add(midevice);
			}
		}
		System.out.println("list.size() "+list.size());
		return buildJson(0, "", list);
	}
	
	
	/**
	 * 废弃此方法，getNewestDeviceByUserId中只根据device表中的最新一条数据进行判断客户端的版本
	 * 
	 * 功能：最后结果按时间倒序,可能会有Android和ios版本2种版本的device信息
	 */
	@Deprecated
	private List<Object> sort(List<Object> list){
		
		List<Object> res=new ArrayList<Object>();
		Object[] reso=new Object [3];
		
		if(list.size()==0){
			return null;	
		}else{
			if(list.size()==3){
				Object o1=list.get(0);
				Object o2=list.get(1);
				Object o3=list.get(2);
				Date Date1=null;
				Date Date2=null;
				Date Date3=null;
				if(o1 instanceof Device){
					 Date1= ((Device) o1).getUpdatetime();
				}else{
					 Date1= ((Midevice) o1).getUpdatetime();
				}
				
				if(o2 instanceof Device){
					 Date2= ((Device) o2).getUpdatetime();
				}else{
					 Date2= ((Midevice)o2).getUpdatetime();
				}
				
				if(o3 instanceof Device){
					 Date3= ((Device) o3).getUpdatetime();
				}else{
					 Date3= ((Midevice)o3).getUpdatetime();
				}
				Date [] resDate=new Date[3];
				
				if(Date1.after(Date2)){
					if(Date2.after(Date3)){//形成1,2,3按时间倒序
						resDate[0]=Date1;
						resDate[1]=Date2;
						resDate[2]=Date3;
						reso[0]=o1;
						reso[1]=o2;
						reso[3]=o3;
					}else{//1比2晚，3比2晚，比较1和3
						if(Date1.after(Date3)){//1,3,2
							reso[0]=o1;
							reso[1]=o3;
							reso[2]=o2;
						}else{//3,1,2
							reso[0]=o3;
							reso[1]=o1;
							reso[2]=o2;
						}
					}
				}else{//2比1晚
					if(Date3.after(Date2)){//3,2,1
						reso[0]=o3;
						reso[1]=o2;
						reso[2]=o1;	
					}else{//2也比3晚，1,3比较
						if(Date1.after(Date3)){//2,1,3
							reso[0]=o2;
							reso[1]=o1;	
							reso[3]=o3;
						}else{//2,3,1
							reso[0]=o2;
							reso[1]=o3;	
							reso[3]=o1;
						}
					}
				}
			}else if(list.size()==2){//正常情况，2条全部是Android
				/*if(isIos){//非正常情况
					Object o1=list.get(0);
					Object o2=list.get(1);
					Date Date1=null;
					Date Date2=null;
					if(o1 instanceof Device){
						 Date1= ((Device) o1).getUpdatetime();
					}else{
						 Date1= ((Midevice) o1).getUpdatetime();
					}
					
					if(o2 instanceof Device){
						 Date2= ((Device) o2).getUpdatetime();
					}else{
						 Date2= ((Midevice)o2).getUpdatetime();
					}
					if(Date1.after(Date2)){
						res.add(o1);
					}else{
						res.add(o2);
					}
				}*/
//				else{//2条全部是Android
					res.addAll(list);
					reso[0]=list.get(0);
					reso[1]=list.get(1);	
//				}
			}else{//一条数据
//				res.addAll(list);
				reso[0]=list.get(0);
			}
			if(reso.length==1){
				res.add(reso[0]) ;
			}else{
				res.add(reso[0]) ;
				res.add(reso[1]) ;
			}
		  return res;
		}
		
	}
	
	
	
	private JsonNode reqToJsonNode(HttpServletRequest request) throws IOException{
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);
		return jsonNode ;
	}
	
	private Object toPropertyJson(List<UserGold> users) throws SQLException{
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("code",0);
		jsonObject.addProperty("msg","");
		JsonArray array = new JsonArray();
		for (UserGold u : users) {
			JsonObject j = new JsonObject() ;
			j.addProperty("gold", u.getGold());
			j.addProperty("userId", u.getUserId());
			j.addProperty("mobilePhone", u.getMobilePhone());
			j.addProperty("realName", u.getRealName());
			array.add(j);
		}
		jsonObject.add("data",array);
		return jsonObject.toString();
	}
	
	/*
	 * 根据openId获取unionId
	 */
	private String getUnionID(String url, String openId) {
		String unionId="";
		if (StringUtils.isEmpty(url) || StringUtils.isEmpty(openId)) {
			return "";
		}
		url=url+"?openId="+openId;
		try {
			System.out.println(url);
			Crawler crawler = Crawler.of("uc.getUnionIDFromWx",3000,5000);
			Pair<Integer, String> result = crawler.get(url);

			System.out.println(result);
			System.out.println(result.getRight());
			System.out.println(result.getLeft());
			
			if (result.getLeft() / 100 == 2) {
				try {
					JsonNode jsonNode = JsonUtil.parse(result.getRight());
					if(jsonNode.findValue("code").asInt() == 200){
						unionId=jsonNode.findValue("data").asText();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}

		return unionId; 
	}
	
	
}
