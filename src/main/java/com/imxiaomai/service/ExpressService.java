package com.imxiaomai.service;

import java.util.List;

import com.imxiaomai.persistence.domain.Express;

public interface ExpressService {

	
	/**
	 * 查询全部
	 * @return
	 */
	List<Express> getExpress(long id);
	
	/**
	 * 根据名称查询全部
	 * @param shortName
	 * @return
	 */
	List<Express> getExpressByShortName(String shortName);
}
