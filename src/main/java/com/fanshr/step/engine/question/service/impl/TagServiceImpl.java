package com.fanshr.step.engine.question.service.impl;

import com.fanshr.step.engine.question.dao.TagDao;
import com.fanshr.step.engine.common.dto.Execution;
import com.fanshr.step.engine.question.entity.Tag;
import com.fanshr.step.engine.common.enums.StateEnum;
import com.fanshr.step.engine.question.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/11 17:08
 * @date : Modified at 2021/11/11 17:08
 */

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;


    @Override
    public List<Tag> get(Tag condition) {
        List<Tag> tagList = null;
        tagList = tagDao.queryList(condition);

        return tagList;
    }


    @Override
    public Tag get(Integer id) {

        return tagDao.queryOne(id);
    }

    @Override
    @Transactional
    public Execution add(Tag tag) {
        if (tag != null) {
            tag.setCreateAt(new Date());
            tag.setModifyAt(new Date());

            try {
                int effectedRows = tagDao.insert(tag);
                if (effectedRows > 0) {
                    Execution execution = new Execution();
                    execution.setObj(tag);
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
    public Execution modify(Tag tag) {
        if (tag.getId() != null && tag.getId() != 0) {

            tag.setModifyAt(new Date());
            try {
                int effectedRows = tagDao.update(tag);
                if (effectedRows > 0) {
                    Execution execution = new Execution();
                    execution.setObj(tag);
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
            return new Execution(StateEnum.EMPTY);
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
            return new Execution(StateEnum.EMPTY);
        }
    }
}
