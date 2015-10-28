package com.imxiaomai.manager;

import java.util.List;

import com.imxiaomai.persistence.domain.Express;

/**
 * 快递信息
 * @author Administrator
 *
 */
public interface ExpressManager {
	/*----------------------插入------------------------*/
	/**
	 * 插入时，不插入code,另外license_activate_num默认为100，license_activated_num默认为0
	 * @return
	 * @ 
	 */
	public int insert(Express record);

/*----------------------更新------------------------*/	
	//不更新编码
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
