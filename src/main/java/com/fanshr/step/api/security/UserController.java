package com.fanshr.step.api.security;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fanshr.step.engine.common.dto.Condition;
import com.fanshr.step.engine.common.dto.PageBean;
import com.fanshr.step.engine.question.utils.StringUtil;
import com.fanshr.step.engine.security.domain.entity.User;
import com.fanshr.step.engine.security.service.UserService;
import com.fanshr.step.utils.UserVarify;
import com.fanshr.step.utils.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@RestController
@ResponseResult
@RequestMapping("/security/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("current")
    public User current() {
        return UserVarify.getCurrentUser();
    }

    @GetMapping("getAll")
    public List<User> getAll() {
        return userService.list();
    }
    @PostMapping("getList")
    public List<User> getList(@RequestBody User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtil.isNotBlank(user.getUsername()), User::getUsername, user.getUsername());

        return userService.list(wrapper);
    }

    @GetMapping("getOne")
    public User getOne(Integer id) {
        return userService.getById(id);
    }



    @PostMapping("queryAll")
    public PageBean<User> queryAll(@RequestBody Condition<User> condition) {
        Page<User> page = Page.of(condition.getCurrent(), condition.getPageSize());
        userService.page(page);
        return new PageBean<>(page.getRecords(), page.getTotal());
    }

    @PostMapping("queryList")
    public PageBean<User> queryList(@RequestBody Condition<User> condition) {

        Page<User> page = Page.of(condition.getCurrent(), condition.getPageSize());
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        User user = condition.getPayload();
        wrapper.eq(StringUtil.isNotBlank(user.getUsername()), User::getUsername, user.getUsername());

        userService.page(page,wrapper);
        return new PageBean<>(page.getRecords(), page.getTotal());
    }

    @PostMapping("add")
    public void add(@RequestBody User user) {

        userService.save(user);

    }

    @PostMapping("modify")
    public void modify(@RequestBody User user) {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper();
        wrapper.eq(user.getId() != null, User::getId, user.getId());
        wrapper.set(StringUtil.isNotBlank(user.getMobile()), User::getMobile, user.getMobile());
        userService.update(wrapper);
    }

    @PostMapping("remove")
    void remove(Integer id) {
        userService.removeById(id);
    }
}
