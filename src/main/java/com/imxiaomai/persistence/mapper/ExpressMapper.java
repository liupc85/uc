package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.Express;
import com.imxiaomai.persistence.domain.ExpressExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ExpressMapper {
	
	List<Express> getBySomeCondition(Express record);
	
	int updateByPair(Map<String,Object> map);
	
	List<Express> getAllByType(Express record);
	
	
	
    int countByExample(ExpressExample example);

    int deleteByExample(ExpressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Express record);

    int insertSelective(Express record);

    List<Express> selectByExample(ExpressExample example);

    Express selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Express record, @Param("example") ExpressExample example);

    int updateByExample(@Param("record") Express record, @Param("example") ExpressExample example);

    int updateByPrimaryKeySelective(Express record);

    int updateByPrimaryKey(Express record);
}