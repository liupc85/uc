package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.UserStat;
import com.imxiaomai.persistence.domain.UserStatExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserStatMapper {
	
	int updateIcon(UserStat record);
	
	int update(UserStat record);
	
	int updateVersionCode(UserStat record);

	int countByCondition(UserStat record);
	
	int updateByPair(Map<String,Object> map);
	
    
	
	int countByExample(UserStatExample example);

    int deleteByExample(UserStatExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(UserStat record);

    int insertSelective(UserStat record);

    List<UserStat> selectByExample(UserStatExample example);

    UserStat selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") UserStat record, @Param("example") UserStatExample example);

    int updateByExample(@Param("record") UserStat record, @Param("example") UserStatExample example);

    int updateByPrimaryKeySelective(UserStat record);

    int updateByPrimaryKey(UserStat record);
}