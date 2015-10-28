package com.imxiaomai.service.impl;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import com.imxiaomai.manager.ExpressManager;
import com.imxiaomai.persistence.domain.Express;
import com.imxiaomai.service.ExpressService;

public class ExpressServiceImpl implements ExpressService {
	
	@Resource
	private ExpressManager expressManager;

	@Override
	public List<Express> getExpress(long id) {
		List<Express> expressInfos;
		if( id != 0 ){
			expressInfos = Arrays.asList(expressManager.getById(id));
		}else{
			expressInfos = expressManager.getAll();
		}
		return expressInfos;
	}

	@Override
	public List<Express> getExpressByShortName(String shortName) {
		// TODO Auto-generated method stub
		return expressManager.getByshortName(shortName);
	}
	
	

}
