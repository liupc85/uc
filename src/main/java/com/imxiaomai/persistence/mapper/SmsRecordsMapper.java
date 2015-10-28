package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.SmsRecords;
import com.imxiaomai.persistence.domain.SmsRecordsExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SmsRecordsMapper {
	
	List<SmsRecords> getByTelPhone(SmsRecords record);
	
	SmsRecords getNewsByTelPhone(SmsRecords record);
	
	
    int countByExample(SmsRecordsExample example);

    int deleteByExample(SmsRecordsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SmsRecords record);

    int insertSelective(SmsRecords record);

    List<SmsRecords> selectByExample(SmsRecordsExample example);

    SmsRecords selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SmsRecords record, @Param("example") SmsRecordsExample example);

    int updateByExample(@Param("record") SmsRecords record, @Param("example") SmsRecordsExample example);

    int updateByPrimaryKeySelective(SmsRecords record);

    int updateByPrimaryKey(SmsRecords record);
}