package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.InviteRank;
import com.imxiaomai.persistence.domain.InviteRankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InviteRankMapper {
    int countByExample(InviteRankExample example);

    int deleteByExample(InviteRankExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InviteRank record);

    int insertSelective(InviteRank record);

    List<InviteRank> selectByExample(InviteRankExample example);

    InviteRank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InviteRank record, @Param("example") InviteRankExample example);

    int updateByExample(@Param("record") InviteRank record, @Param("example") InviteRankExample example);

    int updateByPrimaryKeySelective(InviteRank record);

    int updateByPrimaryKey(InviteRank record);
}