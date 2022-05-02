package com.fanshr.step.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/4/30 20:36
 * @date : Modified at 2022/4/30 20:36
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    /**
     * Servlet 3.0 规范引入新特性，服务器启动时，调用 ServletContainerInitializer 的所有实现类的onStartup()方法
     * <p>
     * AbstractContextLoaderInitializer 的默认实现中，onStartup() 方法会调用 registerContextLoaderListener()
     * </p>
     * <p>
     * 在servlet容器启动时配置字符编码过滤器，处理中文乱码问题
     *
     * @param servletContext context
     * @throws ServletException 异常
     */
    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {


        //触发父类的onStartup, 其中已设置 servlet.setLoadOnStartup(1)
        super.onStartup(servletContext);

        // ServletRegistration servletRegistration = servletContext.getServletRegistration("dispatcher");
        // //1.创建字符集过滤器对象
        // CharacterEncodingFilter cef = new CharacterEncodingFilter();
        // //2.设置使用的字符集
        // cef.setEncoding("UTF-8");
        // //3.添加到容器（它不是ioc容器，而是ServletContainer）
        // FilterRegistration.Dynamic encodingFilter = servletContext.addFilter(
        //         "characterEncodingFilter", cef);
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("characterEncodingFilter",
                CharacterEncodingFilter.class);
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.setAsyncSupported(true);
        encodingFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD,
                DispatcherType.INCLUDE), false, "/*");


    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class,SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
