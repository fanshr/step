package com.fanshr.step.config.handler;

import com.alibaba.fastjson.JSON;
import com.fanshr.step.engine.common.utils.ResultUtil;
import com.fanshr.step.engine.security.model.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserPrincipal userPrincipal = (UserPrincipal) principal;
        // Map<String, Object> map = new HashMap<>();
        // map.put("code", 200);
        // map.put("msg", "登陆成功");
        // map.put("success", true);
        String json = JSON.toJSONString(ResultUtil.success(userPrincipal.getUser()));


        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
