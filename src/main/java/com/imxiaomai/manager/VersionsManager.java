package com.imxiaomai.manager;

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
public interface VersionsManager{
	
	public  Versions getNewestOne(String type);
	
	public  Versions getNewestOne(String type, String pubType);
	
	public  Versions getById(Long vid, String type, String pubType);
	
	public  Versions getByVersion(String version, String type, String pubType);
	
}
