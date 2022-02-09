package com.fanshr.step.service.impl;

import com.fanshr.step.dao.InterviewTagDao;
import com.fanshr.step.dto.Execution;
import com.fanshr.step.entity.InterviewTag;
import com.fanshr.step.enums.StateEnum;
import com.fanshr.step.service.InterviewTagService;
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
public class InterviewTagServiceImpl implements InterviewTagService {

    @Autowired
    private InterviewTagDao interviewTagDao;


    @Override
    public List<InterviewTag> get() {
        List<InterviewTag> interviewTagList = null;
        InterviewTag interviewTagCondition = new InterviewTag();
        interviewTagCondition.setId(-1);
        interviewTagList = interviewTagDao.queryList(interviewTagCondition);

        return interviewTagList;
    }


    @Override
    public InterviewTag get(Integer id) {

        return interviewTagDao.queryOne(id);
    }

    @Override
    @Transactional
    public Execution add(InterviewTag interviewTag) {
        if (interviewTag != null) {
            interviewTag.setCreateAt(new Date());
            interviewTag.setModifyAt(new Date());

            try {
                int effectedRows = interviewTagDao.insert(interviewTag);
                if (effectedRows > 0) {
                    Execution execution = new Execution();
                    execution.setObj(interviewTag);
                    return execution;
                } else {
                    return new Execution(StateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("添加标签失败：" + e.toString());
            }
        } else {
            return new Execution(StateEnum.EMPTY);
        }
    }

    @Override
    @Transactional
    public Execution modify(InterviewTag interviewTag) {
        if (interviewTag.getId() != null && interviewTag.getId() != 0) {

            interviewTag.setModifyAt(new Date());
            try {
                int effectedRows = interviewTagDao.update(interviewTag);
                if (effectedRows > 0) {
                    Execution execution = new Execution();
                    execution.setObj(interviewTag);
                    return execution;
                } else {
                    return new Execution(StateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("更新标签信息失败：" + e.toString());
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
                int effectedRows = interviewTagDao.delete(id);
                if (effectedRows > 0) {
                    return new Execution(StateEnum.SUCCESS);
                } else {
                    return new Execution(StateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("删除标签信息失败：" + e.toString());
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
                int effectedRows = interviewTagDao.batchDelete(idList);
                if (effectedRows > 0) {
                    return new Execution(StateEnum.SUCCESS);
                } else {
                    return new Execution(StateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("删除标签信息失败：" + e.toString());
            }

        } else {
            return new Execution(StateEnum.EMPTY);
        }
    }
}
