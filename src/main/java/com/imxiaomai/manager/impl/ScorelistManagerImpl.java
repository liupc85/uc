package com.imxiaomai.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.base.manager.BaseManager;
import com.imxiaomai.dao.ScorelistDao;
import com.imxiaomai.manager.ScorelistManager;
import com.imxiaomai.persistence.domain.Scorelist;



public class ScorelistManagerImpl  extends BaseManager implements ScorelistManager {
	
	@Resource
	private ScorelistDao scorelistDao;
	

	@Override
	public int insert(Integer userId, Long score, Long type, Long identify,
			Long outId, String tips) {
		// TODO Auto-generated method stub
		return scorelistDao.insert(userId, score, type, identify, outId, tips);
	}

	@Override
	public List<Scorelist> getByUserId(Long userId) {
		// TODO Auto-generated method stub
		return scorelistDao.getByUserId(userId);
	}

	@Override
	public List<Scorelist> getByUserIdAndType(Long userId, Long type) {
		// TODO Auto-generated method stub
		return scorelistDao.getByUserIdAndType(userId, type);
	}

	@Override
	public Scorelist getByIdentify(Long userId, Long type, Long identify,
			Long outId) {
		// TODO Auto-generated method stub
		return scorelistDao.getByIdentify(userId, type, identify, outId);
	}
	
}
