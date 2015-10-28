package com.imxiaomai.web;

import static com.imxiaomai.base._.isEmpty;
import static com.imxiaomai.base._.randInt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imxiaomai.base._;
import com.imxiaomai.base.digt.Md5Util;
import com.imxiaomai.constants.Constant;
import com.imxiaomai.entity.NewUser;
import com.imxiaomai.persistence.domain.College;
import com.imxiaomai.persistence.domain.SmsRecords;
import com.imxiaomai.persistence.domain.User;
import com.imxiaomai.persistence.domain.UserSource;
import com.imxiaomai.persistence.domain.WxBindUser;
import com.imxiaomai.service.CollegeService;
import com.imxiaomai.service.SmsRecordsService;
import com.imxiaomai.service.UserService;
import com.imxiaomai.service.UserSourceService;
import com.imxiaomai.service.WxBindUserService;
import com.imxiaomai.util.SMSUtil;
import com.imxiaomai.util.UrlUtils;
import com.imxiaomai.web.base.BaseController;

@Controller
public class UserTempAction extends BaseController {
	@Autowired WxBindUserService wxBindUserService;
	@Autowired UserService userService;
	@Autowired UserSourceService userSourceService;
	@Autowired CollegeService collegeService;
	@Autowired SmsRecordsService smsRecordsService;
	private static final Logger log = LoggerFactory.getLogger(UserTempAction.class);

	@RequestMapping("/user/getRandomId")
	@ResponseBody
	public Object getRandomId(HttpServletRequest request) throws SQLException, IOException {

		String productId = request.getParameter("productId");
		if (isEmpty(productId)) {
			return buildJson(-1, "参数错误");
		}
		String randomString = getFixLenthString(20);
		// uuid
		String salt = NewUser.common_string;
		String result = salt + productId + randomString;

		String randomId =NewUser.encrypt(result);
		//可能有特殊字符，需要做编码
		String id=UrlUtils.encode(randomId);
		log.info("getRandomId encode id "+id);
		return buildJson(0, "成功", _.asMap("randomId", id));
	}

	@RequestMapping("/user/getToken")  //修改
	@ResponseBody
	public Object getToken(HttpServletRequest request) throws Exception {

		String productId = request.getParameter("productId");
		//randomId可能有特殊字符，从开始返回客户端时就进行了编码，后续操作中，只有校验时解码，其他时候不解码，包括返回客户端和存储数据库
		String randomId = request.getParameter("randomId");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String collegeId=request.getParameter("collegeId");
		
		log.info("productId :{},randomId:{},phone:{},password:{},collegeId:{}",productId,randomId,phone,password,collegeId);
		
		if (isEmpty(randomId) || isEmpty(phone) || isEmpty(password) || isEmpty(productId)||isEmpty(collegeId)) {
			return buildJson(-1, "参数错误");
		}
		if (!phone.startsWith("1") || phone.length() != 11) {
			return buildJson(-1, "手机号码错误");
		}

		boolean isTrue=NewUser.decodeAndvalidateRandomId(randomId);
		if (!isTrue) {
			return buildJson(-1, "校验错误");
		}
		User newuser =userService.getByPhone(phone);
//		User newuser = User.getByPhone(phone);
		if (newuser == null) {
			return buildJson(-1, "该手机号尚未注册，请您先注册");
		}
		if (!newuser.getPassword().equals(Md5Util.md5AsLowerHex(password))) {
			return buildJson(-1, "用户密码错误");
		}
		//更新collegeId
//		newuser.updateByPair("collegeId",Integer.parseInt(collegeId));
		userService.updateByPair("collegeId",Integer.parseInt(collegeId), "id", newuser.getId());
		String srcStr = phone + productId + randomId +password+NewUser.common_string;
		String randomToken = "";
		String token =NewUser.encrypt(srcStr);	
		randomToken=UrlUtils.encode(token);
		log.info("token:  "+randomToken);
//		newuser.productId = productId;
//		newuser.randomToken = randomToken;
//		newuser.randomId = randomId;
//		newuser.tokenCreateTime=System.currentTimeMillis();
//		newuser.updateRandomToken();
		userService.updateRandomToken(randomId, productId, randomToken, phone);
		
		// 根据新的collegeId获取学校名字
//		CollegeInfo college = CollegeInfo.getById(Integer.parseInt(collegeId));
		College college=collegeService.getById(Long.parseLong(collegeId));
		if(college==null){
			college=new College ();
		}
		String userName="";
		if(!StringUtils.isEmpty(newuser.getUsername())){
			userName=newuser.getUsername();
		}
		Map<String, Object> userjsonString=_.asMap("userId", newuser.getId(), "userName", userName, "phone", newuser.getMobilephone(), "collegeId", newuser.getCollegeid(), "createTime", newuser.getCreatetime(), "collegeName", college.getName());
//		String jsonString=JsonUtil.format(_.asMap("token", randomToken, "userInfo",userjsonString));
		return buildJson(0, "成功", _.asMap("token", randomToken, "userInfo",userjsonString));
	}
	
	@RequestMapping("/user/checkToken")
	@ResponseBody
	public Object checkToken(HttpServletRequest request) throws SQLException, IOException {
		log.info("check ");
		
		String data ="";
		try{
			data = getDataFromRequest(request);
			System.out.println("data "+data);
			log.info("data "+data);
		}catch(Exception e){
			System.out.println("Exception \t "+e);
			log.info("Exception \t "+e);
		}
		
		
		String args[][]=new String[4][2];
		args[0][0]="randomId";
		args[1][0]="userId";
		args[2][0]="productId"; 
		args[3][0]="token";
		String[] datas=data.split("&");//参数中的&，=已经进行了转码
		for(int i=0;i<datas.length;i++){
			String tmp=datas[i];
//			System.out.println(tmp);
			String temp[]=tmp.split("=");
			for(int j=0;j<args.length;j++){
				if(temp[0].equalsIgnoreCase(args[j][0])){
					args[j][1]=temp[1];
					break;
				}
			}
			
		}
		
		 String randomId = args[0][1];
		 String userId = args[1][1];
	     String productId =args[2][1];
	     String token = args[3][1];
	     
		log.info("randomId "+randomId);
		log.info("userId "+userId);
		log.info("productId "+productId);
		log.info("token "+token);
		
		if (!NewUser.decodeAndvalidate(token, randomId)) {
			log.info("校验失败 token:{},randomId:{}\t", token,randomId);
			return buildJson(-1, "校验失败");
		}
		log.info("token:"+token+",randomId:"+randomId);
		
/*        User user =userService.getById(Long.parseLong(userId));
        System.out.println("user "+user );
        if(user ==null){
        	return false;
        }else{//通过比较token来判断密码是否修改
	    	String encode_token=user.getRandomToken();//编码后的token
	    	if(!token.equals(encode_token)){//传入的token和数据库中的token不一致，返回false，
	    		return false;
	    	}
        }*/
		
		User newuser =userService.getById(Long.parseLong(userId));
		log.info("newuser:"+newuser);
		
    	if (newuser == null) {
			log.info("userId:{} 用户不存在",userId);
			return buildJson(-1, "该用户不存在");
		}
		log.info("productId:"+productId);
		if (isEmpty(productId)) {
			log.info("productId:{} 为空",productId);
			return buildJson(-1, "参数错误");
		}
		log.info("newuser.userName:"+newuser.getUsername());
		String userName="";
		if(!StringUtils.isEmpty(newuser.getUsername())){
			userName=newuser.getUsername();
		}
		log.info("userName:"+userName);
		return buildJson(0, "成功", _.asMap("token", token, "userId", newuser.getId(), "userName", userName, "phone", newuser.getMobilephone(), "collegeId", newuser.getCollegeid(), "createTime", newuser.getCreatetime()));

	}

	
	@RequestMapping("/user/register")
	@ResponseBody
	public Object register(HttpServletRequest request) throws Exception {

		String productId = request.getParameter("productId");
		String collegeId = request.getParameter("collegeId");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String smscode = request.getParameter("smscode");
		//这3个参数是app防止刷单传入的参数
		String uid =request.getParameter("uid"); //手机IMEI串号
		String mac = request.getParameter("mac");//手机mac地址
		String uuid =request.getParameter("uuid"); //随机数
		//注册前再验证一次，防止刷库
//		SmsRecords records = SmsRecords.getNewsByTelPhone(phone, "registerorreset");
		SmsRecords records =smsRecordsService.getNewsByTelPhone(phone, "registerorreset");
		if (records == null|| !smscode.equalsIgnoreCase(records.getSmscode())) {
			return buildJson(-1, "校验失败，请检查验证码是否正确或者重试");
		}
		
		//可能会为空，改为空字符串
		if(StringUtils.isEmpty(uid)){
			uid="";
		}
		if(StringUtils.isEmpty(mac)){
			mac="";
		}
		if(StringUtils.isEmpty(uuid)){
			uuid="";
		}
		

		if (isEmpty(phone) || !phone.startsWith("1") || phone.length() != 11) {
			return buildJson(-1, "手机号码错误");
		}

		if (isEmpty(password) || isEmpty(collegeId) || isEmpty(productId)) {
			return buildJson(-1, "参数错误");
		}
		
		String trim_password=password.trim();
		boolean isValid=EmojiFilter.passwordFilter(trim_password);
		if(!isValid){
			return buildJson(-1, "密码设置错误，不符合规范");
		}
		//前置判断在sendCode方法中进行，此处如果user表已经有手机号，说明是1.微信绑定用户或者是2.红包的预生成用户，或者是3.麦客APP用户，
		//那么修改user表对应记录的密码
//		User newUser = User.getByPhone(phone);
		User newUser = userService.getByPhone(phone);
		if (newUser!=null) {
			if(newUser.getUpdatePwdFlag()!=null&&newUser.getUpdatePwdFlag().intValue()==0){
				//修改标记位，说明原微信用户已经通过注册流程修改了密码,即进行了app的注册
				userService.updatePasswordAndFlag(password, newUser.getId(),1);
				//插入用户来源表
				UserSource userSource=new UserSource();
				userSource.setUserid(new Long(newUser.getId()).intValue());
				userSource.setMobilephone(phone);
				userSource.setSourcecode(new Integer(Constant.USER_SOURCE_APP).byteValue());
				userSourceService.insertUserSource(userSource);
				
			}else if(newUser.getIspre()!=null&&newUser.getIspre().intValue()==1){//预生成用户，修改预生成标记位为2，说明走了注册流程
				userService.updateByPair("ispre", 2, "id", newUser.getId());
				userService.updatePassword(password, newUser.getId());
				//红包预生成时已经插入了userSource表,故此处不再插入
			}else{//已注册麦客APP用户，再注册商城app，此处会修改了麦客app的密码
				userService.updatePassword(password, newUser.getId());
				//插入用户来源表
				UserSource userSource=new UserSource();
				userSource.setUserid(new Long(newUser.getId()).intValue());
				userSource.setMobilephone(phone);
				userSource.setSourcecode(new Integer(Constant.USER_SOURCE_APP).byteValue());
				userSourceService.insertUserSource(userSource);
			}
		}else{
			User record=new User();
			record.setMobilephone(phone);
			record.setPassword(password);
			record.setCollegeid(Integer.parseInt(collegeId));
			record.setPhonevalidate(new Integer(1).byteValue());
			record.setToken("");
			record.setIspre(new Integer(0).byteValue());//非红包预生成用户
			//通过app注册(不区分麦客和商城)，updatePwdFlag设置为2，通过微信注册，设置为0，微信注册后，再走app注册，改为1
			record.setUpdatePwdFlag(new Integer(2).byteValue());			
			long userId=userService.insert(record, uid, mac, uuid);
			//插入用户来源表
			UserSource userSource=new UserSource();
			userSource.setUserid(new Long(userId).intValue());
			userSource.setMobilephone(phone);
			userSource.setSourcecode(new Integer(Constant.USER_SOURCE_APP).byteValue());
			userSourceService.insertUserSource(userSource);
		}
		
		// 返回随机id
		String randomString = getFixLenthString(20);
		String salt =NewUser.common_string;
		String result = salt + productId + randomString;
		String randomId = NewUser.encrypt(result);
		//可能有特殊字符，需要做编码
		String id=UrlUtils.encode(randomId);
		log.info("register encode id "+id);
		return buildJson(0, "成功", _.asMap("randomId", id));
	}

	@RequestMapping("/sms/sendCode")
	@ResponseBody
	public Object sendSmsCode(HttpServletRequest request) throws SQLException, IOException {
		//isWx=1 说明是由微信注册触发
		String isWx=request.getParameter("isWx");//是否是由微信注册触发
		String type = request.getParameter("type");
		String phone = request.getParameter("phone");
		if (isEmpty(phone) || !phone.startsWith("1") || phone.length() != 11) {
			return buildJson(-1, "手机号码错误");
		}
		User newUser = null;
		String template = "";
		String opType = "";
		boolean flag = false;//微信用户是否绑定
		switch (type) {
		case "register":
			newUser = userService.getByPhone(phone);
			if (newUser!=null){//user表有数据,再判断是否微信用户
				//判断是否是红包预生成用户
				int ispre=newUser.getIspre();
				if(ispre!=1){//不是预注册用户（默认值是0）,等于1是预注册用户，2是预注册用户已经走了正式注册流程
					if(ispre==2){//预注册用户已经走了正式注册流程
						return buildJson(-1, "该手机号码已注册");
					}
					int updatePwdflag=new Integer(newUser.getUpdatePwdFlag());
					if(updatePwdflag==1){//说明微信绑定用户已经通过注册流程修改过密码，即已经进行过注册，返回已注册提示
						return buildJson(-1, "该手机号码已注册");
					}else{
						int userId=newUser.getId();
						//再通过userId查询绑定表，判断是否是微信用户
						WxBindUser oldUser = wxBindUserService.getByUserId(new Long(userId));
						if (oldUser!=null) {//注册了微信和app之后，重新注册app的情况，拿source表做判断
							List<UserSource> list=userSourceService.queryUserSourceByUserId(userId);
							boolean isMall=false;
							if(!list.isEmpty()&&list.size()>0){
								int len=list.size();
								for(int i=0;i<len;i++){
									if(list.get(i).getSourcecode()==Constant.USER_SOURCE_APP){
										isMall=true;
										break;
									}
								}
							}
							if(isMall){//已注册商城APP,提示已注册
								return buildJson(-1, "该手机号码已注册");
							}else{
								if(updatePwdflag==0){//等于0 说明是微信注册用户 ，尚未注册APP
									flag = true;
								}
							}
						}else{
							log.info("isWx "+isWx);//h5注册会传入此标记，app注册不会传此标记位（商城-张帅增加此标记位）
							System.out.println("isWx "+isWx);
							if(StringUtils.isEmpty(isWx)){//说明是app商城注册流程进入的
								//非微信注册用户，user表已有数据，说明是麦客注册或者商城注册，需要进行判断
								//查询userSource表，判断已有数据是否是商城APP
								List<UserSource> list=userSourceService.queryUserSourceByUserId(userId);
								boolean isMall=false;
								if(!list.isEmpty()&&list.size()>0){
									int len=list.size();
									for(int i=0;i<len;i++){
										if(list.get(i).getSourcecode()==Constant.USER_SOURCE_APP){
											isMall=true;
											break;
										}
									}
								}
								if(isMall){//已注册商城APP,提示已注册
									return buildJson(-1, "该手机号码已注册");
								}
							}
						}
					}
				}//是预注册用户，走正常流程，发送验证码并设置密码。
			}
			template = "您的验证码：{}，10分钟内有效，请尽快使用 【小麦公社】";
			opType = "registerorreset";
			break;
		case "resetpassword":
			newUser = userService.getByPhone(phone);
			if (newUser == null) {
				return buildJson(-1, "该手机号码未注册");
			}
			template = "您正在重置密码，验证码{}，10分钟内有效，请尽快使用【小麦公社】";
			opType = "registerorreset";
			break;
		default:
			return buildErrJson("参数错误");
		}

		String smscode = "";
		for (int i = 0; i < 4; i++) {
			smscode += randInt(9);
		}
		template = template.replace("{}", smscode);
		SMSUtil.sendSMSText(phone, template);
		smsRecordsService.insert(phone, smscode, opType);
		if (flag) {
			return buildJson(1, "您已在小麦特供微信版绑定，设置密码即可登陆");
		}
		return buildJson(0, "成功");
	}

	@RequestMapping("/sms/checkCode")
	@ResponseBody
	public Object checkSmsCode(HttpServletRequest request) throws SQLException, IOException {

		String smscode = request.getParameter("smscode");
		String phone = request.getParameter("phone");
		if (isEmpty(phone) || !phone.startsWith("1") || phone.length() != 11) {
			return buildJson(-1, "手机号码错误");
		}
		if (isEmpty(smscode)) {
			return buildJson(-1, "验证码不能为空");
		}

		SmsRecords records = smsRecordsService.getNewsByTelPhone(phone, "registerorreset");
		if (records == null||records.getId() == null||records.getId() == 0|| !smscode.equalsIgnoreCase(records.getSmscode())) {
			return buildJson(-1, "校验失败，请检查验证码是否正确或者重试");
		}
		Date d=records.getCreatetime();
		Date expire=DateUtils.addMinutes(d, 10);
		if(new Date().after(expire)){
			return buildJson(-1, "验证码已失效，请重新获取");
		}
		return buildJson(0, "成功");
	}

	@RequestMapping("/user/updatePwd")
	@ResponseBody
	public Object updatePwd(HttpServletRequest request) throws Exception {

		String smscode = request.getParameter("smscode");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		if (isEmpty(phone) || !phone.startsWith("1") || phone.length() != 11) {
			return buildJson(-1, "手机号码错误");
		}
		if (isEmpty(smscode) || isEmpty(password)) {
			return buildJson(-1, "验证码或密码不能为空");
		}

		User newUser = userService.getByPhone(phone);
		if (newUser == null) {
			return buildJson(-1, "该手机号码未注册");
		}
		SmsRecords records = smsRecordsService.getNewsByTelPhone(phone, "registerorreset");
		if (records == null||records.getId() == null||records.getId() == 0 || !smscode.equalsIgnoreCase(records.getSmscode())) {
			return buildJson(-1, "校验失败，请检查验证码是否正确或者重试");
		}
		String trim_password=password.trim();
		boolean isValid=EmojiFilter.passwordFilter(trim_password);
		if(!isValid){
			return buildJson(-1, "密码设置错误，不符合规范");
		}
		//更新密码
		userService.updatePassword(password, newUser.getId());
		return buildJson(0, "成功");
		//修改密码后，app会主动调用一次/user/getToken，重新生成token，故此处不用修改randomToken
	}

	@RequestMapping("/user/updateUser")
	@ResponseBody
	public Object updateUser(HttpServletRequest request) throws IOException, SQLException {
		String token = request.getParameter("token");
		String randomId = request.getParameter("randomId");
		String userId = request.getParameter("userId");
		String type = request.getParameter("type");
		String param = request.getParameter("param");

		if (!NewUser.decodeAndvalidate(token, randomId)) {
			return buildJson(-1, "校验失败");
		}
		if (isEmpty(param) || isEmpty(type)|| isEmpty(userId)) {
			return buildJson(-1, "参数错误");
		}
		switch (type) {
		case "userName":
			userService.updateByPair("userName", param, "id", Long.parseLong(userId));
			break;
		case "collegeId":
			userService.updateByPair("collegeId", param, "id", Long.parseLong(userId));
			break;
		default:
			break;
		}
		return buildJson(0, "成功");
	}

	@RequestMapping("/user/getUserInfo")
	@ResponseBody
	public Object getUserInfo(HttpServletRequest request) throws IOException, SQLException {

		String token = request.getParameter("token");
		String randomId = request.getParameter("randomId");
		String userId = request.getParameter("userId");

		if (!NewUser.decodeAndvalidate(token, randomId)) {
			return buildJson(-1, "校验失败");
		}
		User user = userService.getById(Long.parseLong(userId));
		if (user == null) {
			return buildJson(-1, "用户不存在");
		}
		// 获取学校名字
		College college = collegeService.getById(new Long(user.getCollegeid()).longValue());
		if(college==null){
			college=new College ();
		}
		String userName="";
		if(!StringUtils.isEmpty(user.getUsername())){
			userName=user.getUsername();
		}
		return buildJson(0, "成功", _.asMap("userId", user.getId(), "userName", userName, "phone", user.getMobilephone(), "collegeId", user.getCollegeid(), "createTime", user.getCreatetime(), "collegeName", college.getName()));
	}

	/**
	 * 通过微信登录app，根据unionId检查用户类型  通过openId无法实现功能
	 * 返回给app，app根据返回值跳转相应页面
	 * 检查结果 0 ：完全新用户或者APP用户，返回code，具体等下一步输入手机号再进行判断
	 * 检查结果 1 ：微信用户，设置时间戳为密码，并将此密码返回app，app后续根据密码直接登陆，用户不知道此密码
	 * 检查结果 2：既是微信又是app用户，返回用户信息，免登陆直接进入商城页面
	 * @param request
	 * @return
	 * @throws Exception 
	 * @throws IOException
	 * @throws SQLException
	 */
	@RequestMapping("/user/WxLoginCheckUser")
	@ResponseBody
	public Object WxLoginCheckUser(HttpServletRequest request) throws Exception  {
		int ret_code=-1;
		String unionId = request.getParameter("unionId");
		System.out.println("unionId "+unionId);
		WxBindUser bind=wxBindUserService.getByUnionId(unionId);
		
		
//		String openId = request.getParameter("openId");
//		System.out.println("openId "+openId);
//		WxBindUser bind=wxBindUserService.getByOpenId(openId);
//
		if(bind==null){//完全新用户，或者只是APP用户，不是微信用户
			//判断是否APP用户，需要手机号
			ret_code= 0;//返回0，即完全新用户或者APP用户，具体等输入手机号再进行判断，因APP用户，此处根本无法查询到相关数据（只能通过手机号）
		}else{
			int userId=bind.getUserid();
			if(userId==0){//只是绑定，未注册，归为完全新用户
				ret_code= 0;
			}else{
				User user=userService.getById(new Long(userId).longValue());
				if(user==null){
					return buildJson(-1, "根据用户Id未查询到用户"); 
				}else{//有userId，再查询userSource表，判断是否是app用户
					List<UserSource> list=userSourceService.queryUserSourceByUserId(userId);
					int len=list.size();
					if(len>0){
						boolean isApp=false;
						for(int i=0;i<len;i++){
							int source=list.get(i).getSourcecode().intValue();
							if(source==Constant.USER_SOURCE_APP){//是APP用户
								isApp=true;
								break;
							}
						}
						if(isApp){//既是微信又是app用户，返回用户信息，免登陆直接进商城
							ret_code=2;
							//返回用户信息
							College college=collegeService.getById(new Long(user.getCollegeid()).longValue());
							if(college==null){
								college=new College ();
							}
							Map<String, Object> userjsonString=_.asMap("userId", user.getId(), "userName", user.getUsername(), "phone", user.getMobilephone(), "collegeId", user.getCollegeid(), "createTime", user.getCreatetime(), "collegeName", college.getName());
							return buildJson(0, "成功", _.asMap("ret_code",ret_code,"randomId",user.getRandomId(),"token", user.getRandomToken(), "userInfo",userjsonString));
						}else{//微信用户
							ret_code= 1;
							//设置时间戳为密码，并将此密码返回app，app后续根据密码登陆
							String randomPwd =String.valueOf(System.currentTimeMillis());
							userService.updatePassword(randomPwd, userId);
							return buildJson(0, "成功", _.asMap("ret_code",ret_code,"phone",user.getMobilephone(),"password",randomPwd));
		
						}
					}else{
						return buildJson(-1, "根据用户Id未查询到用户来源信息"); 
					}
				}
			}
		}
		return buildJson(0, "",_.asMap("ret_code",ret_code));
	}
	
	@RequestMapping("/user/WxLoginSendCode")
	@ResponseBody
	public Object WxLoginSendCode(HttpServletRequest request) throws SQLException, IOException {
		String phone = request.getParameter("phone");
		if (isEmpty(phone) || !phone.startsWith("1") || phone.length() != 11) {
			return buildJson(-1, "手机号码错误");
		}
		String template = "您的验证码：{}，10分钟内有效，请尽快使用 ";
		String opType = "registerorreset";
		
		String smscode = "";
		for (int i = 0; i < 4; i++) {
			smscode += randInt(9);
		}
		template = template.replace("{}", smscode);
		SMSUtil.sendSMSText(phone, template);
		smsRecordsService.insert(phone, smscode, opType);
		return buildJson(0, "成功");
	}
	
	
	/**
	 * 微信登录根据手机号查询是否是app用户
	 * 返回给app，app根据返回值跳转相应页面
	 * 检查结果 0 ：新用户 ,返回标记位和手机号，进行app的注册（/user/register 方法 ）
	 * 检查结果 1：app用户,返回用户信息,免登陆进入商城
	 * @param request
	 * @return
	 */
	@RequestMapping("/user/WxLoginCheckIsAppUser")
	@ResponseBody
	public Object WxLoginCheckIsAppUser(HttpServletRequest request) {
		int ret_code=-1;
		String phone = request.getParameter("phone");
		String smscode = request.getParameter("smscode");
		SmsRecords records =smsRecordsService.getNewsByTelPhone(phone, "registerorreset");
		if (records == null|| !smscode.equalsIgnoreCase(records.getSmscode())) {
			return buildJson(-1, "校验失败，请检查验证码是否正确或者重试");
		}
		User user = userService.getByPhone(phone);
		if (user == null) {//完全新用户，返回标记位和手机号，进行app的注册（/user/register 方法 ）
			ret_code=0;
			return buildJson(0, "成功", _.asMap("ret_code",ret_code,"phone",phone));
		}else{//已注册用户，可能是app用户，也可能是麦客，还有未来其他类型的用户
			//根据userSource表判断是什么用户
			int userId=user.getId();
			System.out.println("userId "+userId);
			List<UserSource> list=userSourceService.queryUserSourceByUserId(userId);
			int len=list.size();
			System.out.println("len "+len);
			if(len>0){
				boolean isApp=false;
				for(int i=0;i<len;i++){
					int source=list.get(i).getSourcecode().intValue();
					if(source==Constant.USER_SOURCE_APP){//是APP用户
						isApp=true;
						break;
					}
				}
				if(isApp){
					ret_code= 1;//app注册用户
					//返回用户信息
					College college=collegeService.getById(new Long(user.getCollegeid()).longValue());
					if(college==null){
						college=new College ();
					}
					Map<String, Object> userjsonString=_.asMap("userId", user.getId(), "userName", user.getUsername(), "phone", user.getMobilephone(), "collegeId", user.getCollegeid(), "createTime", user.getCreatetime(), "collegeName", college.getName());
					return buildJson(0, "成功", _.asMap("ret_code",ret_code,"randomId",user.getRandomId(),"token", user.getRandomToken(), "userInfo",userjsonString));

				}else{
					ret_code=0;//新用户，返回标记位和手机号，进行app的注册（/user/register 方法 ）
					return buildJson(0, "成功", _.asMap("ret_code",ret_code,"phone",phone));
				}
			}else{
				return buildJson(-1, "根据用户Id未查询到用户来源信息"); 
			}
		}
	}
	
	/**未用
	 * 微信登录--设置密码，不需要验证码
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/user/WxLoginSetPwd")
	@ResponseBody
	@Deprecated
	public Object WxLoginSetPwd(HttpServletRequest request) throws Exception {

		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		if (isEmpty(phone) || !phone.startsWith("1") || phone.length() != 11) {
			return buildJson(-1, "手机号码错误");
		}
		if ( isEmpty(password)) {
			return buildJson(-1, "验证码或密码不能为空");
		}

		User newUser = userService.getByPhone(phone);
		if (newUser == null) {
			return buildJson(-1, "该手机号码未注册");
		}
		String trim_password=password.trim();
		boolean isValid=EmojiFilter.passwordFilter(trim_password);
		if(!isValid){
			return buildJson(-1, "密码设置错误，不符合规范");
		}
		//更新密码
		userService.updatePassword(password, newUser.getId());
		return buildJson(0, "成功");
		//修改密码后，app会主动调用一次/user/getToken，重新生成token，故此处不用修改randomToken
	}
	
	
	private static String getFixLenthString(int strLength) {
		String string = "";
		for (int i = 0; i < strLength; i++) {
			string += randInt(9);
		}
		return string;
	}
	
}
