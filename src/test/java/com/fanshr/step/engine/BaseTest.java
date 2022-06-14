package com.fanshr.step.engine;

import com.fanshr.step.config.WebInitializer;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/6 22:13
 * @date : Modified at 2021/11/6 22:13
 */

// spring 整合 junit,junit启动时家子啊springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
// 告知JUnit spring配置文件
// @ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})

// @Transactional
@WebAppConfiguration
@Slf4j
@ContextConfiguration(classes = WebInitializer.class)
public class BaseTest {


}
