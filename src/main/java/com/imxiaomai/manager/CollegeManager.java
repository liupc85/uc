package com.imxiaomai.manager;

import java.util.List;
import java.util.Map;

import com.imxiaomai.persistence.domain.College;


public interface CollegeManager {

	public  List<College> getAll();

	public  College getById( Long id);

	public  List<College> getByProvinceId( Long pid);

    //public static List<College> getByAreaId( Long areaId);

    public  Map<Long, Map<Long, String>> getAllWithColleges();

}
