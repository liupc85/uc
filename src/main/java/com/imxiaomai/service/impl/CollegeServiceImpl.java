package com.imxiaomai.service.impl;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.imxiaomai.manager.CollegeManager;
import com.imxiaomai.persistence.domain.College;
import com.imxiaomai.service.CollegeService;

public class CollegeServiceImpl implements CollegeService {
	
	@Resource
	private CollegeManager collegeManager;

	@Override
	public List<College> getCollege(long id, long provinceId) {
		List<College> collegeInfos;
		if( provinceId != 0 ){
			collegeInfos = collegeManager.getByProvinceId(provinceId);
		}else{
			if( id != 0 ){
				collegeInfos = Arrays.asList(collegeManager.getById(id));
			}else{
				collegeInfos = collegeManager.getAll();
			}
		}
	    return collegeInfos;
	}
	
	public  List<College> getAll(){
		return collegeManager.getAll();
	}

	public  College getById( Long id){
		return collegeManager.getById(id);
	}

	public  List<College> getByProvinceId( Long pid){
		return collegeManager.getByProvinceId(pid);
	}

    //public static List<College> getByAreaId( Long areaId);

    public  Map<Long, Map<Long, String>> getAllWithColleges(){
    	return collegeManager.getAllWithColleges();
    }
	

}
