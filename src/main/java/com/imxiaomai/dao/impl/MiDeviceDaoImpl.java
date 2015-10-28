package com.imxiaomai.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.MiDeviceDao;
import com.imxiaomai.persistence.domain.Midevice;
import com.imxiaomai.persistence.mapper.MideviceMapper;

public  class MiDeviceDaoImpl extends BaseDao implements MiDeviceDao {
	

	public int insert(Midevice record) {
		return this.getSqlSession().getMapper(MideviceMapper.class).insert(record);
	}

	/**
	 * 无人调用
	 * @param name
	 * @param val
	 * @return
	 */
	public <T> int updateByPair( String name,T val,Integer id) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("field", name);
		map.put("value", " '"+val+"' ");
		map.put("id", id);
		map.put("updateTime","'"+time2(System.currentTimeMillis())+"' " );
		return this.getSqlSession().getMapper(MideviceMapper.class).updateByPair(map);
//		return db.update(_.f("`%s` = ?,`updateTime` = ? where `id` = ?", name),val,time(System.currentTimeMillis()), id);
	}

	/**
	 * 更新全部字段
	 * @param record
	 * @return
	 */
	public int update(Midevice record){
		return this.getSqlSession().getMapper(MideviceMapper.class).updateByPrimaryKey(record);
	}
	
	public  List<Midevice> getByUserId(Long userId){
		if(userId==null||userId.longValue()==0){
			return new ArrayList<Midevice>();
		}
		Midevice record=new Midevice();
		record.setUserid(userId.intValue());
		return this.getSqlSession().getMapper(MideviceMapper.class).getBySomeCondition(record);
	
	}

	public Midevice getNewByUserId(Long userId){
		return this.getSqlSession().getMapper(MideviceMapper.class).getNewByUserId(userId.intValue());
	}

	public  Midevice getById( Long id) {
		return this.getSqlSession().getMapper(MideviceMapper.class).selectByPrimaryKey(id.intValue());
//		return validate(tmp);
	}
	
	public  Midevice getByDeviceId( String deviceId) {
		
		if(StringUtils.isEmpty(deviceId)){
			return null;
		}
		Midevice record=new Midevice();
		record.setDeviceid(deviceId);
		List<Midevice> list= this.getSqlSession().getMapper(MideviceMapper.class).getBySomeCondition(record);
		if(list.size()>0&&!list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	public  Midevice getByDeviceIdAndMobilePhone(String deviceid,  String mobilephone){
		Midevice record=new Midevice();
		record.setDeviceid(deviceid);
		record.setMobilephone(mobilephone);
		return this.getSqlSession().getMapper(MideviceMapper.class).getByDeviceIdAndMobilePhone(record);
//		return validate(tmp);
	}
	
	/**
	  * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
	  * @param record
	  * @return
	  */
	 private Midevice validate(Midevice record){
	 	if(record==null){
	 		return new Midevice();
	 	}else{
	 		return record;
	 	}
	 }
	
}
