package com.fanshr.step.web;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/5 15:30
 * @date : Modified at 2022/2/5 15:30
 */
public class Test {
    public static void main(String[] args) {
        List<Long> idList = new ArrayList<>();
        idList.add(1L);
        idList.add(2L);
        idList.add(31L);
        idList.add(13L);
        idList.add(111L);
        idList.add(112321L);
        System.out.println(JSON.toJSONString(idList));
    }
}
