package com.imxiaomai.dao.impl;

import java.util.List;



import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.ScorelistDao;
import com.imxiaomai.persistence.domain.Scorelist;
import com.imxiaomai.persistence.mapper.ScorelistMapper;


public class ScorelistDaoImpl extends BaseDao implements ScorelistDao {
	public  int insert( Integer userId,  Long score, Long type, Long identify, Long outId,  String tips) {
		Scorelist record=new Scorelist();
		record.setUserid(userId.intValue());
		record.setScore(score.intValue());
		record.setType(type.intValue());
		record.setIdentify(identify.intValue());
		record.setOutid(outId.intValue());
		record.setTips(tips);
		record.setTime(time(System.currentTimeMillis()));
		return this.getSqlSession().getMapper(ScorelistMapper.class).insert(record);
	}

	public  List<Scorelist> getByUserId( Long userId) {
		Scorelist record=new Scorelist();
		record.setUserid(userId.intValue());
		return this.getSqlSession().getMapper(ScorelistMapper.class).getByUserId(record);
	}

	public  List<Scorelist> getByUserIdAndType( Long userId, Long type) {
		Scorelist record=new Scorelist();
		record.setUserid(userId.intValue());
		record.setType(type.intValue());//type字段有可能为0，故不能和上面用一个方法，无法区分
		return this.getSqlSession().getMapper(ScorelistMapper.class).getByUserIdAndType(record);
	}

	public  Scorelist getByIdentify( Long userId,  Long type, Long identify, Long outId) {
		Scorelist record=new Scorelist();
		record.setUserid(userId.intValue());
		record.setType(type.intValue());
		record.setIdentify(identify.intValue());
		record.setOutid(outId.intValue());
		return this.getSqlSession().getMapper(ScorelistMapper.class).getByIdentify(record);
//		return validate(tmp);
	}
	
	/**
	  * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
	  * @param record
	  * @return
	  */
	 private Scorelist validate(Scorelist record){
	 	if(record==null){
	 		return new Scorelist();
	 	}else{
	 		return record;
	 	}
	 }
}
