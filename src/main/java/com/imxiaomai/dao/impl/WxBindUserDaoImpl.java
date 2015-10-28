package com.imxiaomai.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import static com.imxiaomai.base._.trimToEmpty;

import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.WxBindUserDao;
import com.imxiaomai.persistence.domain.WxBindUser;
import com.imxiaomai.persistence.mapper.WxBindUserMapper;


public class WxBindUserDaoImpl extends BaseDao implements WxBindUserDao{
    
	public int updateUserId( Long userId,  String icode,Long id){
		WxBindUser record=new WxBindUser ();
		record.setId(id.intValue());
		record.setUserid(userId.intValue());
		record.setIcode(trimToEmpty(icode));
		record.setBind(1);
		return this.getSqlSession().getMapper(WxBindUserMapper.class).updateUserId(record);
	}

	public  long newRecord(String openId, String nickName, Integer sex, String headimgurl,int bind ,int userId){
		WxBindUser record=new WxBindUser ();
		record.setOpenid(openId);
		record.setNickname(nickName);
		record.setSex(sex);
		record.setHeadimgurl(headimgurl);
		record.setBind(bind);
		record.setUserid(userId);
		record.setCreatetime(time(System.currentTimeMillis()));
		return this.getSqlSession().getMapper(WxBindUserMapper.class).insert(record);
	}
 
	public  WxBindUser getByUserId(Long userId){
		if(userId==null||userId.longValue()<=0){
			return null;
		}
		WxBindUser record=new WxBindUser ();
		record.setUserid(userId.intValue());
		return this.getSqlSession().getMapper(WxBindUserMapper.class).getByCondition(record);
//		return validate(wx);
	}
	
	public  WxBindUser getById( Long id) {
		if(id==null||id.longValue()<=0){
			return null;
		}
		return this.getSqlSession().getMapper(WxBindUserMapper.class).selectByPrimaryKey(id.intValue());
	}
	
	public  List<WxBindUser> getByUserIds(List<Long> userIds){
		if(userIds.size()==0||userIds.isEmpty()){
			return new ArrayList<WxBindUser> ();
		}
		return this.getSqlSession().getMapper(WxBindUserMapper.class).getByUserIds(userIds);
	}

	
	public  WxBindUser getByOpenId( String openId ){
		if(StringUtils.isEmpty(openId)){
			return null;
		}
		WxBindUser record=new WxBindUser ();
		record.setOpenid(openId);
		return this.getSqlSession().getMapper(WxBindUserMapper.class).getByCondition(record);
//		return validate(wx);
	}
	
	public  WxBindUser getByUnionId( String unionId ){
		if(StringUtils.isEmpty(unionId)){
			return null;
		}
		WxBindUser record=new WxBindUser ();
		record.setUnionid(unionId);
		return this.getSqlSession().getMapper(WxBindUserMapper.class).getByCondition(record);
	}
	
	public <T> int updateByPair( String name, T val,String conditionName ,T conditionValue) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("field", name);
		map.put("value", " '"+val+"' ");
		map.put("conditionName", conditionName);
		map.put("conditionValue", " '"+conditionValue+"' ");
		return this.getSqlSession().getMapper(WxBindUserMapper.class).updateByPair(map);
	}
	
	public <T> WxBindUser selectByPair(String conditionName,T conditionValue){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("conditionName", conditionName);
		map.put("conditionValue", " '"+conditionValue+"' ");
		return this.getSqlSession().getMapper(WxBindUserMapper.class).selectByPair(map);
	}
	
    /**
     * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
     * @param record
     * @return
     */
    private WxBindUser validate(WxBindUser record){
    	if(record==null){
    		return new WxBindUser();
    	}else{
    		return record;
    	}
    }
	
}