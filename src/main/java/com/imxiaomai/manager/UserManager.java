package com.imxiaomai.manager;


import java.util.List;

import com.imxiaomai.persistence.domain.ExtraUser;
import com.imxiaomai.persistence.domain.User;
import com.imxiaomai.persistence.domain.UserGold;
import com.imxiaomai.persistence.domain.UserStat;

public interface UserManager {
	public long insert(User record,String uid, String mac, String uuid) throws Exception;

	public  User validate( String mobilePhone,  String password);

	public  User grant( String mobilePhone,  String token);

	public int update(User record);

	public  User getById( Long id);

	public  User getByPhone( String mobilePhone);

	public  List<User> getUsers( Integer pageSize, Integer currentPage);
	
	public  List<User> getUsersByIds(List<UserStat> ids);
	
	/**
	 * count(String where, Object... params)的简版，目前只有User.count("")的调用
	 * @param where
	 * @return
	 */
	public  int count(String where, Object... params);
	
	
	public <T> int updateByPair( String name, T val,String conditionName ,T conditionValue) ;
	
	public <T> User  selectByPair(String conditionName ,T conditionValue);
	/**
	 * updatePassword 从 updateByPair中抽离出来
	 * @param password
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public  int updatePassword( String password,Integer id) throws Exception ;
	
	/**
	 * 
	 * @param password
	 * @param id
	 * @param flag 原微信用户已经通过注册流程修改了密码的标记位
	 * @return
	 */
	public  int updatePasswordAndFlag( String password,Integer id,Integer flag) throws Exception;
	
	public int updateSourceByOpenid(Integer id) ;

	public int updateSource(Integer source,Integer id) ;
	
    public int updateRandomToken(String randomId, String productId ,String randomToken,String mobilePhone);

    public User getUserByOpenId(String openId);
    
    public ExtraUser getExtraUserByOpenId(String openId);

    public ExtraUser getUserByOpenIdExceptPre(final String openId);
    
    public ExtraUser getExtraUserByMobilePhone(String mobilePhone);
    
    public ExtraUser getExtraUserByUserId(Integer userId);

    public List<ExtraUser> getExtraUserByAreaId(final Integer areaId);
    
    public ExtraUser getExtraUserByMobileForInnerJoin(String mobilePhone);
    
    public  List<UserGold> selectOrderByGold(int retNum); 
}
