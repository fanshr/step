package com.fanshr.step.engine.test.service;

import com.fanshr.step.engine.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/10 13:24
 * @date : Modified at 2022/2/10 13:24
 */
public class FieldTypeServiceTest extends BaseTest {
    @Autowired
    FieldTypeService fieldTypeService;

    @Test
    public void testFindByPage(){

        fieldTypeService.getList(1,5);

    }
}
