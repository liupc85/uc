package com.imxiaomai.dao.impl;

import java.util.List;

import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.UpgradeDao;
import com.imxiaomai.persistence.domain.Upgrade;
import com.imxiaomai.persistence.mapper.UpgradeMapper;

public class UpgradeDaoImpl extends BaseDao implements UpgradeDao{	
	public  List<Upgrade> selectLargeVersion( long version) {
//		return db.select("where version> ? group by vid", version);
		return this.getSqlSession().getMapper(UpgradeMapper.class).selectLargeVersion(version);
	}
	
	public  List<Upgrade> selectByVid( long vid) {
//		return db.select("where vid =  ? ", vid);
		return this.getSqlSession().getMapper(UpgradeMapper.class).selectByVid(vid);
	}
	
}