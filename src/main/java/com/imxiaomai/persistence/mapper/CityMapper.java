package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.City;
import com.imxiaomai.persistence.domain.CityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityMapper {
	
    List<City> selectBySomeCondition(City record);
	
    int countByExample(CityExample example);

    int deleteByExample(CityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    List<City> selectByExample(CityExample example);

    City selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") City record, @Param("example") CityExample example);

    int updateByExample(@Param("record") City record, @Param("example") CityExample example);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    List<City> selectAll();
}