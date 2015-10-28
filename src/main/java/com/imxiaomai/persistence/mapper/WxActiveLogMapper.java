package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.WxActiveLog;
import com.imxiaomai.persistence.domain.WxActiveLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxActiveLogMapper {
    int countByExample(WxActiveLogExample example);

    int deleteByExample(WxActiveLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxActiveLog record);

    int insertSelective(WxActiveLog record);

    List<WxActiveLog> selectByExample(WxActiveLogExample example);

    WxActiveLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxActiveLog record, @Param("example") WxActiveLogExample example);

    int updateByExample(@Param("record") WxActiveLog record, @Param("example") WxActiveLogExample example);

    int updateByPrimaryKeySelective(WxActiveLog record);

    int updateByPrimaryKey(WxActiveLog record);
}