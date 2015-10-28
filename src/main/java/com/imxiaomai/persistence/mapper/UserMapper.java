package com.imxiaomai.persistence.mapper;

import com.imxiaomai.persistence.domain.ExtraUser;
import com.imxiaomai.persistence.domain.User;
import com.imxiaomai.persistence.domain.UserExample;
import com.imxiaomai.persistence.domain.UserGold;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	
	User getUserByOpenId(String openId);
	
	User getByCondition(User record);
	
	List<User> getByUserIds(List<Integer> userIds);
	
	List<User> getByPage(HashMap<String,Integer> map);
	
	int updateSomeField(User record);
	
	int updateRandomToken(User record);
	
	int count();
	
	int updateByPair(Map<String,Object> map);
	
	User selectByPair(Map<String,Object> map);
	 
	ExtraUser getUserByOpenIdExceptPre(ExtraUser record);
	
	
	List<ExtraUser> getExtraUserByCondition(ExtraUser record) ;
	
	List<ExtraUser> getExtraUserByConditionForInnerJoin(ExtraUser record) ;
	 
	List<UserGold> selectOrderByGold(int retNum);
	
	/**
	 * 
	 * @param password
	 * @param id
	 * @param flag 原微信用户已经通过注册流程修改了密码的标记位
	 * @return
	 */
	int updatePasswordAndFlag( User record);
	
	
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User verifyBaseUser(Map<String, Object> map);
}