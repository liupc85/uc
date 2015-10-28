package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.Scorelist;
import com.imxiaomai.persistence.domain.ScorelistExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ScorelistMapper {
	
	Scorelist getByIdentify( Scorelist record);
	List<Scorelist> getByUserId(Scorelist record);
	List<Scorelist> getByUserIdAndType(Scorelist record);
	
	
	
	
    int countByExample(ScorelistExample example);

    int deleteByExample(ScorelistExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Scorelist record);

    int insertSelective(Scorelist record);

    List<Scorelist> selectByExample(ScorelistExample example);

    Scorelist selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Scorelist record, @Param("example") ScorelistExample example);

    int updateByExample(@Param("record") Scorelist record, @Param("example") ScorelistExample example);

    int updateByPrimaryKeySelective(Scorelist record);

    int updateByPrimaryKey(Scorelist record);
}