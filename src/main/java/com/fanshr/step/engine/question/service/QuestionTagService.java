package com.fanshr.step.engine.question.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fanshr.step.engine.common.dto.Execution;
import com.fanshr.step.engine.question.domain.entity.QuestionTag;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/11 17:08
 * @date : Modified at 2021/11/11 17:08
 */
public interface QuestionTagService extends IService<QuestionTag> {


    List<QuestionTag> get(QuestionTag condition);
    QuestionTag get(Integer id);

    Execution add(QuestionTag questionTag);

    Execution modify(QuestionTag questionTag);
    Execution remove(Integer id);

    Execution multiRemove(List<Integer> idList);


}
