package com.imxiaomai.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.manager.UpgradePloyManager;
import com.imxiaomai.persistence.domain.UpgradePloy;
import com.imxiaomai.service.UpgradePloyService;


public class UpgradePloyServiceImpl implements UpgradePloyService{
	
	@Resource UpgradePloyManager upgradePloyManager;
	
	public  List<UpgradePloy> selectOne( long op){
		return upgradePloyManager.selectOne(op);
	}
	
	public  UpgradePloy select( long op){
		return upgradePloyManager.select(op);
	}
	
}