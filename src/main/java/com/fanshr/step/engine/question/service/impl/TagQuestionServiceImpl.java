package com.fanshr.step.engine.question.service.impl;

import com.fanshr.step.engine.question.domain.entity.TagQuestion;
import com.fanshr.step.engine.question.dao.TagQuestionMapper;
import com.fanshr.step.engine.question.service.TagQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签与问题映射表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Service
public class TagQuestionServiceImpl extends ServiceImpl<TagQuestionMapper, TagQuestion> implements TagQuestionService {

}
