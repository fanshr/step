package com.fanshr.step.engine.common.dao.split;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/3/30 11:45
 * @date : Modified at 2022/3/30 11:45
 */
public class DynamicDataSourceHolder {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceHolder.class);
    private static  ThreadLocal<String> contextHolder = new ThreadLocal<String >();
    public static final String DB_MASTER = "master";
    public static final String DB_SLAVE = "slave";
    public static String getDbType(){
        String db = contextHolder.get();
        if (db == null) {
            db = DB_MASTER;
        }
        return db;
    }

    public static void setDbType(String str) {
        logger.info("使用数据源为：" + str);
        contextHolder.set(str);
    }

    public static void clearDBType(){
        contextHolder.remove();
    }


}
