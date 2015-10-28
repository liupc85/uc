package com.imxiaomai.service;

import java.util.List;
import java.util.Map;

import com.imxiaomai.persistence.domain.College;

public interface CollegeService {
	
	List<College> getCollege(long id,long provinceId);

	public  List<College> getAll();

	public  College getById( Long id);

	public  List<College> getByProvinceId( Long pid);

    //public static List<College> getByAreaId( Long areaId);

    public  Map<Long, Map<Long, String>> getAllWithColleges();

}
