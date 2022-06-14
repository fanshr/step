package com.fanshr.step.engine.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fanshr.step.engine.security.domain.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select distinct mark from security_role where id  in " +
            "(select role_id from map_role_user where user_id =#{id} )")
    Set<String> listRoleByUser(Integer id);
}
