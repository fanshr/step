package com.fanshr.step.engine.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanshr.step.engine.security.domain.entity.Role;
import com.fanshr.step.engine.security.dao.RoleMapper;
import com.fanshr.step.engine.security.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
