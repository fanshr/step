package com.fanshr.step.engine.question.service.impl;

import com.fanshr.step.engine.question.dao.CategoryDao;
import com.fanshr.step.engine.common.dto.Execution;
import com.fanshr.step.engine.question.entity.Category;
import com.fanshr.step.engine.common.enums.StateEnum;
import com.fanshr.step.engine.question.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/11 17:08
 * @date : Modified at 2021/11/11 17:08
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    @Override
    public List<Category> get(Category condition) {
        List<Category> categoryList = null;
        categoryList = categoryDao.queryList(condition);

        return categoryList;
    }


    @Override
    public Category get(Integer id) {

        return categoryDao.queryOne(id);
    }

    @Override
    @Transactional
    public Execution add(Category category) {
        if (category != null) {
            category.setCreateAt(new Date());
            category.setModifyAt(new Date());

            try {
                int effectedRows = categoryDao.insert(category);
                if (effectedRows > 0) {
                    Execution execution = new Execution();
                    execution.setObj(category);
                    return execution;
                } else {
                    return new Execution(StateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("添加类别失败：" + e.toString());
            }
        } else {


            return new Execution(StateEnum.EMPTY);
        }
    }

    @Override
    @Transactional
    public Execution modify(Category category) {
        if (category.getId() != null && category.getId() != 0) {

            category.setModifyAt(new Date());
            try {
                int effectedRows = categoryDao.update(category);
                if (effectedRows > 0) {
                    Execution execution = new Execution();
                    execution.setObj(category);
                    return execution;
                } else {
                    return new Execution(StateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("更新类别信息失败：" + e.toString());
            }

        } else {
            return new Execution(StateEnum.EMPTY);
        }
    }

    @Override
    @Transactional
    public Execution remove(Integer id) {
        if (id > 0) {


            try {
                int effectedRows = categoryDao.delete(id);
                if (effectedRows > 0) {
                    return new Execution(StateEnum.SUCCESS);
                } else {
                    return new Execution(StateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("删除类别信息失败：" + e.toString());
            }

        } else {
            return new Execution(StateEnum.EMPTY);
        }
    }

    @Override
    @Transactional
    public Execution multiRemove(List<Integer> idList) {
        if (idList != null && idList.size() > 0) {


            try {
                int effectedRows = categoryDao.batchDelete(idList);
                if (effectedRows > 0) {
                    return new Execution(StateEnum.SUCCESS);
                } else {
                    return new Execution(StateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("删除类别信息失败：" + e.toString());
            }

        } else {
            return new Execution(StateEnum.EMPTY);
        }
    }
}
