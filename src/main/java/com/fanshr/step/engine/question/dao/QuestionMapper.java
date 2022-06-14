package com.fanshr.step.engine.question.dao;

import com.fanshr.step.engine.question.domain.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 题目详情表 Mapper 接口
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-10
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

}
