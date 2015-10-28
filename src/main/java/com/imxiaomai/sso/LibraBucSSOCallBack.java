package com.imxiaomai.sso;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.xiaomai.handler.impl.BucSSOCallBack;
import com.xiaomai.util.SimpleUserUtil;
import com.xiaomai.vo.BucSSOUser;



/**
 *
 * @author TianYou
 *
 */
public class LibraBucSSOCallBack extends BucSSOCallBack{
	
	@Autowired
	private HttpServletRequest request;
	
	private final static  String URL="/index";
    public static final String ATTRIBUTE_USER_NICK = "_opt_nk_";
	
	/**
     *
     *
     * @param request
     * @param response
     */
    public void afterLogin(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    	BucSSOUser user = SimpleUserUtil.getBucSSOUser(request);
    	response.sendRedirect(URL);
    }
    
   
    
    
}
