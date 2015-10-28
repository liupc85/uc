package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.Midevice;
import com.imxiaomai.persistence.domain.MideviceExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MideviceMapper {
	
	List<Midevice> getBySomeCondition(Midevice record);
	
	Midevice  getNewByUserId(  Integer userId); 
	
	Midevice getByDeviceIdAndMobilePhone(Midevice record);
	
	int updateByPair(Map<String,Object> map);
	
	
	
    int countByExample(MideviceExample example);

    int deleteByExample(MideviceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Midevice record);

    int insertSelective(Midevice record);

    List<Midevice> selectByExample(MideviceExample example);

    Midevice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Midevice record, @Param("example") MideviceExample example);

    int updateByExample(@Param("record") Midevice record, @Param("example") MideviceExample example);

    int updateByPrimaryKeySelective(Midevice record);

    int updateByPrimaryKey(Midevice record);
}