package com.fanshr.step.engine.security.service.impl;

import com.fanshr.step.engine.security.entity.Role;
import com.fanshr.step.engine.security.mapper.RoleMapper;
import com.fanshr.step.engine.security.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
