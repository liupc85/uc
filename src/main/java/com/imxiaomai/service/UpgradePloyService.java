package com.imxiaomai.service;

import java.util.List;

import com.imxiaomai.persistence.domain.UpgradePloy;


public interface UpgradePloyService{
	
	public  List<UpgradePloy> selectOne( long op);
	
	public  UpgradePloy select( long op);
	
}