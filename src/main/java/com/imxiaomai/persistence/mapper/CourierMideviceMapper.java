package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.CourierMidevice;
import com.imxiaomai.persistence.domain.CourierMideviceExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CourierMideviceMapper {
	
	List<CourierMidevice> getBySomeCondition(CourierMidevice record);
	
	CourierMidevice getByDeviceIdAndMobilePhone(CourierMidevice record);
	
	CourierMidevice getNewByUserId(  Integer userId);
	
	int updateByPair(Map<String,Object> map);
	
	
	
	int countByExample(CourierMideviceExample example);

    int deleteByExample(CourierMideviceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourierMidevice record);

    int insertSelective(CourierMidevice record);

    List<CourierMidevice> selectByExample(CourierMideviceExample example);

    CourierMidevice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourierMidevice record, @Param("example") CourierMideviceExample example);

    int updateByExample(@Param("record") CourierMidevice record, @Param("example") CourierMideviceExample example);

    int updateByPrimaryKeySelective(CourierMidevice record);

    int updateByPrimaryKey(CourierMidevice record);
}