package com.fanshr.step.engine.question.dao;

import com.alibaba.fastjson.JSON;
import com.fanshr.step.engine.BaseTest;
import com.fanshr.step.engine.question.entity.Tag;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/1 15:46
 * @date : Modified at 2022/2/1 15:46
 */
public class TagDaoTest extends BaseTest {
    @Autowired
    TagDao tagdao;

  @Test
  public void test26(){
      List<Tag> tags = tagdao.queryByIds("2,3,6");
      System.out.println(JSON.toJSONString(tags));

  }
}

