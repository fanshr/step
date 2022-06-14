package com.fanshr.step.config.handler;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fanshr.step.engine.security.domain.entity.RightDetail;
import com.fanshr.step.engine.security.dao.RightDetailMapper;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 拦截到当前的请求，并根据请求路径从数据库中查出当前资源路径需要哪些权限才能访问
 *
 * @author : LiuYJ
 * @date : Created at 2022/5/3 1:57
 * @date : Modified at 2022/5/3 1:57
 * @version : v1.0
 */
@Component
public class CustomizeFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Resource
    private RightDetailMapper rightDetailMapper;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //当前请求对象
        FilterInvocation fi = (FilterInvocation) object;
        if (isMatcherAllowedRequest(fi)) {
            //return null 表示允许访问，不做拦截
            return null ;
        }
        List<ConfigAttribute> configAttributes = getMatcherConfigAttribute(fi.getRequestUrl());
        //返回当前路径所需角色，如果没有则拒绝访问
        return !configAttributes.isEmpty() ? configAttributes : deniedRequest();
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class< ? > aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }

    /**
     * 获取当前路径所需要的角色
     * 从数据库获取处理
     * @param url 当前路径
     * @return 所需角色集合
     */
    private List<ConfigAttribute> getMatcherConfigAttribute(String url){

        LambdaQueryWrapper<RightDetail> wrapper = new LambdaQueryWrapper<>();

        // wrapper.eq(RightDetail::getUrl,url);
        // List<RightDetail> rightDetails = rightDetailMapper.selectList(wrapper);
        //
        // if (rightDetails == null) {
        //     return null;
        // }
        //
        // return rightDetails.stream()
        //         .map(rightDetail -> new SecurityConfig(rightDetail.getMark()))
        //         .collect(Collectors.toList());

        wrapper.select(RightDetail::getMark).eq(RightDetail::getUrl,url);
        List<Map<String, Object>> maps = rightDetailMapper.selectMaps(wrapper);
        return maps.stream()
                .map(map -> new SecurityConfig((String) map.get("mark")))
                .collect(Collectors.toList());
        // SecurityConfig.createList((String[]) attributeList.toArray());
    }

    /**
     * 判断当前请求是否在允许请求的范围内
     * @param fi 当前请求
     * @return 是否在范围中
     */
    private boolean isMatcherAllowedRequest(FilterInvocation fi){
        return allowedRequest().stream().map(AntPathRequestMatcher::new)
                .filter(requestMatcher -> requestMatcher.matches(fi.getHttpRequest()))
                .toArray().length > 0;
    }

    /**
     * @return 定义允许请求的列表
     */
    private List<String> allowedRequest(){
        return Arrays.asList("/login","/css/**","/fonts/**","/js/**","/scss/**","/img/**");
    }

    /**
     * @return 默认拒绝访问配置
     */
    private List<ConfigAttribute> deniedRequest(){
        return Collections.singletonList(new SecurityConfig("ROLE_DENIED"));
    }
}
