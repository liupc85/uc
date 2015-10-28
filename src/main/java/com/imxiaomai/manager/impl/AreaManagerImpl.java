package com.imxiaomai.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.AreaDao;
import com.imxiaomai.manager.AreaManager;
import com.imxiaomai.persistence.domain.Area;

/**
 *
 * 如果是唯一参数为空的则统一返回
 * @author 温德亮
 *
 */
public class AreaManagerImpl extends BaseManager implements AreaManager  {
	
	@Resource
	private AreaDao  areaDao;

	@Override
	public List<Area> getByCityId(Long cityId) {
		if(cityId == null){
			return new ArrayList<Area>();
		}
		
		if(cityId <= 0l){
			return new ArrayList<Area>();
		}
		
		return areaDao.getByCityId(cityId);
	}

	@Override
	public Area getById(Long id) {
		if(id == null){
			return null;
		}
		
		if(id <= 0l){
			return null;
		}
		
		return areaDao.getById(id);
	}

	@Override
	public List<Area> getAll() {
		// TODO Auto-generated method stub
		return areaDao.getAll();
	}

}
