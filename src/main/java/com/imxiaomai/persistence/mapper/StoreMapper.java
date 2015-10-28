package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.Store;
import com.imxiaomai.persistence.domain.StoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreMapper {
	
	Store getByCollegeId(Store record);
	
	List<Store> getAll(Store record);

    List<Store> getByCondition(Store record);

	int updateBySomeCondition(Store record);
	
    int countByExample(StoreExample example);

    int deleteByExample(StoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Store record);

    int insertSelective(Store record);

    List<Store> selectByExample(StoreExample example);

    Store selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Store record, @Param("example") StoreExample example);

    int updateByExample(@Param("record") Store record, @Param("example") StoreExample example);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}