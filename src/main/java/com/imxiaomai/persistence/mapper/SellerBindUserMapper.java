package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.SellerBindUser;
import com.imxiaomai.persistence.domain.SellerBindUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SellerBindUserMapper {
    int countByExample(SellerBindUserExample example);

    int deleteByExample(SellerBindUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SellerBindUser record);

    int insertSelective(SellerBindUser record);

    List<SellerBindUser> selectByExample(SellerBindUserExample example);

    SellerBindUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SellerBindUser record, @Param("example") SellerBindUserExample example);

    int updateByExample(@Param("record") SellerBindUser record, @Param("example") SellerBindUserExample example);

    int updateByPrimaryKeySelective(SellerBindUser record);

    int updateByPrimaryKey(SellerBindUser record);
}