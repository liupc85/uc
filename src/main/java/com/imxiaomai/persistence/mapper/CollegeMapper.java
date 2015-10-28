package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.College;
import com.imxiaomai.persistence.domain.CollegeExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CollegeMapper {
	
	List<College> getAll(College record);  
	
	List<College> getByProvinceId(Integer pid);
	
	List<Map<Object,Object>> getAllWithColleges();
	
	
	
    int countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(College record);

    int insertSelective(College record);

    List<College> selectByExample(CollegeExample example);

    College selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByExample(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);
}