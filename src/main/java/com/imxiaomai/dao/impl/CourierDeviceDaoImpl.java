package com.imxiaomai.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.CourierDeviceDao;
import com.imxiaomai.persistence.domain.CourierDevice;
import com.imxiaomai.persistence.mapper.CourierDeviceMapper;

public class CourierDeviceDaoImpl extends BaseDao implements  CourierDeviceDao {
	

	public int insert(CourierDevice record){
		return this.getSqlSession().getMapper(CourierDeviceMapper.class).insert(record);
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
		return this.getSqlSession().getMapper(CourierDeviceMapper.class).updateByPair(map);
	
//		return db.update(_.f("`%s` = ?,`updateTime` = ? where `id` = ?", name),val,time(System.currentTimeMillis()), id);
	}

	/**
	 * 更新全部字段
	 * @param record
	 * @return
	 */
	public int update(CourierDevice record){
		return this.getSqlSession().getMapper(CourierDeviceMapper.class).updateByPrimaryKey(record);
	}
	
	/**
	 * 更新部分字段
	 * @param record
	 * @return
	 */
	public int updateById(CourierDevice record) {
		return this.getSqlSession().getMapper(CourierDeviceMapper.class).updateByPrimaryKeySelective(record);
	}
	
	public  CourierDevice getByDeviceIdAndMobilePhone(String deviceid,  String mobilephone) {
		CourierDevice record=new CourierDevice();
		record.setDeviceid(deviceid);
		record.setMobilephone(mobilephone);
		return this.getSqlSession().getMapper(CourierDeviceMapper.class).getByDeviceIdAndMobilePhone(record);
//		return validate(tmp);
	}
	
	/**
	  * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
	  * @param record
	  * @return
	  */
	 private CourierDevice validate(CourierDevice record){
	 	if(record==null){
	 		return new CourierDevice();
	 	}else{
	 		return record;
	 	}
	 }
	
}
