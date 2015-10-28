package com.imxiaomai.service.impl;

import javax.annotation.Resource;

import com.imxiaomai.manager.VersionsManager;
import com.imxiaomai.persistence.domain.Versions;
import com.imxiaomai.service.VersionsService;
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
public class VersionsServiceImpl implements VersionsService{
	
	@Resource
	VersionsManager versionsManager;
	
	public  Versions getNewestOne(String type){
		return versionsManager.getNewestOne(type);
	}
	
	public  Versions getNewestOne(String type, String pubType){
		return versionsManager.getNewestOne(type, pubType);
	}
	
	public  Versions getById(Long vid, String type, String pubType){
		return versionsManager.getById(vid, type, pubType);
	}
	
	public  Versions getByVersion(String version, String type, String pubType){
		return versionsManager.getByVersion(version, type, pubType);
	}
	
}
