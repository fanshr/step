package com.fanshr.step.engine.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fanshr.step.engine.security.domain.entity.RightType;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限类型表 Mapper 接口
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Mapper
public interface RightTypeMapper extends BaseMapper<RightType> {

}
