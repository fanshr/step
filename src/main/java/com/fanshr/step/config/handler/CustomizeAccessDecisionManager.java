package com.fanshr.step.config.handler;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/5/1 13:51
 * @date : Modified at 2022/5/1 13:51
 */
@Component
public class CustomizeAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if(authentication == null){
            throw new AccessDeniedException("permission denied");
        }

        //当前用户拥有的权限集合
        List<String> rightMarkList = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        //访问路径所需要的权限集合
        List<String> configList = configAttributes.stream().map(ConfigAttribute::getAttribute).collect(Collectors.toList());
        for (String rightMark : rightMarkList){
            if(configList.contains(rightMark)){
                return;
            }
        }
        throw new AccessDeniedException("permission denied");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
