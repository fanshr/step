package com.fanshr.step.engine.security.service.impl;

import com.fanshr.step.engine.security.entity.User;
import com.fanshr.step.engine.security.mapper.UserMapper;
import com.fanshr.step.engine.security.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
