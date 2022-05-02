package com.fanshr.step.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/5/2 02:43
 * @date : Modified at 2022/5/2 02:43
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityInitializer(){
        // 无spring的情况下，传入超类处理，webInitializer 中已引入，此处可以不处理

        // super(SecurityConfig.class);

    }
}
