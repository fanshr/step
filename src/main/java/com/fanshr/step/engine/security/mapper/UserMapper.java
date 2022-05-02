package com.fanshr.step.engine.security.mapper;

import com.fanshr.step.engine.security.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}