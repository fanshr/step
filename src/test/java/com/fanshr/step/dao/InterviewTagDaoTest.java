package com.fanshr.step.dao;

import com.alibaba.fastjson.JSON;
import com.fanshr.step.BaseTest;
import com.fanshr.step.entity.InterviewCategory;
import com.fanshr.step.entity.InterviewTag;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/1 15:46
 * @date : Modified at 2022/2/1 15:46
 */
public class InterviewTagDaoTest extends BaseTest {
    @Autowired
    InterviewTagDao interviewTagdao;

  @Test
  public void test26(){
      List<InterviewTag> interviewTags = interviewTagdao.queryByIds("2,3,6");
      System.out.println(JSON.toJSONString(interviewTags));

  }
}

