package com.fanshr.step.engine.question.dao;

import com.fanshr.step.engine.BaseTest;
import com.fanshr.step.engine.question.entity.Category;
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
public class CategoryDaoTest extends BaseTest {
    @Autowired
    CategoryDao categoryDao;

    @Test
    public void testQueryInterviewCategoryList() {
        Category category = new Category();
        List<Category> categoryList = categoryDao.queryList(category);
        System.out.println(categoryList);
        System.out.println("1====================");

        category.setParentId(1);
        categoryList = categoryDao.queryList(category);
        System.out.println(categoryList);
        System.out.println("2=================");

        category.setParentId(null);
        category.setId(1);
        categoryList = categoryDao.queryList(category);
        System.out.println(categoryList);
        System.out.println("3===========================");


    }

    @Test
    public void testQueryById() {

        Category category = categoryDao.queryOne(1);
        System.out.println(category);

    }

    @Test
    public void testInsertInterviewCategory() {
        Category category = new Category();
        category.setTitle("Java");
        category.setDescription("基础理论知识");
        category.setShowOrder(1.0);
        category.setCreateAt(new Date());
        category.setModifyAt(new Date());

        int effectedRow = categoryDao.insert(category);
        Assert.assertEquals(1, effectedRow);
    }

    @Test
    public void testUpdateInterviewCategory() {
        Category category = new Category();
        category.setId(3);
        category.setTitle("SpringMVC");
        category.setDescription("框架");
        category.setShowOrder(3.0);
        category.setModifyAt(new Date());
        category.setParentId(1);
        int effectedRow = categoryDao.update(category);
        Assert.assertEquals(1, effectedRow);
    }

    @Test
    public void testDeleteInterviewCategory() {

        int effectedRow = categoryDao.delete(20L);
        Assert.assertEquals(1, effectedRow);

    }

    @Test
    public void testBatchDeleteInterviewCategory() {
        List<Integer> idList = new ArrayList<>();
        idList.add(33);
        idList.add(34);
        idList.add(35);
        idList.add(36);
        int effectedRow = categoryDao.batchDelete(idList);
        Assert.assertEquals(1,effectedRow);
    }
}

