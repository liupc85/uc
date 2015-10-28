package com.imxiaomai.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.manager.UpgradeManager;
import com.imxiaomai.persistence.domain.Upgrade;
import com.imxiaomai.service.UpgradeService;

public class  UpgradeServiceImpl implements UpgradeService{	
	
	@Resource UpgradeManager upgradeManager;
	
	
	public  List<Upgrade> selectLargeVersion( long version){
		return upgradeManager.selectLargeVersion(version);
	}
	
	public  List<Upgrade> selectByVid( long vid){
		return upgradeManager.selectByVid(vid);
	}
}