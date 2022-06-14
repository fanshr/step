package com.fanshr.step.engine.locale.dao;

import com.fanshr.step.engine.locale.domain.entity.LocaleLabel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 标签国际化信息 Mapper 接口
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Mapper
public interface LocaleLabelMapper extends BaseMapper<LocaleLabel> {

}
