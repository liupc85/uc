package com.imxiaomai.dao.impl;

import org.apache.commons.lang3.StringUtils;

import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.VersionsDao;
import com.imxiaomai.persistence.domain.Versions;
import com.imxiaomai.persistence.mapper.VersionsMapper;

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
public class VersionsDaoImpl extends BaseDao implements VersionsDao{
	
	public  Versions getNewestOne(String type)  {
		if(StringUtils.isEmpty(type)){
			return null;
		}
		Versions record=new Versions();
		record.setType(type);
		return this.getSqlSession().getMapper(VersionsMapper.class).getNewestOne(record);
//		return validate(tmp);
	}

	
	public  Versions getNewestOne(String type, String pubType)  {
		if(StringUtils.isEmpty(type)&&StringUtils.isEmpty(pubType)){//两个参数都为空，返回空对象
			return null;
		}
		Versions record=new Versions();
		record.setType(type);
		record.setPubtype(pubType);
		return this.getSqlSession().getMapper(VersionsMapper.class).getNewestOne(record);
//		return validate(tmp);
	}
	
	
	public  Versions getById(Long vid, String type, String pubType) {
		Versions record=new Versions();
		record.setId(vid.intValue());
		record.setType(type);
		record.setPubtype(pubType);
		return this.getSqlSession().getMapper(VersionsMapper.class).getById(record);
//		return validate(tmp);
	}
	
	
	public  Versions getByVersion(String version, String type, String pubType) {
		Versions record=new Versions();
		record.setVersion(version);
		record.setType(type);
		record.setPubtype(pubType);
		return this.getSqlSession().getMapper(VersionsMapper.class).getByVersion(record);
//		return validate(tmp);
	}
	
	   /**
     * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
     * @param record
     * @return
     */
    private Versions validate(Versions record){
    	if(record==null){
    		return new Versions();
    	}else{
    		return record;
    	}
    }
	
}
