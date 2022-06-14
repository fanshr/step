package com.fanshr.step.engine.question.dao;

import com.alibaba.fastjson.JSON;
import com.fanshr.step.engine.BaseTest;
import com.fanshr.step.engine.question.domain.entity.QuestionItem;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/7 17:43
 * @date : Modified at 2022/2/7 17:43
 */
public class QuestionItemDaoTest extends BaseTest {
    @Autowired
    QuestionItemDao questionItemDao;

    @Test
    public void testQuery(){

        QuestionItem condition = new QuestionItem();
        condition.setCategoryId(18);
        // condition.setTags("4");
        List<QuestionItem> questionItemList = questionItemDao.queryList(condition,0,10);
        System.out.println(JSON.toJSONString(questionItemList));
        int count = questionItemDao.queryCount(condition);
        System.out.println("count---"+count);
    }

    @Test
    public void testInsert(){
        QuestionItem condition = new QuestionItem();
        condition.setTitle("多表关联关系的处理");
        condition.setDescription("测试描述");
        condition.setRemark("测试备注");
        condition.setAnswer("参考答案");
        condition.setCategoryId(18);
        condition.setTags("1,2,3");
        condition.setShowOrder(2.3);
        condition.setCreateAt(new Date());
        condition.setModifyAt(new Date());
        int effectedRows = questionItemDao.insert(condition);
        Assert.assertEquals(1,effectedRows);
    }


    @Test
    public void testUpdate(){
        QuestionItem condition = new QuestionItem();
        condition.setId(3);
        condition.setTitle("多表关联关系的处理1");
        condition.setDescription("测试描述1");
        condition.setRemark("测试备注1");
        condition.setAnswer("参考答案1");
        condition.setCategoryId(10);
        condition.setTags("2,3,4");
        condition.setShowOrder(1.3);
        condition.setCreateAt(new Date());
        condition.setModifyAt(new Date());
        int effectedRows = questionItemDao.update(condition);
        Assert.assertEquals(1,effectedRows);
    }


    @Test
    public void testRemark(){

        QuestionItem condition = new QuestionItem();
        QuestionItem questionItem = questionItemDao.queryOne(2501);
        String title = questionItem.getTitle();

        String remark = generateRemark(title);
        System.out.println(remark);
        // questionItem.setRemark();

    }

    @Test
    // public void test87(){
    //     QuestionItem condition = new QuestionItem();
    //     Page<QuestionItem> list = questionItemDao.list(condition);
    //     for (QuestionItem questionItem : list) {
    //         questionItem.setRemark(generateRemark(questionItem.getTitle()));
    //         questionItemDao.update(questionItem);
    //     }
    //
    //
    //
    //
    // }

    private String generateRemark(String title) {
        String pattern = "[^\\.\\d\\s]";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(title);
        int start = 0;
        if (matcher.find()) {
            start = matcher.start();


        }
        return title.substring(start).trim();

    }
}
