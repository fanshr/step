package com.fanshr.step.engine.question.dao;

import com.fanshr.step.engine.question.domain.entity.TagQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 标签与问题映射表 Mapper 接口
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Mapper
public interface TagQuestionMapper extends BaseMapper<TagQuestion> {

}
