package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.StoreInfoLog;
import com.imxiaomai.persistence.domain.StoreInfoLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreInfoLogMapper {
    int countByExample(StoreInfoLogExample example);

    int deleteByExample(StoreInfoLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreInfoLog record);

    int insertSelective(StoreInfoLog record);

    List<StoreInfoLog> selectByExample(StoreInfoLogExample example);

    StoreInfoLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreInfoLog record, @Param("example") StoreInfoLogExample example);

    int updateByExample(@Param("record") StoreInfoLog record, @Param("example") StoreInfoLogExample example);

    int updateByPrimaryKeySelective(StoreInfoLog record);

    int updateByPrimaryKey(StoreInfoLog record);
}