package com.imxiaomai.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.dao.UpgradePloyDao;
import com.imxiaomai.manager.UpgradePloyManager;
import com.imxiaomai.persistence.domain.UpgradePloy;


public class  UpgradePloyManagerImpl implements UpgradePloyManager{
	
	@Resource UpgradePloyDao upgradePloyDao;
	
	public  List<UpgradePloy> selectOne( long op){
		return upgradePloyDao.selectOne(op);
	}
	
	
	public  UpgradePloy select( long op){
		return upgradePloyDao.select(op);
	}
	
}