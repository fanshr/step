package com.fanshr.step.engine.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fanshr.step.engine.security.domain.entity.RoleRight;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限与角色映射表 Mapper 接口
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Mapper
public interface RoleRightMapper extends BaseMapper<RoleRight> {

}