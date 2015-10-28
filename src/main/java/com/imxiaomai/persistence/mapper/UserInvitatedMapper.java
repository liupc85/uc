package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.UserInvitated;
import com.imxiaomai.persistence.domain.UserInvitatedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInvitatedMapper {
    int countByExample(UserInvitatedExample example);

    int deleteByExample(UserInvitatedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInvitated record);

    int insertSelective(UserInvitated record);

    List<UserInvitated> selectByExample(UserInvitatedExample example);

    UserInvitated selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserInvitated record, @Param("example") UserInvitatedExample example);

    int updateByExample(@Param("record") UserInvitated record, @Param("example") UserInvitatedExample example);

    int updateByPrimaryKeySelective(UserInvitated record);

    int updateByPrimaryKey(UserInvitated record);
}