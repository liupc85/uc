package com.imxiaomai.service;

import java.util.List;

import com.imxiaomai.persistence.domain.Upgrade;

public interface UpgradeService{	
	public  List<Upgrade> selectLargeVersion( long version) ;
	
	public  List<Upgrade> selectByVid( long vid);
}