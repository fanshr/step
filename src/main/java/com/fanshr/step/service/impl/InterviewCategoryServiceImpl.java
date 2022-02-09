package com.fanshr.step.service.impl;

import com.fanshr.step.dao.InterviewCategoryDao;
import com.fanshr.step.dto.Execution;
import com.fanshr.step.entity.InterviewCategory;
import com.fanshr.step.enums.StateEnum;
import com.fanshr.step.service.InterviewCategoryService;
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
public class InterviewCategoryServiceImpl implements InterviewCategoryService {

    @Autowired
    private InterviewCategoryDao interviewCategoryDao;


    @Override
    public List<InterviewCategory> get() {
        List<InterviewCategory> interviewCategoryList = null;
        ObjectMapper mapper = new ObjectMapper();
        InterviewCategory interviewCategoryCondition = new InterviewCategory();
        interviewCategoryCondition.setId(-1);
        interviewCategoryList = interviewCategoryDao.queryList(interviewCategoryCondition);

        return interviewCategoryList;
    }

    @Override
    public List<InterviewCategory> get2() {
        InterviewCategory interviewCategoryCondition = new InterviewCategory();
        interviewCategoryCondition.setDescription("ALLSECONF");
        List<InterviewCategory> interviewCategoryList =
                interviewCategoryDao.queryList(interviewCategoryCondition);
        return interviewCategoryList;

    }

    @Override
    public List<InterviewCategory> get2(Integer parentId) {
        InterviewCategory interviewCategoryCondition = new InterviewCategory();
        interviewCategoryCondition.setParentId(parentId);
        List<InterviewCategory> interviewCategoryList =
                interviewCategoryDao.queryList(interviewCategoryCondition);

        return interviewCategoryList;
    }

    @Override
    public InterviewCategory get(Integer id) {

        return interviewCategoryDao.queryOne(id);
    }

    @Override
    @Transactional
    public Execution add(InterviewCategory interviewCategory) {
        if (interviewCategory != null) {
            interviewCategory.setCreateAt(new Date());
            interviewCategory.setModifyAt(new Date());

            try {
                int effectedRows = interviewCategoryDao.insert(interviewCategory);
                if (effectedRows > 0) {
                    Execution execution = new Execution();
                    execution.setObj(interviewCategory);
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
    public Execution modify(InterviewCategory interviewCategory) {
        if (interviewCategory.getId() != null && interviewCategory.getId() != 0) {

            interviewCategory.setModifyAt(new Date());
            try {
                int effectedRows = interviewCategoryDao.update(interviewCategory);
                if (effectedRows > 0) {
                    Execution execution = new Execution();
                    execution.setObj(interviewCategory);
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
                int effectedRows = interviewCategoryDao.delete(id);
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
                int effectedRows = interviewCategoryDao.batchDelete(idList);
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
