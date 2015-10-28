package com.imxiaomai.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.dao.UpgradeDao;
import com.imxiaomai.manager.UpgradeManager;
import com.imxiaomai.persistence.domain.Upgrade;

public class UpgradeManagerImpl implements UpgradeManager{	
	@Resource UpgradeDao upgradeDao;
	
	public  List<Upgrade> selectLargeVersion( long version){
		return upgradeDao.selectLargeVersion(version);
	}
	
	public  List<Upgrade> selectByVid( long vid){
		return upgradeDao.selectByVid(vid);
	}
}