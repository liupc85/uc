package com.imxiaomai.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.DeviceDao;
import com.imxiaomai.persistence.domain.Device;
import com.imxiaomai.persistence.mapper.DeviceMapper;

public class DeviceDaoImpl extends BaseDao implements  DeviceDao {
	

	public int insert(Device record){
		return this.getSqlSession().getMapper(DeviceMapper.class).insert(record);
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
		return this.getSqlSession().getMapper(DeviceMapper.class).updateByPair(map);
//		return db.update(_.f("`%s` = ?,`updateTime` = ? where `id` = ?", name),val,time(System.currentTimeMillis()), id);
	}

	/**
	 * 更新全部字段
	 * @param record
	 * @return
	 */
	public int update(Device record){
		return this.getSqlSession().getMapper(DeviceMapper.class).updateByPrimaryKey(record);
	}
	
	/**
	 * 更新部分字段
	 * @param record
	 * @return
	 */
	public int updateById(Device record) {
		return this.getSqlSession().getMapper(DeviceMapper.class).updateByPrimaryKeySelective(record);
	}
	
	public   List<Device> getByUserId( Long userId)   {
		if(userId==null||userId.longValue()==0){
			return new ArrayList<Device>();
		}
		Device record=new Device();
		record.setUserid(userId.intValue());
		return this.getSqlSession().getMapper(DeviceMapper.class).getBySomeCondition(record);
	}

	public   List<Device> getNewByUserId(  Long userId)  {
		return this.getSqlSession().getMapper(DeviceMapper.class).getNewByUserId(userId.intValue());
	}
	
	public   Device getByDeviceId(String deviceId)  {
		if(StringUtils.isEmpty(deviceId)){
			return null;
		}
		Device record=new Device();
		record.setDeviceid(deviceId);
		List<Device> list= this.getSqlSession().getMapper(DeviceMapper.class).getBySomeCondition(record);
		if(list.size()>0&&!list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	public   Device getById(Long id)   {
		return this.getSqlSession().getMapper(DeviceMapper.class).selectByPrimaryKey(id.intValue());
//		return validate(tmp);
	}
	
	public  Device getByDeviceIdAndMobilePhone(String deviceid,  String mobilephone) {
		Device record=new Device();
		record.setDeviceid(deviceid);
		record.setMobilephone(mobilephone);
		return this.getSqlSession().getMapper(DeviceMapper.class).getByDeviceIdAndMobilePhone(record);
//		return validate(tmp);
	}
	
	
	/**
	  * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
	  * @param record
	  * @return
	  */
	 private Device validate(Device record){
	 	if(record==null){
	 		return new Device();
	 	}else{
	 		return record;
	 	}
	 }
	
}
