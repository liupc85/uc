package com.imxiaomai.manager;

import java.util.List;

import com.imxiaomai.persistence.domain.Upgrade;

public interface UpgradeManager{	
	public  List<Upgrade> selectLargeVersion( long version) ;
	
	public  List<Upgrade> selectByVid( long vid);
}