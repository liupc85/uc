package com.imxiaomai.base.db;

import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMapsHandler<T, K, V> implements ResultSetHandler<Map<T, Map<K, V>>> {
    public AbstractMapsHandler() {
    }

    @Override
    public Map<T, Map<K, V>> handle(ResultSet resultSet) throws SQLException {
        Map<T, Map<K, V>> result = this.createMap();

        while(resultSet.next()) {
            T key = this.createKey(resultSet);
            if (result.containsKey(key)){
                K subkey = createSubKey(resultSet);
                V subValue = createSubValue(resultSet);
                result.get(key).put(subkey, subValue);
            } else {
                K subkey = createSubKey(resultSet);
                V subValue = createSubValue(resultSet);
                Map<K, V> subKV = createSubMap();
                subKV.put(subkey, subValue);
                result.put(key, subKV);
            }
        }

        return result;
    }

    protected Map<T, Map<K, V>> createMap() {
        return new HashMap();
    }

    protected Map<K, V> createSubMap() {
        return new HashMap();
    }

    protected abstract T createKey(ResultSet var1) throws SQLException;

    protected abstract K createSubKey(ResultSet var1) throws SQLException;

    protected abstract V createSubValue(ResultSet var1) throws SQLException;
}
