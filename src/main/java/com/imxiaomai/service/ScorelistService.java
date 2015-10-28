package com.imxiaomai.service;

import java.util.List;

import com.imxiaomai.persistence.domain.Scorelist;



public interface ScorelistService {
	public  int insert( Integer userId,  Long score, Long type, Long identify, Long outId,  String tips);

	public  List<Scorelist> getByUserId( Long userId);

	public  List<Scorelist> getByUserIdAndType( Long userId, Long type);

	public  Scorelist getByIdentify( Long userId,  Long type, Long identify, Long outId);
	
}
