package com.imxiaomai.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.imxiaomai.base.dao.BaseDao;
import com.imxiaomai.dao.ExpressDao;
import com.imxiaomai.persistence.domain.Express;
import com.imxiaomai.persistence.mapper.ExpressMapper;

public class ExpressDaoImpl extends BaseDao  implements ExpressDao{
	/*----------------------插入------------------------*/
	public int insert(Express record){
		return this.getSqlSession().getMapper(ExpressMapper.class).insert(record);
	}

/*----------------------更新------------------------*/	
	public int update(Express record){
		return this.getSqlSession().getMapper(ExpressMapper.class).updateByPrimaryKey(record);
	}
	/**
	 * 根据id更新特定key
	 * @param key
	 * @param id
	 * @return
	 * @ 
	 */
	public  int updateKey( Object key, Object value, Object id){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("field", key);
		map.put("value", " '"+value+"' ");
		map.put("id", id);
		return this.getSqlSession().getMapper(ExpressMapper.class).updateByPair(map);
	}
/*----------------------查询------------------------*/	
	public  Express getById( Long id){
		return this.getSqlSession().getMapper(ExpressMapper.class).selectByPrimaryKey(id.intValue());
//		return validate(tmp);
	}
	
	public  List<Express> getAll(){
		Express record=new Express();
		List<Express> express=this.getSqlSession().getMapper(ExpressMapper.class).getBySomeCondition(record);
		return express;	
	}
	
	public  List<Express> getByshortName(String shortName){
		if(StringUtils.isEmpty(shortName)){
			return new ArrayList<Express>();
		}
		Express record=new Express();
		record.setShortName(shortName);
		List<Express> express=this.getSqlSession().getMapper(ExpressMapper.class).getBySomeCondition(record);
		return express;
	}
	
	public  List<Express> getAllByType(Integer type){
		if(type==null){
			return new ArrayList<Express>();
		}
		Express record=new Express();
		record.setType(type.byteValue());
		List<Express> express=this.getSqlSession().getMapper(ExpressMapper.class).getAllByType(record);
		return express;		
	}
	
/*----------------------判断是否存在------------------------*/		
	public  boolean existById( Long id) {
		Express express=this.getSqlSession().getMapper(ExpressMapper.class).selectByPrimaryKey(id.intValue());
		 if(express == null){
		    	return false;
		    }
		    return true;
	}

	public  boolean existByName( String name){
		if(StringUtils.isEmpty(name)){
			return false;
		}
		Express record=new Express();
		record.setName(name);
		List<Express> express=this.getSqlSession().getMapper(ExpressMapper.class).getBySomeCondition(record);
		if(express.size()>0&&!express.isEmpty()){
		    return false;
		}
		    return true;
	}

/*----------------------统计数量------------------------*/	
	public  int getCount(String sql, Object... params) {
		return -1;
	}

	
/*----------------------删除------------------------*/		
	public int delete( Long id) {
		return this.getSqlSession().getMapper(ExpressMapper.class).deleteByPrimaryKey(id.intValue());
	}
	
	/**
	  * 查询单条记录，如果未查询到，会返回null，将其转化为空对象
	  * @param record
	  * @return
	  */
	 private Express validate(Express record){
	 	if(record==null){
	 		return new Express();
	 	}else{
	 		return record;
	 	}
	 }
	
}
