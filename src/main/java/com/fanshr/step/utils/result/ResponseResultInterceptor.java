package com.fanshr.step.utils.result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 *
 * 请求拦截器
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/4/30 11:32
 * @date : Modified at 2022/4/30 11:32
 */
@Slf4j
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {
    // 标记名称
    public static final String RESPONSE_RESULT_ANN = "RESPONSE-RESULT-ANN";

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        log.info("进入拦截器...");
        // 请求的方法
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            // 判断是否在类对象上加了注解
            final Method method = handlerMethod.getMethod();
            if (clazz.isAnnotationPresent(ResponseResult.class)) {
                // 设置请求返回体需要包装标记，向下传递，由ResponseBodyAdvice接口进行判断
                request.setAttribute(RESPONSE_RESULT_ANN,clazz.getAnnotation(ResponseResult.class));
            // 判断是否在方法上加了注解
            } else if (method.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(RESPONSE_RESULT_ANN,method.getAnnotation(ResponseResult.class));

            }
            
            // TODO: 异常处理，判断body是否为异常类，异常单独处理
        }
        // 默认会拦截所有@ResponseBody的方法
        return true;
    }
}
