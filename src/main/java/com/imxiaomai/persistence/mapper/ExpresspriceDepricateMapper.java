package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.ExpresspriceDepricate;
import com.imxiaomai.persistence.domain.ExpresspriceDepricateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpresspriceDepricateMapper {
    int countByExample(ExpresspriceDepricateExample example);

    int deleteByExample(ExpresspriceDepricateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExpresspriceDepricate record);

    int insertSelective(ExpresspriceDepricate record);

    List<ExpresspriceDepricate> selectByExampleWithBLOBs(ExpresspriceDepricateExample example);

    List<ExpresspriceDepricate> selectByExample(ExpresspriceDepricateExample example);

    ExpresspriceDepricate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExpresspriceDepricate record, @Param("example") ExpresspriceDepricateExample example);

    int updateByExampleWithBLOBs(@Param("record") ExpresspriceDepricate record, @Param("example") ExpresspriceDepricateExample example);

    int updateByExample(@Param("record") ExpresspriceDepricate record, @Param("example") ExpresspriceDepricateExample example);

    int updateByPrimaryKeySelective(ExpresspriceDepricate record);

    int updateByPrimaryKeyWithBLOBs(ExpresspriceDepricate record);

    int updateByPrimaryKey(ExpresspriceDepricate record);
}