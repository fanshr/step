package com.fanshr.step.engine.common.dao.split;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/3/30 11:44
 * @date : Modified at 2022/3/30 11:44
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDbType();
    }
}
