package com.fanshr.step.engine.question.dao;

import com.fanshr.step.engine.question.domain.entity.GraphQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 题目关联表 Mapper 接口
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-10
 */
@Mapper
public interface GraphQuestionMapper extends BaseMapper<GraphQuestion> {

}
