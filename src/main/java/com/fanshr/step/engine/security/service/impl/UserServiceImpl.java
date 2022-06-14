package com.fanshr.step.engine.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanshr.step.engine.security.domain.entity.User;
import com.fanshr.step.engine.security.dao.UserMapper;
import com.fanshr.step.engine.security.service.UserService;
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
