package com.fanshr.step.engine.core.dao;

import com.fanshr.step.engine.core.domain.entity.Keyword;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 关键保留字表 Mapper 接口
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Mapper
public interface KeywordMapper extends BaseMapper<Keyword> {

}
