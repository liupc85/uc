package com.imxiaomai.dao.impl;

import java.util.List;

import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.UpgradePloyDao;
import com.imxiaomai.persistence.domain.UpgradePloy;
import com.imxiaomai.persistence.mapper.UpgradePloyMapper;

public class  UpgradePloyDaoImpl extends BaseDao implements UpgradePloyDao{
	
	public  List<UpgradePloy> selectOne( long op) {
		if(op<=0){
			return null;
		}
		return this.getSqlSession().getMapper(UpgradePloyMapper.class).selectByOpid(new Long(op).intValue());
		
//		log.info("select upgradeploy by op = {}", op);
//		return db.select("where opid = ? and isUse = 1", op);
	}
	
	public  UpgradePloy select( long op) {
		if(op<=0){
			return null;
		}
//		log.info("select upgradeploy by op = {}", op);
//		return db.selectOne("where opid = ? and isUse = 1", op);
		List<UpgradePloy> list= this.getSqlSession().getMapper(UpgradePloyMapper.class).selectByOpid(new Long(op).intValue());
		if(!list.isEmpty()||list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
}