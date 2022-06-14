package com.fanshr.step.engine.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fanshr.step.engine.security.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select distinct mark from security_right_detail where right_id  in " +
            "(select right_id from map_role_right where role_id in" +
            "(select role_id from map_role_user where user_id =#{id} ))")
    Set<String> listRightByUser(Integer id);

}
