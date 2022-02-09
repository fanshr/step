package com.fanshr.step.dao;

import com.fanshr.step.BaseTest;
import com.fanshr.step.entity.InterviewCategory;
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
public class InterviewCategoryDaoTest extends BaseTest {
    @Autowired
    InterviewCategoryDao interviewCategoryDao;

    @Test
    public void testQueryInterviewCategoryList() {
        InterviewCategory interviewCategory = new InterviewCategory();
        List<InterviewCategory> interviewCategoryList = interviewCategoryDao.queryList(interviewCategory);
        System.out.println(interviewCategoryList);
        System.out.println("1====================");

        interviewCategory.setParentId(1);
        interviewCategoryList = interviewCategoryDao.queryList(interviewCategory);
        System.out.println(interviewCategoryList);
        System.out.println("2=================");

        interviewCategory.setParentId(null);
        interviewCategory.setId(1);
        interviewCategoryList = interviewCategoryDao.queryList(interviewCategory);
        System.out.println(interviewCategoryList);
        System.out.println("3===========================");


    }

    @Test
    public void testQueryById() {

        InterviewCategory interviewCategory = interviewCategoryDao.queryOne(1);
        System.out.println(interviewCategory);

    }

    @Test
    public void testInsertInterviewCategory() {
        InterviewCategory interviewCategory = new InterviewCategory();
        interviewCategory.setTitle("Java");
        interviewCategory.setDescription("基础理论知识");
        interviewCategory.setShowOrder(1.0);
        interviewCategory.setCreateAt(new Date());
        interviewCategory.setModifyAt(new Date());

        int effectedRow = interviewCategoryDao.insert(interviewCategory);
        Assert.assertEquals(1, effectedRow);
    }

    @Test
    public void testUpdateInterviewCategory() {
        InterviewCategory interviewCategory = new InterviewCategory();
        interviewCategory.setId(3);
        interviewCategory.setTitle("SpringMVC");
        interviewCategory.setDescription("框架");
        interviewCategory.setShowOrder(3.0);
        interviewCategory.setModifyAt(new Date());
        interviewCategory.setParentId(1);
        int effectedRow = interviewCategoryDao.update(interviewCategory);
        Assert.assertEquals(1, effectedRow);
    }

    @Test
    public void testDeleteInterviewCategory() {

        int effectedRow = interviewCategoryDao.delete(20L);
        Assert.assertEquals(1, effectedRow);

    }

    @Test
    public void testBatchDeleteInterviewCategory() {
        List<Integer> idList = new ArrayList<>();
        idList.add(33);
        idList.add(34);
        idList.add(35);
        idList.add(36);
        int effectedRow = interviewCategoryDao.batchDelete(idList);
        Assert.assertEquals(1,effectedRow);
    }
}

