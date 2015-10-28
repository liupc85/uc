package com.imxiaomai.entity;

import java.sql.SQLException;
import java.util.List;

import com.imxiaomai.base.db.DBType1;


public class UserGold {
	public long gold ;
	public long userId ;
	public String mobilePhone ;
	public String realName ;
	public static List<UserGold> selectOrderByGold(int retNum) throws SQLException{
		return DBType1.select(UserGold.class,"SELECT us.gold,us.userId,u.mobilePhone,u.realName FROM `userStat` AS us"+ 
				" LEFT JOIN `user` AS u ON us.userId = u.id ORDER BY us.gold DESC LIMIT ? " ,retNum) ;
	}
}
