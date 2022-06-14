package com.fanshr.step.engine.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanshr.step.engine.question.dao.TagDao;
import com.fanshr.step.engine.common.dto.Execution;
import com.fanshr.step.engine.question.domain.entity.QuestionTag;
import com.fanshr.step.engine.common.enums.StateEnum;
import com.fanshr.step.engine.question.service.QuestionTagService;
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
public class QuestionQuestionTagServiceImpl extends ServiceImpl<TagDao, QuestionTag> implements QuestionTagService {

    @Autowired
    private TagDao tagDao;


    @Override
    public List<QuestionTag> get(QuestionTag condition) {
        List<QuestionTag> questionTagList = null;
        questionTagList = tagDao.queryList(condition);

        return questionTagList;
    }


    @Override
    public QuestionTag get(Integer id) {

        return tagDao.queryOne(id);
    }

    @Override
    @Transactional
    public Execution add(QuestionTag questionTag) {
        if (questionTag != null) {
            questionTag.setCreateAt(new Date());
            questionTag.setModifyAt(new Date());

            try {
                int effectedRows = tagDao.insert(questionTag);
                if (effectedRows > 0) {
                    Execution execution = new Execution();
                    execution.setObj(questionTag);
                    return execution;
                } else {
                    return new Execution(StateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("添加标签失败：" + e.toString());
            }
        } else {
            return new Execution(StateEnum.PARAM_IS_EMPTY);
        }
    }

    @Override
    @Transactional
    public Execution modify(QuestionTag questionTag) {
        if (questionTag.getId() != null && questionTag.getId() != 0) {

            questionTag.setModifyAt(new Date());
            try {
                int effectedRows = tagDao.update(questionTag);
                if (effectedRows > 0) {
                    Execution execution = new Execution();
                    execution.setObj(questionTag);
                    return execution;
                } else {
                    return new Execution(StateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("更新标签信息失败：" + e.toString());
            }

        } else {
            return new Execution(StateEnum.PARAM_IS_EMPTY);
        }
    }

    @Override
    @Transactional
    public Execution remove(Integer id) {
        if (id > 0) {


            try {
                int effectedRows = tagDao.delete(id);
                if (effectedRows > 0) {
                    return new Execution(StateEnum.SUCCESS);
                } else {
                    return new Execution(StateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("删除标签信息失败：" + e.toString());
            }

        } else {
            return new Execution(StateEnum.PARAM_IS_EMPTY);
        }
    }

    @Override
    @Transactional
    public Execution multiRemove(List<Integer> idList) {
        if (idList != null && idList.size() > 0) {


            try {
                int effectedRows = tagDao.batchDelete(idList);
                if (effectedRows > 0) {
                    return new Execution(StateEnum.SUCCESS);
                } else {
                    return new Execution(StateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("删除标签信息失败：" + e.toString());
            }

        } else {
            return new Execution(StateEnum.PARAM_IS_EMPTY);
        }
    }
}
