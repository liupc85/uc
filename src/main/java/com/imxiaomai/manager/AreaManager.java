package com.imxiaomai.manager;

import java.util.List;

import com.imxiaomai.persistence.domain.Area;


public interface AreaManager {
	public  List<Area> getByCityId(Long cityId) ;

	public  Area getById(Long id) ;

	public  List<Area> getAll() ; 
}
