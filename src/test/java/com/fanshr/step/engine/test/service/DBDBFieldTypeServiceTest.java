package com.fanshr.step.engine.test.service;

import com.fanshr.step.engine.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/10 13:24
 * @date : Modified at 2022/2/10 13:24
 */
public class DBDBFieldTypeServiceTest extends BaseTest {
    @Autowired
    DBFieldTypeService DBFieldTypeService;

    @Test
    public void testFindByPage(){

        DBFieldTypeService.getList(1,5);

    }

    @Test
    public void test25(){
        Map<String, String> test2 = new HashMap<>();
        test2.put("key1","");

        System.out.println("测试数据"+test2.get("key1")+"---"+ "".equals(test2.get("key1")));
    }
}
