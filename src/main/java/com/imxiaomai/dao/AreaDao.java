package com.imxiaomai.dao;

import java.util.List;

import com.imxiaomai.persistence.domain.Area;


public interface AreaDao {
	public  List<Area> getByCityId(Long cityId) ;

	public  Area getById(Long id) ;

	public  List<Area> getAll() ; 
}
