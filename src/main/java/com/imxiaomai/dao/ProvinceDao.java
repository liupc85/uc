package com.imxiaomai.dao;

import java.util.List;

import com.imxiaomai.persistence.domain.Province;

public interface ProvinceDao {

	public  Province getById(Long id) ;

	public  List<Province> getAll() ; 
}
