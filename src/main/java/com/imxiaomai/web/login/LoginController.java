package com.imxiaomai.web.login;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imxiaomai.persistence.domain.UserPanshi;
import com.imxiaomai.service.LoginService;
import com.imxiaomai.web.base.BaseController;
import com.xiaomai.common.constants.BucSSOConstants;
import com.xiaomai.common.tool.BucSSOUtil;



@Controller
@RequestMapping("/")
public class LoginController extends BaseController{
	
	protected static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Resource
	private LoginService loginService;

	/**
	 * 进入到登陆页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ssoLogin.htm", method = {RequestMethod.POST,RequestMethod.GET})
	public String login(ModelMap model,HttpServletRequest request) {
		String APP_NAME = request.getParameter("APP_NAME");
		String BACK_URL = request.getParameter("BACK_URL");
		model.addAttribute("APP_NAME", APP_NAME);
		model.addAttribute("BACK_URL", BACK_URL);
		return "/login/login";
	}
	

	/**
	 * 用户登陆
	 * @param model
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login/ssoLogin", method = {RequestMethod.POST,RequestMethod.GET})
	public String ssoLogin(ModelMap model,HttpServletResponse response,HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String appName = request.getParameter("APP_NAME");
		String backUrl = request.getParameter("BACK_URL");
		String ssoToken = BucSSOUtil.getToken(appName, username);
		UserPanshi u = loginService.verifyBaseUser(username, password,response,request);
		if(u != null){
			try {
				if(null == backUrl || ("").equals(backUrl)){
					model.addAttribute("codeMessage", "用户登录重定向URL出错！");
					return "/login/login";
				}
				StringBuffer sb = new StringBuffer();
				sb.append(request.getScheme());
				sb.append("//");
				sb.append(request.getServerName());
				sb.append(":");
				sb.append(request.getServerPort());
				sb.append("/");
				sb.append(BucSSOConstants.DO_SEND_BUC_SSO_TOKEN);
				sb.append("?");
				sb.append("APP_NAME=");
				sb.append(appName);
				sb.append("&BACK_URL=");
				sb.append(backUrl);
				sb.append("&SSO_TOKEN=");
				sb.append(ssoToken);
				sb.append("&id=");
				sb.append(u.getId());
				sb.append("&userName=");
				sb.append(u.getUserName());
				sb.append("&realName=");
				sb.append(u.getRealName());
				sb.append("&mobilePhone=");
				sb.append(u.getMobilePhone());
				response.sendRedirect(sb.toString());
				return null;
			} catch (Exception e) {
				log.error("重定向出错backUrl＝"+backUrl,e);
				model.addAttribute("codeMessage", "用户登录重定向URL出错！");
			}
			return "/login/login";
		}
		model.addAttribute("codeMessage", "用户名或密码错误");
		return "/login/login";
	}
	
	/**
	 * 用户退出
	 * @param model
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login/ssoLogout", method = {RequestMethod.POST,RequestMethod.GET})
	public String ssoLogout(ModelMap model,HttpServletResponse response,HttpServletRequest request) {
		String username = request.getParameter("username");
		String appName = request.getParameter("APP_NAME");
		String backUrl = request.getParameter("BACK_URL");
		String ssoToken = BucSSOUtil.getToken(appName, username);
		try {
				if(null == backUrl || ("").equals(backUrl)){
					model.addAttribute("codeMessage", "用户登录重定向URL出错！");
					return "/login/login";
				}
				StringBuffer sb = new StringBuffer();
				sb.append(request.getScheme());
				sb.append("//");
				sb.append(request.getServerName());
				sb.append(":");
				sb.append(request.getServerPort());
				sb.append("/");
				sb.append(BucSSOConstants.DO_BUC_SSO_LOGOUT);
				sb.append("?");
				sb.append("APP_NAME=");
				sb.append(appName);
				sb.append("&BACK_URL=");
				sb.append(backUrl);
				sb.append("&SSO_TOKEN=");
				sb.append(ssoToken);
				response.sendRedirect(sb.toString());
				return null;
			} catch (Exception e) {
				log.error("重定向出错backUrl＝"+backUrl,e);
				model.addAttribute("codeMessage", "用户登录重定向URL出错！");
			}
		return "/login/login";
	}

}