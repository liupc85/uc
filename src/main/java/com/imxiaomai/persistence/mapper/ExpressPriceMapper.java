package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.Express;
import com.imxiaomai.persistence.domain.ExpressPrice;
import com.imxiaomai.persistence.domain.ExpressPriceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ExpressPriceMapper {
	
	List<ExpressPrice> getBySomeCondition(ExpressPrice record);
	
    int countByExample(ExpressPriceExample example);

    int deleteByExample(ExpressPriceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExpressPrice record);

    int insertSelective(ExpressPrice record);

    List<ExpressPrice> selectByExample(ExpressPriceExample example);

    ExpressPrice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExpressPrice record, @Param("example") ExpressPriceExample example);

    int updateByExample(@Param("record") ExpressPrice record, @Param("example") ExpressPriceExample example);

    int updateByPrimaryKeySelective(ExpressPrice record);

    int updateByPrimaryKey(ExpressPrice record);
}