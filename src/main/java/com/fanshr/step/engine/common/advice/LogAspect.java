package com.fanshr.step.engine.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 全局日志处理
 *
 * @author : LiuYJ
 * @date : Created at 2022/4/30 13:50
 * @date : Modified at 2022/4/30 13:50
 * @version : v1.0
 */
@Aspect
@Component
@Slf4j
public class LogAspect {


    @Pointcut("execution(public * com.fanshr.step.api..*.*(..))")
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("--------------------request---------------------");
        log.info("{}-{}-{}", request.getRemoteAddr(), request.getMethod(), request.getRequestURL().toString());
        Enumeration enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            log.info("name:[{}]-value:[{}]", name, request.getParameter(name));
        }
        if (!"GET".equals(request.getMethod())){
            String requestBodyStr = IOUtils.toString(request.getInputStream());
            log.info("body:{}",requestBodyStr);
        }


    }

    @AfterReturning(returning = "object", pointcut = "webLog()")
    public void doAfterReturning(Object object) throws Throwable {
        log.info("--------------------response---------------------");
        // 处理完请求，返回内容
        log.info("RESPONSE :{}", object);
        // log.info("花费时间 : " + (System.currentTimeMillis() - startTime.get()) + "毫秒");
    }
}
