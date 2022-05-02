package com.fanshr.step.api.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/4/30 21:01
 * @date : Modified at 2022/4/30 21:01
 */

@RestController
public class LoginController {

    @RequestMapping(value = "/login-success", produces = "text/plain;charset=utf-8")
    public String login() {
        return "登录成功";
    }



    @GetMapping(value = "/r/r1", produces = "text/html;charset=utf-8")
    public String r1() {


        return "访问r1资源";
    }

    @GetMapping(value = "/r/r2", produces = "text/html;charset=utf-8")
    public String r2() {


        return  "访问r2资源";
    }

    @GetMapping(value = "/test/t1", produces = "text/html;charset=utf-8")
    public String t1() {


        return  "访问t1资源";
    }
}
