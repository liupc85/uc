package com.imxiaomai.service;


import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;

public interface AreaService {
	
	/**
	 * 查询所有区域列表
	 * @return
	 */
	public List<Map<Object,Object>> getAreaList() ;

}
