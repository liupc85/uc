package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.UserSource;
import com.imxiaomai.persistence.domain.UserSourceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserSourceMapper {
	
	public List<UserSource> queryUserSourceByUserId(Integer userId);
	
    int countByExample(UserSourceExample example);

    int deleteByExample(UserSourceExample example);

    int insert(UserSource record);
    
    int deleteUserSource(UserSource record);

    int insertSelective(UserSource record);

    List<UserSource> selectByExample(UserSourceExample example);

    int updateByExampleSelective(@Param("record") UserSource record, @Param("example") UserSourceExample example);

    int updateByExample(@Param("record") UserSource record, @Param("example") UserSourceExample example);

}