package com.fanshr.step.utils;

import com.fanshr.step.engine.security.domain.entity.User;
import com.fanshr.step.engine.security.model.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/5/4 13:53
 * @date : Modified at 2022/5/4 13:53
 */
public class UserVarify {

    //获取当前用户信息
     public static User getCurrentUser(){

        //当前认证通过的用户身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //用户身份
        Object principal = authentication.getPrincipal();
        UserPrincipal userPrincipal = (UserPrincipal) principal;
        return  userPrincipal.getUser();
    }
}
