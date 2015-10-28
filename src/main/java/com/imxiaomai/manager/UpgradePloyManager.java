package com.imxiaomai.manager;

import java.util.List;

import com.imxiaomai.persistence.domain.UpgradePloy;


public interface UpgradePloyManager{
	
	public  List<UpgradePloy> selectOne( long op);
	
	public  UpgradePloy select( long op);
	
}