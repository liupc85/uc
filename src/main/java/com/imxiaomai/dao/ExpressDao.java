package com.imxiaomai.dao;

import java.util.List;

import com.imxiaomai.persistence.domain.Express;

/**
 * 快递信息
 * @author Administrator
 *
 */
public interface ExpressDao {
	/*----------------------插入------------------------*/
	public int insert(Express record);

/*----------------------更新------------------------*/	
	public int update(Express record);
	/**
	 * 根据id更新特定key
	 * @param key
	 * @param id
	 * @return
	 * @ 
	 */
	public  int updateKey( Object key, Object value, Object id);
/*----------------------查询------------------------*/	
	public  Express getById( Long id);
	
	public  List<Express> getAll();
	
	public  List<Express> getByshortName(String shortName);
	
	public  List<Express> getAllByType(Integer type);
	
/*----------------------判断是否存在------------------------*/		
	public  boolean existById( Long id) ;

	public  boolean existByName( String name);

/*----------------------统计数量------------------------*/	
	public  int getCount(String sql, Object... params) ;

/*----------------------删除------------------------*/		
	public int delete( Long id) ;
}
