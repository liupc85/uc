package com.imxiaomai.base.db;

import com.imxiaomai.base._;
import com.imxiaomai.base.infrastructure.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Db extends ProxoolRunner {
    public static Logger logger = LoggerFactory.getLogger(Db.class);

    public static Db of(String dbAlias, String defHost, String defPort, String defDb,
                        String defUser, String defPassword) {
        return of(dbAlias, defHost, defPort, defDb, defUser, defPassword, DEFAULT_MAX_CONNECTION_COUNT);
    }

    public static Db of(String dbAlias, String defHost, String defPort, String defDb,
                        String defUser, String defPassword, int defMaxConnectionCount) {
        if (ProxoolRunner.registered(dbAlias)) {
            return new Db(dbAlias);
        } else {
            defHost = Config.of(dbAlias + ".host", defHost).get();
            defPort = Config.of(dbAlias + ".port", defPort).get();
            defDb = Config.of(dbAlias + ".db", defDb).get();
            defUser = Config.of(dbAlias + ".user", defUser).get();
            defPassword = Config.of(dbAlias + ".password", defPassword).get();
            defMaxConnectionCount = _.toInt(Config.of(dbAlias + ".maximum-connection-count",
		            _.toStr(defMaxConnectionCount)).get(), defMaxConnectionCount);
            if (defHost.length() > 0 && defPort.length() > 0 && defDb.length() > 0
                    && defUser.length() > 0) {
                logger.info("db register: {}={}@{}:{}/{}?{}", dbAlias, defUser, defHost, defPort, defDb, defMaxConnectionCount);
                ProxoolRunner.registerDB(dbAlias,
		                String.format("%s:%s/%s", defHost, defPort, defDb), defUser,
		                defPassword, defMaxConnectionCount);
                if (ProxoolRunner.registered(dbAlias)) {
                    return new Db(dbAlias);
                }
            }
            return null;
        }
    }

    @Deprecated // 只是为了兼容以前util-ext中的Db接口
    public ProxoolRunner get(){
        return this;
    }

    public final String name;

    private Db(String dbAlias) {
        super(dbAlias);
        this.name = dbAlias;
        logger.info("db instance: {}", dbAlias);
    }

    private static final int DEFAULT_MAX_CONNECTION_COUNT = 50;
}
