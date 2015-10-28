package com.imxiaomai.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.ExpressDao;
import com.imxiaomai.manager.ExpressManager;
import com.imxiaomai.persistence.domain.Express;

/**
 * 快递信息
 * @author Administrator
 *
 */
public class ExpressManagerImpl  extends BaseManager implements ExpressManager {
	
	@Resource
	private ExpressDao expressDao;
	

	@Override
	public int insert(Express record) {
		if(record == null){
			return 0;
		}
		return expressDao.insert(record);
	}

	@Override
	public int update(Express record) {
		if(record == null){
			return 0;
		}
		return expressDao.update(record);
	}

	@Override
	public int updateKey(Object key, Object value, Object id) {
		// TODO Auto-generated method stub
		return expressDao.updateKey(key, value, id);
	}

	@Override
	public Express getById(Long id) {
		if(id == null || id <= 0){
			return null;
		}
		return expressDao.getById(id);
	}

	@Override
	public List<Express> getAll() {
		// TODO Auto-generated method stub
		return expressDao.getAll();
	}

	@Override
	public List<Express> getByshortName(String shortName) {
		if(null == shortName || ("").equals(shortName)){
			return new ArrayList<Express>();
		}
		return expressDao.getByshortName(shortName);
	}

	@Override
	public List<Express> getAllByType(Integer type) {
		if(type ==null){
			return new ArrayList<Express>();
		}
		return expressDao.getAllByType(type);
	}

	@Override
	public boolean existById(Long id) {
		if(null == id){
			return false;
		}
		if(0 >= id){
			return false;
		}
		return expressDao.existById(id);
	}

	@Override
	public boolean existByName(String name) {
		if(null == name || ("").equals(name)){
			return false;
		}
		return expressDao.existByName(name);
	}

	@Override
	public int getCount(String sql, Object... params) {
		return expressDao.getCount(sql, params);
	}

	@Override
	public int delete(Long id) {
		if(null == id){
			return 0;
		}
		if(0 >= id){
			return 0;
		}
		
		return expressDao.delete(id);
	}
	
}
