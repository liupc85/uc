package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.UpgradePloy;
import com.imxiaomai.persistence.domain.UpgradePloyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpgradePloyMapper {
	
	List<UpgradePloy> selectByOpid( Integer opid);
	
	
	
    int countByExample(UpgradePloyExample example);

    int deleteByExample(UpgradePloyExample example);

    int deleteByPrimaryKey(Integer opid);

    int insert(UpgradePloy record);

    int insertSelective(UpgradePloy record);

    List<UpgradePloy> selectByExample(UpgradePloyExample example);

    UpgradePloy selectByPrimaryKey(Integer opid);

    int updateByExampleSelective(@Param("record") UpgradePloy record, @Param("example") UpgradePloyExample example);

    int updateByExample(@Param("record") UpgradePloy record, @Param("example") UpgradePloyExample example);

    int updateByPrimaryKeySelective(UpgradePloy record);

    int updateByPrimaryKey(UpgradePloy record);
}