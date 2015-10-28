package com.imxiaomai.web.base;


import com.imxiaomai.base.infrastructure.Config;
import com.imxiaomai.base.infrastructure.Module;
import com.imxiaomai.base.toolkit.AutoLog;
//import com.imxiaomai.lifecycle.ZkRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InitListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		initInfrastructure(ctx);
		setConstants(ctx);
		initModules(ctx);
	}

	private void initInfrastructure(ServletContext ctx) {
	}

	private void setConstants(ServletContext context) {
		// set hostLabel
		String hostip = "0.0.0.0";
		String hostlabel = "0";
		try {
			InetAddress host = InetAddress.getLocalHost();
			hostip = host.getHostAddress();
			hostlabel = hostip; //.replaceFirst(".*\\.", "");
		} catch (UnknownHostException e) {
			logger.error("get local ip err.", e);
		}
		context.setAttribute("hostlabel", hostlabel);
	}

	private void initModules(ServletContext ctx) {
		Config.load(ctx);
//		Module.startup(ZkRegister.ZkRegisterModule.class);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		AutoLog.printAll();
//		Module.shutdown(ZkRegister.ZkRegisterModule.class);
	}

	static final Logger logger = LoggerFactory.getLogger(InitListener.class);

}
