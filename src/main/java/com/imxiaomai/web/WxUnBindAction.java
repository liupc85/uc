package com.imxiaomai.web;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imxiaomai.constants.Constant;
import com.imxiaomai.manager.UserManager;
import com.imxiaomai.manager.UserSourceManager;
import com.imxiaomai.manager.WxBindUserManager;
import com.imxiaomai.persistence.domain.ExtraUser;
import com.imxiaomai.persistence.domain.User;
import com.imxiaomai.persistence.domain.UserSource;
import com.imxiaomai.web.base.BaseController;

@Controller
public class WxUnBindAction extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(WxUnBindAction.class);
	@Resource
	private UserManager userManager;
	
	@Resource
	private UserSourceManager userSourceManager ;
	
	@Resource
	private WxBindUserManager wxBindUserManager;
	
	@RequestMapping("/wxbind/unbind")
    @ResponseBody
    public Object unbind(HttpServletRequest request){
		StringBuffer sbuffer=new StringBuffer ();
		String mobilePhones=request.getParameter("mobilePhone");
		log.info("mobilePhones "+mobilePhones);
		System.out.println(mobilePhones );
		String []phone=mobilePhones.split(",");
		int len=phone.length;
		log.info("len "+len);
		if(len>0){
			for(int i=0;i<phone.length;i++){
				String temp=StringUtils.trim(phone[i]);
				ExtraUser user=	userManager.getExtraUserByMobilePhone(temp);
				if(user!=null){
					System.out.println("phone "+user.getMobilephone());
					System.out.println("userId "+user.getId());
					System.out.println("OpenId "+user.getOpenId());
					if(!StringUtils.isEmpty(user.getOpenId())){
						//是绑定用户，解除绑定，删除userSource表数据
						wxBindUserManager.updateByPair("bind",0 ,"openId",user.getOpenId());
						wxBindUserManager.updateByPair("userId",0 ,"openId",user.getOpenId());
						UserSource record =new UserSource ();
						record.setUserid(user.getId());
						record.setSourcecode(new Integer(Constant.USER_SOURCE_WX).byteValue());
						userSourceManager.deleteUserSource(record);
					}else{
						sbuffer.append(temp+"的openId 是 null");
						sbuffer.append(" ");
						System.out.println(user.getMobilephone()+"的openId 是 "+user.getOpenId());
					}

				}else{
					sbuffer.append("找不到："+temp);
					sbuffer.append(" ");
					System.out.println("找不到："+temp);
				}
			}
		}else{
			return buildJson(-1,"没有手机号");
		}
		String msg=sbuffer.toString();
		if(StringUtils.isEmpty(msg)){
			return buildJson(0,"解绑成功");
		}else{
			return buildJson(-1,msg);
		}
		
    }
	
	
	@RequestMapping("/wxbind/rebind")
    @ResponseBody
    public Object rebind(HttpServletRequest request){
		String oldPhone=request.getParameter("oldPhone");
		String newPhone=request.getParameter("newPhone");
		oldPhone=StringUtils.trim(oldPhone);
		newPhone=StringUtils.trim(newPhone);
		if(StringUtils.isEmpty(oldPhone)||StringUtils.isEmpty(newPhone)){
			return buildJson(-1,"手机号码错误");
		}
		log.info("oldPhone "+oldPhone+"&&&newPhone"+newPhone);
		
		ExtraUser user=	userManager.getExtraUserByMobilePhone(oldPhone);
		if(user!=null){
			log.info("phone "+user.getMobilephone());
			log.info("userId "+user.getId());
			log.info("OpenId "+user.getOpenId());
			if(!StringUtils.isEmpty(user.getOpenId())){
				//是绑定用户,判断新手机号是否已经存在
				User temp=userManager.getByPhone(newPhone);
				if(temp!=null){
					return buildJson(-1,newPhone+"已存在，无法修改");
				}
				
				//修改绑定手机号，删除userSource表数据
				userManager.updateByPair("mobilePhone", newPhone, "id", user.getId());
				UserSource record =new UserSource ();
				record.setUserid(user.getId());
				record.setSourcecode(new Integer(Constant.USER_SOURCE_WX).byteValue());
				userSourceManager.deleteUserSource(record);
				//删除之后，重新插入一条数据
				record.setMobilephone(newPhone);
				userSourceManager.insertUserSource(record);
				return buildJson(0,"修改成功");
			}else{
				log.info(oldPhone+"的openId 是 "+user.getOpenId());
				return buildJson(-1,oldPhone+"的openId 是 null，非绑定用户，修改失败");
			}

		}else{
			log.info("找不到："+oldPhone);
			return buildJson(-1,"找不到："+oldPhone+"，修改失败");
		}
    }
	
	
}
