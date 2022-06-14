package com.fanshr.step.engine.security.mapper;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fanshr.step.engine.BaseTest;
import com.fanshr.step.engine.security.dao.UserMapper;
import com.fanshr.step.engine.security.domain.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/5/4 01:50
 * @date : Modified at 2022/5/4 01:50
 */
public class UserMapperTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test43(){
        String username = "admin";
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();

        wrapper.eq(StringUtils.isNotBlank(username), User::getUsername,
                username);

        User user = userMapper.selectOne(wrapper);

        System.out.println("user-->"+ JSON.toJSONString(user));

    }
}
