package com.fanshr.step.engine.security.service;


import com.fanshr.step.engine.BaseTest;
import com.fanshr.step.engine.security.domain.entity.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/5/1 03:25
 * @date : Modified at 2022/5/1 03:25
 */

public class RoleServiceTest extends BaseTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testInit(){
       Role role = new Role();
       role.setTitle("系统管理员");

        roleService.save(role);

    }
}
