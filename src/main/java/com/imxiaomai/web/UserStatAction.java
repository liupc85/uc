package com.imxiaomai.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.imxiaomai.service.UserStatService;
import com.imxiaomai.web.base.BaseController;

public class UserStatAction extends BaseController {

	private Logger log=LoggerFactory.getLogger(UserStatAction.class);
	
	@Autowired UserStatService userStatService;
	
	
	 
	
	
}
