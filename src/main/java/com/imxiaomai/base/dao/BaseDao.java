package com.imxiaomai.base.dao;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imxiaomai.base.toolkit.DateUtil;


/**
 * 基础类型
 * 以后会封装一些批量的底层调用服务
 * @author TianYou
 *
 */
public abstract class BaseDao extends SqlSessionDaoSupport{
	
	protected final Logger logger = LoggerFactory.getLogger(BaseDao.class);
	
	public String time2(long currentTime){
		String time_str=DateUtil.format(currentTime, "yyyy-MM-dd HH:mm:ss");
		return time_str;
	}
	
	public Date time(long currentTime){
		return new Date(currentTime);
	}
	
	protected void batchUpdate( final String statementName, final List<?>  list) {
		
	}

	
	protected void batchInsert( final String statementName, final List<?> list) {
		
	}
	
	
	
	 protected void batchDelete( final String statementName, final List<?> list) {
		 
	 }
}
