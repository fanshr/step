package com.fanshr.step.engine.core.dao;

import com.fanshr.step.engine.core.domain.entity.Language;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统语言可选表 Mapper 接口
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Mapper
public interface LanguageMapper extends BaseMapper<Language> {

}
