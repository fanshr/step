package com.fanshr.step.engine.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanshr.step.engine.question.dao.GraphQuestionMapper;
import com.fanshr.step.engine.question.domain.entity.GraphQuestion;
import com.fanshr.step.engine.question.service.GraphQuestionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 题目关联表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Service
public class GraphQuestionServiceImpl extends ServiceImpl<GraphQuestionMapper, GraphQuestion> implements GraphQuestionService {

}
