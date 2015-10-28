package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.Upgrade;
import com.imxiaomai.persistence.domain.UpgradeExample;
//import com.imxiaomai.persistence.domain.UpgradeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpgradeMapper {
	
	List<Upgrade> selectLargeVersion( long version);
	
	List<Upgrade> selectByVid( long vid);
	
	
	
    int countByExample(UpgradeExample example);

    int deleteByExample(UpgradeExample example);


    int insert(Upgrade record);

    int insertSelective(Upgrade record);

    List<Upgrade> selectByExample(UpgradeExample example);

    int updateByExampleSelective(@Param("record") Upgrade record, @Param("example") UpgradeExample example);

    int updateByExample(@Param("record") Upgrade record, @Param("example") UpgradeExample example);

    int updateByPrimaryKeySelective(Upgrade record);

    int updateByPrimaryKey(Upgrade record);
}