package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.CourierDevice;
import com.imxiaomai.persistence.domain.CourierDeviceExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CourierDeviceMapper {
	
	CourierDevice getByDeviceIdAndMobilePhone(CourierDevice record);
	
	int updateByPair(Map<String,Object> map);
	
	
    int countByExample(CourierDeviceExample example);

    int deleteByExample(CourierDeviceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourierDevice record);

    int insertSelective(CourierDevice record);

    List<CourierDevice> selectByExample(CourierDeviceExample example);

    CourierDevice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourierDevice record, @Param("example") CourierDeviceExample example);

    int updateByExample(@Param("record") CourierDevice record, @Param("example") CourierDeviceExample example);

    int updateByPrimaryKeySelective(CourierDevice record);

    int updateByPrimaryKey(CourierDevice record);
}