package com.fanshr.step.engine.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanshr.step.engine.security.domain.entity.RoleUser;
import com.fanshr.step.engine.security.dao.RoleUserMapper;
import com.fanshr.step.engine.security.service.RoleUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限与角色映射表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Service
public class RoleUserServiceImpl extends ServiceImpl<RoleUserMapper, RoleUser> implements RoleUserService {

}
