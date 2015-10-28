package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.StoreExpress;
import com.imxiaomai.persistence.domain.StoreExpressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreExpressMapper {
	
	List<StoreExpress> selectAll(StoreExpress record);
	
    int countByExample(StoreExpressExample example);

    int deleteByExample(StoreExpressExample example);

    int deleteByPrimaryKey(Integer storeid);

    int insert(StoreExpress record);

    int insertSelective(StoreExpress record);

    List<StoreExpress> selectByExample(StoreExpressExample example);

    StoreExpress selectByPrimaryKey(Integer storeid);

    int updateByExampleSelective(@Param("record") StoreExpress record, @Param("example") StoreExpressExample example);

    int updateByExample(@Param("record") StoreExpress record, @Param("example") StoreExpressExample example);

    int updateByPrimaryKeySelective(StoreExpress record);

    int updateByPrimaryKey(StoreExpress record);
}