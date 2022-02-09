package com.fanshr.step.service.impl;

import com.fanshr.step.dao.InterviewItemDao;
import com.fanshr.step.dto.Execution;
import com.fanshr.step.entity.InterviewItem;
import com.fanshr.step.enums.StateEnum;
import com.fanshr.step.service.InterviewItemService;
import com.fanshr.step.utils.PageCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/7 20:49
 * @date : Modified at 2022/2/7 20:49
 */
@Service
public class InterviewItemServiceImpl implements InterviewItemService {
    @Autowired
    InterviewItemDao interviewItemDao;

    @Override

    public Execution get(InterviewItem condition, int pageIndex, int pageSize) {
        int rowIndex = PageCalculator.calculatePageCount(pageIndex, pageSize);
        List<InterviewItem> interviewItemList = interviewItemDao.queryList(condition, rowIndex, pageSize);
        int count = interviewItemDao.queryCount(condition);
        if (interviewItemList != null) {
            return new Execution(interviewItemList, count);
        } else {
            return new Execution(StateEnum.INNER_ERROR);
        }
    }

    @Override
    public InterviewItem get(Integer id) {
        return interviewItemDao.queryOne(id);
    }

    @Override
    @Transactional
    public Execution add(InterviewItem interviewItem) {
        if (interviewItem == null) {
            return new Execution(StateEnum.EMPTY);
        }

        try {
            interviewItem.setCreateAt(new Date());
            interviewItem.setModifyAt(new Date());
            int effectedRows = interviewItemDao.insert(interviewItem);
            if (effectedRows > 0) {
                return new Execution();
            } else {
                return new Execution(StateEnum.INNER_ERROR);
            }
        } catch (Exception e) {
            throw new RuntimeException("add Error：" + e.getMessage());
        }


    }

    @Override
    @Transactional
    public Execution modify(InterviewItem interviewItem) {
        if (interviewItem == null) {
            return new Execution(StateEnum.EMPTY);
        }

        try {
            interviewItem.setModifyAt(new Date());
            int effectedRows = interviewItemDao.update(interviewItem);
            if (effectedRows > 0) {
                return new Execution();
            } else {
                return new Execution(StateEnum.INNER_ERROR);
            }
        } catch (Exception e) {
            throw new RuntimeException("modify Error：" + e.getMessage());
        }
    }

    @Override
    @Transactional
    public Execution remove(Integer id) {
        if (id == null || id <= 0) {
            return new Execution(StateEnum.EMPTY);
        }

        try {
            int effectedRows = interviewItemDao.delete(id);
            if (effectedRows <= 0) {
                return new Execution(StateEnum.INNER_ERROR);
            } else {
                return new Execution();
            }
        } catch (Exception e) {
            throw new RuntimeException("delete Error：" + e.getMessage());
        }
    }

    @Override
    @Transactional
    public Execution multiRemove(List<Integer> idList) {
        if (idList == null || idList.size() <= 0) {
            return new Execution(StateEnum.EMPTY);
        }
        try {
            int effectedRows = interviewItemDao.batchDelete(idList);
            if (effectedRows <= 0) {
                return new Execution(StateEnum.INNER_ERROR);
            } else {
                return new Execution();
            }
        } catch (Exception e) {
            throw new RuntimeException("delete Error：" + e.getMessage());
        }
    }
}
