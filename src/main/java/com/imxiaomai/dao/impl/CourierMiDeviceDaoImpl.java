package com.imxiaomai.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.imxiaomai.persistence.domain.CourierMidevice;
import com.imxiaomai.persistence.mapper.CourierMideviceMapper;
import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.CourierMiDeviceDao;

public class CourierMiDeviceDaoImpl extends BaseDao implements CourierMiDeviceDao {
	 
	
		public int insert(CourierMidevice record)  {
			return this.getSqlSession().getMapper(CourierMideviceMapper.class).insert(record);
		}

		public <T> int updateByPair(  String name,  T val,Integer id)   {

			
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("field", name);
			map.put("value", " '"+val+"' ");
			map.put("id", id);
			map.put("updateTime","'"+time2(System.currentTimeMillis())+"' " );
			return this.getSqlSession().getMapper(CourierMideviceMapper.class).updateByPair(map);
		
//			return db.update(_.f("`%s` = ?,`updateTime` = ? where `id` = ?", name),val,time(System.currentTimeMillis()), id);
		}

		public  int update(String mobilePhone, String deviceId, String platform, String version, String srcChannel, String regId, Integer id)  {
			CourierMidevice record=new CourierMidevice();
			record.setMobilephone(mobilePhone);
			record.setDeviceid(deviceId);
			record.setPlatform(platform);
			record.setVersion(version);
			record.setSrcchannel(srcChannel);
			record.setRegid(regId);
			record.setId(id);
			record.setUpdatetime(time(System.currentTimeMillis()));
			return this.getSqlSession().getMapper(CourierMideviceMapper.class).updateByPrimaryKey(record);
		}
		

		public   List<CourierMidevice> getByUserId( Long userId)   {
			if(userId==null||userId.longValue()==0){
				return new ArrayList<CourierMidevice>();
			}
			CourierMidevice record=new CourierMidevice();
			record.setUserid(userId.intValue());
			return this.getSqlSession().getMapper(CourierMideviceMapper.class).getBySomeCondition(record);
		}

		public   CourierMidevice getNewByUserId(  Long userId)  {
			CourierMidevice tmp=this.getSqlSession().getMapper(CourierMideviceMapper.class).getNewByUserId(userId.intValue());
			return validate(tmp);
		}

		public   CourierMidevice getById(Long id)   {
			CourierMidevice tmp=this.getSqlSession().getMapper(CourierMideviceMapper.class).selectByPrimaryKey(id.intValue());
			return validate(tmp);
		}
		
		public   CourierMidevice getByDeviceId(String deviceId)  {
			if(StringUtils.isEmpty(deviceId)){
				return null;
			}
			CourierMidevice record=new CourierMidevice();
			record.setDeviceid(deviceId);
			List<CourierMidevice> list= this.getSqlSession().getMapper(CourierMideviceMapper.class).getBySomeCondition(record);
			if(list.size()>0&&!list.isEmpty()){
				return list.get(0);
			}else{
				return null;
			}
		}
		
		public   CourierMidevice getByDeviceIdAndMobilePhone( String deviceId, String mobilePhone) {
			CourierMidevice record=new CourierMidevice();
			record.setDeviceid(deviceId);
			record.setMobilephone(mobilePhone);
			CourierMidevice tmp=this.getSqlSession().getMapper(CourierMideviceMapper.class).getByDeviceIdAndMobilePhone(record);
			return validate(tmp);
		}
		
		/**
		  * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
		  * @param record
		  * @return
		  */
		 private CourierMidevice validate(CourierMidevice record){
		 	if(record==null){
		 		return new CourierMidevice();
		 	}else{
		 		return record;
		 	}
		 }
		
		
}
