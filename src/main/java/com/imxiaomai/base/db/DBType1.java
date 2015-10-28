package com.imxiaomai.base.db;

import com.imxiaomai.base.anno.Comment;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static com.imxiaomai.base._.f;

@Comment("不分表的数据库操作辅助类")
public class DBType1<T> extends Table.BaseDB<T> {

	DBType1(Class<T> type, String tab) {
		super(type, tab);
	}

	public String tab() {
		return this.tab;
	}

	/* ------------------------- utils ------------------------- */

	/*------------------对级联查询的扩张----------------------*/
    public Map<Long, Map<Long, String>> queryKeyeds(String sql, Object... params) throws SQLException {
        return db().queryKeyeds(sql, params);
    }

	public static <T> List<T> select(Class<T> type,String sql, Object... params) throws SQLException {
		return Table._getDb("").queryBeans(type, sql, params) ;
	}
	public List<T> select(String where, Object... params) throws SQLException {
		String sql = f("select * from `%s` %s", tab(), where);
		return db().queryBeans(type, sql, params);
	}
	public T selectOne(String where, Object... params) throws SQLException {
		String sql = f("select * from `%s` %s", tab(), where);
		return db().queryBean(type, sql, params);
	}
	public int selectCount(String where, Object... params) throws SQLException {
		String sql = f("select count(*) from `%s` %s", tab(), where);
		return db().queryInt(sql, params);
	}
	public long selectLong(String key, String where, Object... params) throws SQLException {
		String sql = f("select %s from `%s` %s", key, tab(), where);
		return db().queryLong(sql, params);
	}
	public List<Long> selectLongList(String key, String where, Object... params) throws SQLException {
		String sql = f("select %s from `%s` %s", key, tab(), where);
		return db().queryLongList(sql, params);
	}
	public List<String> selectStrList(String key, String where, Object... params) throws SQLException {
		String sql = f("select %s from `%s` %s", key, tab(), where);
		return db().queryStringList(sql, params);
	}
//	public List<T> selectLeftJoin(String sql,Object... params) throws SQLException{
//		return db().queryBeans(type, sql, params) ;
//	}
 
	/** on duplicate key update也可以用这个函数 */
	public int insert(String clause, Object... params) throws SQLException {
		String sql = f("insert into `%s`%s", tab(), clause);
		return db().update(sql, params);
	}
	public int insertIgnore(String clause, Object... params) throws SQLException {
		String sql = f("insert ignore into `%s`%s", tab(), clause);
		return db().update(sql, params);
	}
	public int replace(String clause, Object... params) throws SQLException {
		String sql = f("replace into `%s`%s", tab(), clause);
		return db().update(sql, params);
	}

	public int update(String sql, Object... params) throws SQLException {
		sql = f("update `%s` set %s", tab(), sql);
		return db().update(sql, params);
	}
	public int delete(String where, Object... params) throws SQLException {
		String sql = f("delete from `%s` %s", tab(), where);
		return db().update(sql, params);
	}

	public long insertRetKey(String sql, Object ... params) throws SQLException {
		return db().insertReturnKey(sql, params);
	}

	public int batchInsertIngore(String sql, List<Object[]> params) throws SQLException {
		sql = f("insert ignore into `%s`%s", tab(), sql);
		int[] rows = db().batch(sql, params.toArray(new Object[params.size()][]));
		return sum(rows);
	}
	public int batchDelete(String sql, List<Object[]> params) throws SQLException {
		sql = f("delete from `%s` %s", tab(), sql);
		int[] rows = db().batch(sql, params.toArray(new Object[params.size()][]));
		return sum(rows);
	}
	
	private static int sum(int[] rows) {
		int sum = 0;
		for (int i : rows)
			sum += i;
		return sum;
	}

}

