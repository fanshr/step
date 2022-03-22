package com.fanshr.step.engine.question.service;

import com.fanshr.step.engine.common.dto.Execution;
import com.fanshr.step.engine.question.entity.QuestionItem;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/7 20:49
 * @date : Modified at 2022/2/7 20:49
 */
public interface QuestionItemService {


    public Execution list(QuestionItem condition, int current, int pageSize);

    Execution get(QuestionItem condition);
    QuestionItem get(Integer id);

    Execution add(QuestionItem questionItem);

    Execution modify(QuestionItem questionItem);
    Execution remove(Integer id);

    Execution multiRemove(List<Integer> idList);
}
