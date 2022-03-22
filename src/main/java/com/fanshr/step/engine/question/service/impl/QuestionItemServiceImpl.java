package com.fanshr.step.engine.question.service.impl;

import com.fanshr.step.engine.question.dao.QuestionItemDao;
import com.fanshr.step.engine.common.dto.Execution;
import com.fanshr.step.engine.question.entity.QuestionItem;
import com.fanshr.step.engine.common.enums.StateEnum;
import com.fanshr.step.engine.question.service.QuestionItemService;
import com.fanshr.step.engine.common.utils.PageUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
public class QuestionItemServiceImpl implements QuestionItemService {
    @Autowired
    QuestionItemDao questionItemDao;


    @Override
    public Execution list(QuestionItem condition, int current, int pageSize) {
        PageHelper.startPage(current,pageSize);
        Page<QuestionItem> page = questionItemDao.list(condition);
        if (page.getResult() != null) {
            return new Execution(page.getResult(), page.getTotal());
        }else {
            return new Execution(StateEnum.INNER_ERROR);
        }
    }

    @Override
    public Execution get(QuestionItem condition) {
        List<QuestionItem> questionItemList = questionItemDao.list(condition);
        int count = questionItemDao.queryCount(condition);
        if (questionItemList != null) {
            return new Execution(questionItemList, count);
        } else {
            return new Execution(StateEnum.INNER_ERROR);
        }
    }





    @Override
    public QuestionItem get(Integer id) {
        return questionItemDao.queryOne(id);
    }

    @Override
    @Transactional
    public Execution add(QuestionItem questionItem) {
        if (questionItem == null) {
            return new Execution(StateEnum.EMPTY);
        }

        try {
            questionItem.setCreateAt(new Date());
            questionItem.setModifyAt(new Date());
            int effectedRows = questionItemDao.insert(questionItem);
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
    public Execution modify(QuestionItem questionItem) {
        if (questionItem == null) {
            return new Execution(StateEnum.EMPTY);
        }

        try {
            questionItem.setModifyAt(new Date());
            int effectedRows = questionItemDao.update(questionItem);
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
            int effectedRows = questionItemDao.delete(id);
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
            int effectedRows = questionItemDao.batchDelete(idList);
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
