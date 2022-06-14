package com.fanshr.step.engine.question.service;

import com.fanshr.step.engine.core.domain.vo.QuestionTagVo;
import com.fanshr.step.engine.question.domain.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fanshr.step.engine.question.domain.vo.QuestionVo;

import java.util.List;

/**
 * <p>
 * 题目详情表 服务类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
public interface QuestionService extends IService<Question> {

    List<QuestionTagVo> listByTagId(Integer tagId);

    QuestionVo info(Integer id);
}
