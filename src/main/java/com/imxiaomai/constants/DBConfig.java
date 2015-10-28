package com.imxiaomai.constants;

import com.imxiaomai.base.db.Db;
import com.imxiaomai.base.infrastructure.Config;

import static com.imxiaomai.base._.toInt;

public class DBConfig {

	private static final Config dbAlias = Config.of("dbAlias", "xiaomaiUserCenter");

	private static final Config defHost = Config.of("dbHost", "127.0.0.1");
//	private static final Config defHost = Config.of("dbHost", "119.254.110.17");

//	private static final Config defDb = Config.of("dbName", "xiaomaiUser_test");
	private static final Config defDb = Config.of("dbName", "xiaomaiuser");

	private static final Config defPort = Config.of("dbPort", "3306");

	private static final Config defUser = Config.of("dbUser", "root");

	private static final Config defPassword = Config.of("dbPasswd", "123qaz");
//	private static final Config defPassword = Config.of("dbPasswd", "xiaomai@@@A");

	private static final Config defMaxConnectionCount = Config.of("dbMaxConn", "20");

	public static final Db userDB = Db.of(dbAlias.get(), defHost.get(), defPort.get(), defDb.get(), defUser.get(), defPassword.get(), toInt(defMaxConnectionCount.get()));

}
