package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.StoreFavorable;
import com.imxiaomai.persistence.domain.StoreFavorableExample;

//import com.imxiaomai.persistence.domain.StoreFavorableKey;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StoreFavorableMapper {
	
	List<StoreFavorable> getAll(StoreFavorable record);
	
	StoreFavorable getByStoreIdAndType(StoreFavorable record);
	
	
	
    int countByExample(StoreFavorableExample example);

    int deleteByExample(StoreFavorableExample example);

    int deleteByPrimaryKey(StoreFavorable key);

    int insert(StoreFavorable record);

    int insertSelective(StoreFavorable record);

    List<StoreFavorable> selectByExample(StoreFavorableExample example);

    StoreFavorable selectByPrimaryKey(StoreFavorable key);

    int updateByExampleSelective(@Param("record") StoreFavorable record, @Param("example") StoreFavorableExample example);

    int updateByExample(@Param("record") StoreFavorable record, @Param("example") StoreFavorableExample example);

    int updateByPrimaryKeySelective(StoreFavorable record);

    int updateByPrimaryKey(StoreFavorable record);
}