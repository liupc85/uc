package com.imxiaomai.web;


import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imxiaomai.fw.client.codis.CommonClient;
import com.imxiaomai.fw.client.codis.pool.PoolType;
import com.imxiaomai.persistence.domain.User;
import com.imxiaomai.persistence.domain.WxBindUser;
import com.imxiaomai.service.UserService;
import com.imxiaomai.service.WxBindUserService;
import com.imxiaomai.util.ConfigUtil;
import com.imxiaomai.util.RedisUtil;
import com.imxiaomai.web.base.BaseController;

@Controller
public class CodisAction extends BaseController{
	@Autowired UserService userService;
	@Autowired WxBindUserService wxBindUserService;
	
	private final static int tryNum = ConfigUtil.getIntValue("codis.trynum");
	private static CommonClient commonClient = new CommonClient(PoolType.roundRobin,tryNum);
	private final static String codisUserPre = ConfigUtil.getStringValue("codis.dataPre")+"_user_";
	private final static String codisWxPre = ConfigUtil.getStringValue("codis.dataPre")+"_wxBind_";
	private static Map<String,Object> typeMap=new HashMap<String,Object>();
	static {
		typeMap.put("1", codisUserPre);//1是user
		typeMap.put("2", codisWxPre);//2是wx_bind_user
	}
	

	
	@RequestMapping("/codis/removeCache")
    @ResponseBody
    public Object removeCache(HttpServletRequest request)  {
		String key=request.getParameter("key");
		String type=request.getParameter("cacheType");
		String pre=(String)typeMap.get(type);
		System.out.println("pre "+pre);
		if(StringUtils.isEmpty(pre)){
			return buildJson(-1,"根据类型无法生成前缀");
		}
		System.out.println("key "+key +"-----------  type "+type);
		//根据type和key获取记录，将把mobilePhone和openId作为键的缓存也删除
		long res=0;
		if(type.equals("1")){
			res=commonClient.del((pre+key).getBytes());//删除id为键的缓存
			System.out.println("remove user ID cache "+res);
			User u=userService.getById(Long.parseLong(key));
			if(u!=null){
				key=u.getMobilephone();
				res=commonClient.del((pre+key).getBytes());//删除手机号为键的缓存
				System.out.println("remove Mobilephone cache "+res);
			}
		}else if(type.equals("2")){
			res=commonClient.del((pre+key).getBytes());//删除id为键的缓存
			System.out.println("remove wx_bind_user ID cache "+res);
			WxBindUser u=wxBindUserService.getById(Long.parseLong(key));
			if(u!=null){
				String openId=u.getOpenid();
				if(openId!=null&&StringUtils.trim(openId)!=""){
					key=openId;
					res=commonClient.del((pre+key).getBytes());//删除openid为键的缓存
					System.out.println("remove wx_bind_user openId cache "+res);
				}

				Integer userId=u.getUserid();
				if(userId!=null&&userId>=0){
					key=String.valueOf(userId);
					res=commonClient.del((pre+key).getBytes());//删除userId为键的缓存
					System.out.println("remove wx_bind_user userId cache "+res);
				}
			}
		}
		return buildJson(0,"成功");
    }
	
	
	@RequestMapping("/codis/getFromCache")
    @ResponseBody
    public Object getFromCache(HttpServletRequest request)   {
		System.out.println("request "+request );
		String key=request.getParameter("key");
		String type=request.getParameter("cacheType");
		System.out.println("key "+key +"-----------  type "+type);
		String pre=(String)typeMap.get(type);
		System.out.println("pre "+pre);
		if(StringUtils.isEmpty(pre)){
			return buildJson(-1,"根据类型无法生成前缀");
		}
		byte[] o=commonClient.get((pre+key).getBytes());
		Object object=null;
		if(o!=null){
			if(type.equals("1")){
				object = (User) RedisUtil.unserialize(o);
			}else if(type.equals("2")){
				object = (WxBindUser) RedisUtil.unserialize(o);
			}
			
			System.out.println("cache Object "+object);
			if(object==null){
				return buildJson(-1,"未查询到对应数据");
			}
		}else{
			return buildJson(-1,"未查询到对应数据");
		}

		return buildJson(0,"",object);
    }
	
	
}
