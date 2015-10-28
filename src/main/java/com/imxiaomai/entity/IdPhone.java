package com.imxiaomai.entity;

import com.imxiaomai.base.db.DBType1;
import com.imxiaomai.base.db.Table;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by liuxinggang on 15/7/9.
 */
public class IdPhone {

    public long id;
    public String phone;
    public String randomId;
    public String password;
    public String productId;
    public String token;
    public String createTime;


    private static final DBType1<IdPhone> db = Table.idPhoneDB;


    public  long insert() throws UnsupportedEncodingException, SQLException {

        long id = db.insertRetKey("insert into " + db.tab() +"(`phone`,`password`,`randomId`,`productId`,`token`,`createTime`) values(?,?,?,?,?,?)",phone,
                password,randomId,productId,token,createTime);

        return id;
    }


    public static IdPhone getByPhone(final String phone) throws SQLException {
        return db.selectOne("where `phone` = ?",phone);
    }


    public int update() throws UnsupportedEncodingException, SQLException {
        return db.update("`password` = ?,`token` = ?,`productId` = ?,`randomId` = ?,`createTime` = ? where `phone` = ?",password
                ,token,productId,randomId,phone,createTime);
    }
}
