package com.fanshr.step.engine.security.service;

import com.fanshr.step.engine.BaseTest;
import com.fanshr.step.engine.security.domain.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/5/3 02:04
 * @date : Modified at 2022/5/3 02:04
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;
    @Test
    public void testInit(){

        List<User> userList = new ArrayList<>();
        for (int i = 1; i < 2; i++) {
            User user = new User();
            user.setUsername("admin");

            user.setPassword(BCrypt.hashpw("0000",BCrypt.gensalt()));
            user.setLastname("系统管理员");
            user.setMobile("15080081466");
            userList.add(user);

        }

        userService.saveBatch(userList);

    }


}
