package com.fanshr.step.engine.core.dao;

import com.fanshr.step.engine.core.domain.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 标签表 Mapper 接口
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

}
