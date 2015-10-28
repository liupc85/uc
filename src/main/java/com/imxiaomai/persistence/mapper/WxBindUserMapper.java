package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.WxBindUser;
import com.imxiaomai.persistence.domain.WxBindUserExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WxBindUserMapper {
	
	WxBindUser getByCondition(WxBindUser record);
	
	List<WxBindUser> getByUserIds(List<Long> userIds);
	
	int updateUserId(WxBindUser record);
	
	int updateByPair(Map<String,Object> map);
	
	WxBindUser selectByPair(Map<String,Object> map);
	
	
    int countByExample(WxBindUserExample example);

    int deleteByExample(WxBindUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxBindUser record);

    int insertSelective(WxBindUser record);

    List<WxBindUser> selectByExample(WxBindUserExample example);

    WxBindUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxBindUser record, @Param("example") WxBindUserExample example);

    int updateByExample(@Param("record") WxBindUser record, @Param("example") WxBindUserExample example);

    int updateByPrimaryKeySelective(WxBindUser record);

    int updateByPrimaryKey(WxBindUser record);
}