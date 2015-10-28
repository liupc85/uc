package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.Versions;
import com.imxiaomai.persistence.domain.VersionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VersionsMapper {
	
	Versions getNewestOne(Versions record);
	
	Versions getById(Versions record);
	
	Versions getByVersion(Versions record);
	
	
	
    int countByExample(VersionsExample example);

    int deleteByExample(VersionsExample example);

    int deleteByPrimaryKey(Versions key);

    int insert(Versions record);

    int insertSelective(Versions record);

    List<Versions> selectByExample(VersionsExample example);

    Versions selectByPrimaryKey(Versions key);

    int updateByExampleSelective(@Param("record") Versions record, @Param("example") VersionsExample example);

    int updateByExample(@Param("record") Versions record, @Param("example") VersionsExample example);

    int updateByPrimaryKeySelective(Versions record);

    int updateByPrimaryKey(Versions record);
}