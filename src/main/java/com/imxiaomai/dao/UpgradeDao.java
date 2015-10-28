package com.imxiaomai.dao;

import java.util.List;

import com.imxiaomai.persistence.domain.Upgrade;

public interface UpgradeDao{	
	public  List<Upgrade> selectLargeVersion( long version) ;
	
	public  List<Upgrade> selectByVid( long vid);
}