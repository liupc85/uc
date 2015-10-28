package com.imxiaomai.manager.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.ProvinceDao;
import com.imxiaomai.manager.ProvinceManager;
import com.imxiaomai.persistence.domain.Province;

public class ProvinceManagerImpl  extends BaseManager implements ProvinceManager,Serializable {
	
	@Resource
	private ProvinceDao provinceDao;

	@Override
	public Province getById(Long id) {
		if(null == id || id <=0){
			return null;
		}
		return provinceDao.getById(id);
	}

	@Override
	public List<Province> getAll() {
		// TODO Auto-generated method stub
		return provinceDao.getAll();
	}

}
