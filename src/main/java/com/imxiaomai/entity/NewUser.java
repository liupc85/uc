package com.imxiaomai.entity;

import java.net.URLDecoder;
import java.sql.SQLException;


import org.apache.commons.lang3.StringUtils;

import com.imxiaomai.util.DESUtil;

import static com.imxiaomai.base._.*;

/**
 * Created by liuxinggang on 15/7/9.
 */
public class NewUser {

    private static String desStr="123456";

    public static String common_string="iamoaixmi";
    
//    @Autowired static UserService userService;
//    private static final DBType1<NewUser> db = Table.newUserDB;


/*    public  long insert() throws UnsupportedEncodingException, SQLException {

        long id = db.insertRetKey("insert into " + db.tab() +"(`phone`,`password`,`collegeId`,`createTime`,`userName`) values(?,?,?,?,?)",phone,
                password,collegeId,new Date(createTime),userName);

        return id;
    }


    public static NewUser getByPhone(final String phone) throws SQLException {
        return db.selectOne("where `phone` = ?",phone);
    }


    public int update() throws UnsupportedEncodingException, SQLException {
        return db.update("`password` = ?,`collegeId` = ?,`userName`=? where `id` = ?",password,
                collegeId,userName,id);
    }


	public static NewUser getById(int userId) throws SQLException {
		return db.selectOne("where `id` = ?",userId);
	}


	public static NewUser validate(HttpServletRequest request) throws NumberFormatException, SQLException {
		//use des to encrypt or decrypt has a problem in header: \r\n, give up the method to put token in header, but in json
		String token = request.getHeader("token");
		String id = request.getHeader("id");
		String userId = request.getHeader("userId");
        if(isEmpty(id)||isEmpty(token)||isEmpty(userId)){
            return null;
        }
        DESUtil des = new DESUtil("123456");
        String newToken = des.decryptStr(token);
        if (!newToken.endsWith("iamoaixmi")) {
			return null;
		}
        String randomId = des.decryptStr(id);
        if (!randomId.startsWith("iamoaixmi")) {
			return null;
		}
        NewUser user = getById(Integer.parseInt(userId));
		return user;
	}*/
	
	public static boolean decodeAndvalidate(String randomToken,String randomId) throws NumberFormatException, SQLException {
        if(isEmpty(randomId) || isEmpty(randomToken)){
            return false;
        }
        String id =URLDecoder.decode(randomId);//先解码
        String token=URLDecoder.decode(randomToken);//先解码
        DESUtil des = new DESUtil(desStr);
        String newToken = des.decryptStr(token);
        if (!newToken.endsWith(common_string)) {
			return false;
		}
        String newId = des.decryptStr(id);
        if (!newId.startsWith(common_string)) {
			return false;
		}
       
        return true;
	}
	
	/**
	 * 解码并校验
	 * @param randomId
	 * @return
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public static boolean decodeAndvalidateRandomId(String randomId) throws NumberFormatException, SQLException {
        if(isEmpty(randomId)){
            return false;
        }
        String id =URLDecoder.decode(randomId);//先解码
        DESUtil des = new DESUtil(desStr);
        id = des.decryptStr(id);//再解密
        if (!id.startsWith("iamoaixmi")) {
			return false;
		}
        return true;
	}

	//加密
	public static  String encrypt(String s){
		if(StringUtils.isEmpty(s)){
			return "";
		}
		DESUtil des = new DESUtil(desStr);
		String res=des.encryptStr(s);
		return res;
	}
	
	
}
