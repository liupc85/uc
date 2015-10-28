package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.ExpressPriceSf;
import com.imxiaomai.persistence.domain.ExpressPriceSfExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ExpressPriceSfMapper {
	
	ExpressPriceSf getByFromAreaIdAndToAreaId(ExpressPriceSf record);
	
	
	
    int countByExample(ExpressPriceSfExample example);

    int deleteByExample(ExpressPriceSfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExpressPriceSf record);

    int insertSelective(ExpressPriceSf record);

    List<ExpressPriceSf> selectByExample(ExpressPriceSfExample example);

    ExpressPriceSf selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExpressPriceSf record, @Param("example") ExpressPriceSfExample example);

    int updateByExample(@Param("record") ExpressPriceSf record, @Param("example") ExpressPriceSfExample example);

    int updateByPrimaryKeySelective(ExpressPriceSf record);

    int updateByPrimaryKey(ExpressPriceSf record);
}