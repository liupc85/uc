package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.StoreCollect;
import com.imxiaomai.persistence.domain.StoreCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreCollectMapper {
    int countByExample(StoreCollectExample example);

    int deleteByExample(StoreCollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreCollect record);

    int insertSelective(StoreCollect record);

    List<StoreCollect> selectByExample(StoreCollectExample example);

    StoreCollect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreCollect record, @Param("example") StoreCollectExample example);

    int updateByExample(@Param("record") StoreCollect record, @Param("example") StoreCollectExample example);

    int updateByPrimaryKeySelective(StoreCollect record);

    int updateByPrimaryKey(StoreCollect record);
}