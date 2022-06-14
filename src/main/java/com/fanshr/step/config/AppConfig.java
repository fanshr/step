package com.fanshr.step.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/4/30 20:35
 * @date : Modified at 2022/4/30 20:35
 */

@Configuration

@EnableWebMvc
@ComponentScan(basePackages = "com.fanshr.step.*",
includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class AppConfig implements WebMvcConfigurer {




    // @Bean
    // public InternalResourceViewResolver viewResolver(){
    //     InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    //     viewResolver.setPrefix("/WEB-INF/view/");
    //     viewResolver.setSuffix(".jsp");
    //
    //     return viewResolver;
    // }

    /**
     * 配置视图解析器
     *
     * @param registry 注册表
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // jsp 默认实现，定制前缀和后缀
        registry.jsp("/WEB-INF/view/", ".jsp");

        // @Bean 引入
        // registry.viewResolver(viewResolver);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login");

        // registry.addViewController("/").setViewName("redirect:/login-view");
        // registry.addViewController("/login-view").setViewName("login");
    }


}
