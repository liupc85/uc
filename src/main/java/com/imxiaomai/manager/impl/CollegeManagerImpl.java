package com.imxiaomai.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.CollegeDao;
import com.imxiaomai.manager.CollegeManager;
import com.imxiaomai.persistence.domain.College;


public class CollegeManagerImpl  extends BaseManager implements CollegeManager   {
	
	@Resource
	private CollegeDao collegeDao;

	@Override
	public List<College> getAll() {
		return collegeDao.getAll();
	}

	@Override
	public College getById(Long id) {
		if(id == null){
			return null;
		}
		if(id <= 0){
			return null;
		}
		return collegeDao.getById(id);
	}

	@Override
	public List<College> getByProvinceId(Long pid) {
		if(pid == null){
			return new ArrayList<College>();
		}
		if(pid <=0 ){
			return new ArrayList<College>();
		}
		return collegeDao.getByProvinceId(pid);
	}
	
	 public  Map<Long, Map<Long, String>> getAllWithColleges(){
		 return collegeDao.getAllWithColleges();
	 }


}
