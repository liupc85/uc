package com.imxiaomai.dao;

import java.util.List;

import com.imxiaomai.persistence.domain.UpgradePloy;


public interface UpgradePloyDao{
	
	public  List<UpgradePloy> selectOne( long op);
	
	public  UpgradePloy select( long op);
	
}