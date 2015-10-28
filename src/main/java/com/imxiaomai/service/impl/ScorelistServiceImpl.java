package com.imxiaomai.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.imxiaomai.manager.ScorelistManager;
import com.imxiaomai.persistence.domain.Scorelist;
import com.imxiaomai.service.ScorelistService;



public class ScorelistServiceImpl implements ScorelistService{
	
	@Resource ScorelistManager scorelistManager;
	
	public  int insert( Integer userId,  Long score, Long type, Long identify, Long outId,  String tips){
		return scorelistManager.insert(userId, score, type, identify, outId, tips);
	}

	public  List<Scorelist> getByUserId( Long userId){
		return scorelistManager.getByUserId(userId);
	}

	public  List<Scorelist> getByUserIdAndType( Long userId, Long type){
		return scorelistManager.getByUserIdAndType(userId, type);
	}

	public  Scorelist getByIdentify( Long userId,  Long type, Long identify, Long outId){
		return scorelistManager.getByIdentify(userId, type, identify, outId);
	}
	
}
