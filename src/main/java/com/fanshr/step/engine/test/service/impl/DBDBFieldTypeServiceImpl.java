package com.fanshr.step.engine.test.service.impl;

import com.alibaba.fastjson.JSON;
import com.fanshr.step.engine.common.dto.Execution;
import com.fanshr.step.engine.test.dao.DBFieldTypeDao;
import com.fanshr.step.engine.test.service.DBFieldTypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/10 13:02
 * @date : Modified at 2022/2/10 13:02
 */
@Service
public class DBDBFieldTypeServiceImpl implements DBFieldTypeService {

    @Autowired
    DBFieldTypeDao DBFieldTypeDao;
    private static final Logger logger = LoggerFactory.getLogger(DBDBFieldTypeServiceImpl.class);


    @Override
    public Execution getList(int current,int pageSize) {
        PageHelper.startPage(current, pageSize);
        Page page = DBFieldTypeDao.findByPage();
        logger.info("测试数据-->{}", JSON.toJSONString(page));
        logger.info("测试数据toString-->{}", page.toString());

        PageInfo pageInfo = new PageInfo<>(page);
        logger.info("测试数据-->{}", JSON.toJSONString(pageInfo));

        return new Execution(page.getResult(),page.getTotal());
    }


}