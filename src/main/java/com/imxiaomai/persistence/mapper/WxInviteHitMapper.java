package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.WxInviteHit;
import com.imxiaomai.persistence.domain.WxInviteHitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxInviteHitMapper {
    int countByExample(WxInviteHitExample example);

    int deleteByExample(WxInviteHitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxInviteHit record);

    int insertSelective(WxInviteHit record);

    List<WxInviteHit> selectByExample(WxInviteHitExample example);

    WxInviteHit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxInviteHit record, @Param("example") WxInviteHitExample example);

    int updateByExample(@Param("record") WxInviteHit record, @Param("example") WxInviteHitExample example);

    int updateByPrimaryKeySelective(WxInviteHit record);

    int updateByPrimaryKey(WxInviteHit record);
}