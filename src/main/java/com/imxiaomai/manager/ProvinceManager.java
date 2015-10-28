package com.imxiaomai.manager;

import java.io.Serializable;
import java.util.List;

import com.imxiaomai.persistence.domain.Province;

public interface ProvinceManager extends Serializable{

	public  Province getById(Long id) ;

	public  List<Province> getAll() ; 
}
