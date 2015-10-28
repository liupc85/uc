package com.imxiaomai.manager.impl;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.VersionsDao;
import com.imxiaomai.manager.VersionsManager;
import com.imxiaomai.persistence.domain.Versions;

/**
 * 版本升级信息
 * String version;   // 版本
 * String versionDesc;  // 升级文案
 * String type	表示app类型  如courier_app
 * int flag		标记位 0 没有更新  1可选  2强制
 * String pubType为版本类型(正式版(pub)，测试版(test))
 * @author Administrator
 *
 */
public class VersionsManagerImpl  extends BaseManager implements VersionsManager{
	
	@Resource 
	private  VersionsDao  versionsDao;

	@Override
	public Versions getNewestOne(String type) {
		// TODO Auto-generated method stub
		return versionsDao.getNewestOne(type);
	}

	@Override
	public Versions getNewestOne(String type, String pubType) {
		// TODO Auto-generated method stub
		return versionsDao.getNewestOne(type,pubType);
	}

	@Override
	public Versions getById(Long vid, String type, String pubType) {
		// TODO Auto-generated method stub
		return versionsDao.getById(vid, type, pubType);
	}

	@Override
	public Versions getByVersion(String version, String type, String pubType) {
		// TODO Auto-generated method stub
		return versionsDao.getByVersion(version, type, pubType);
	}
	
	
	
}
