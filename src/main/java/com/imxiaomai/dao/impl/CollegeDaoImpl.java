package com.imxiaomai.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.CollegeDao;
import com.imxiaomai.persistence.domain.College;
import com.imxiaomai.persistence.mapper.CollegeMapper;

public class CollegeDaoImpl  extends BaseDao implements CollegeDao{

	public   List<College> getAll()   {
		College c=new College();
		c.setIsdel(0);
		return this.getSqlSession().getMapper(CollegeMapper.class).getAll(c);
	}

	public   College getById(Long id)  {
		return  this.getSqlSession().getMapper(CollegeMapper.class).selectByPrimaryKey(id.intValue());
//		return validate(tmp);
	}

	public   List<College> getByProvinceId(Long pid)  {
		return this.getSqlSession().getMapper(CollegeMapper.class).getByProvinceId(pid.intValue());
	}

    /*public static List<CollegeInfo> getByAreaId(Long areaId) throws SQLException {
        return db.select("where id in (select college_id from store_info where area_id=?) and isdel = 0", areaId);
    }*/
    
    public  Map<Long, Map<Long, String>>   getAllWithColleges()   {
    	Map<Long, Map<Long, String>> resmap=new HashMap<Long, Map<Long, String>>();
    	List<Map<Object,Object>> list=this.getSqlSession().getMapper(CollegeMapper.class).getAllWithColleges();
    	int length=list.size();
    	if(length<=0){
    		return new HashMap<Long, Map<Long, String>> ();
    	}
    	int current_province_id = (Integer)(list.get(0).get("province_id"));
    	Map<Long, String> tmp=new HashMap<Long, String>();
    	for(int i=0;i<length;i++){
    		Map<Object,Object> collegeMap=list.get(i);
//    		System.out.println("collegeMap "+collegeMap);
    		Integer province_id=(Integer)collegeMap.get("province_id");
    		Integer id=(Integer)collegeMap.get("id");
    		String name=(String)collegeMap.get("name");
//    		System.out.println("id "+id +"----------name "+name+"-----------province_id "+province_id);
//    		System.out.println("current_province_id "+current_province_id);
    		if(province_id.intValue()==current_province_id){
    			tmp.put(id.longValue(), name);
    			resmap.put( new Long(current_province_id), tmp);
    		}else{//同一个省的数据遍历完毕，加到list中
    			resmap.put( new Long((Integer)(list.get(i-1).get("province_id"))), tmp);
//        		reslist.add(resmap);
    			tmp=new HashMap<Long, String>();
    			tmp.put(id.longValue(), name);
    			current_province_id=province_id;
    		}
    		
    	}
    	return resmap;
    }
    
	/**
	  * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
	  * @param record
	  * @return
	  */
	 private College validate(College record){
	 	if(record==null){
	 		return new College();
	 	}else{
	 		return record;
	 	}
	 }
    

}
