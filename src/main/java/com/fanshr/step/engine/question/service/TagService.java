package com.fanshr.step.engine.question.service;

import com.fanshr.step.engine.common.dto.Execution;
import com.fanshr.step.engine.question.entity.Tag;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/11 17:08
 * @date : Modified at 2021/11/11 17:08
 */
public interface TagService {


    List<Tag> get(Tag condition);
    Tag get(Integer id);

    Execution add(Tag tag);

    Execution modify(Tag tag);
    Execution remove(Integer id);

    Execution multiRemove(List<Integer> idList);


}
