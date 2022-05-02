package com.fanshr.step.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/4/30 20:36
 * @date : Modified at 2022/4/30 20:36
 */

@Configuration
@ImportResource({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml","classpath:spring/spring-web.xml"})
@ComponentScan(basePackages = "com.fanshr.step",
excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class RootConfig {
//  配置Controller之外的bean 比如 数据库连接池 事务管理器 业务bean
}
