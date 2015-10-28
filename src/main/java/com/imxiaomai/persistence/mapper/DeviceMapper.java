package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.Device;
import com.imxiaomai.persistence.domain.DeviceExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DeviceMapper {
	List<Device>  getNewByUserId(  Integer userId); 
	
	List<Device> getBySomeCondition(Device record);
	
	Device getByDeviceIdAndMobilePhone(Device record);
    
	int updateByPair(Map<String,Object> map);
	
	
	
	int countByExample(DeviceExample example);

    int deleteByExample(DeviceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Device record);

    int insertSelective(Device record);

    List<Device> selectByExample(DeviceExample example);

    Device selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByExample(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}