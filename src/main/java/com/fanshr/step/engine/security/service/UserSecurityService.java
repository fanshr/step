package com.fanshr.step.engine.security.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fanshr.step.engine.security.domain.entity.User;
import com.fanshr.step.engine.security.dao.RoleMapper;
import com.fanshr.step.engine.security.dao.UserMapper;
import com.fanshr.step.engine.security.model.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Slf4j
@Service
public class UserSecurityService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username-->{}",username);
        if (username == null) {
            throw new UsernameNotFoundException("name is null!");
        }
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();

        wrapper.eq(StringUtils.isNotBlank(username), User::getUsername,
                username);

        User user = userMapper.selectOne(wrapper);


        if (user == null) {
            throw new UsernameNotFoundException("the account: " + username + " not found!");
        }

        // 基于资源
        Set<String> rightSet = getRightSet(user.getId());
        // if (rightSet.size() == 0) {
        //     throw new UsernameNotFoundException("no Right records found!");
        // }
        String[] rightArray = new String[rightSet.size()];
        rightSet.toArray(rightArray);
        // UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
        //         .password(user.getPassword())
        //         .authorities(rightArray).build();

        UserDetails userDetails = new UserPrincipal(user, rightSet);

        // 基于角色
        // Set<String> roles = roleMapper.listRoleByUser(user.getId());
        //
        // if(roles.size() == 0){
        //     throw new UsernameNotFoundException("no role records found!");
        // }
        //
        // List<GrantedAuthority> authorities = new ArrayList<>();
        // roles.forEach(r -> authorities.add(new SimpleGrantedAuthority("ROLE_" + r)));
        //
        // UserDetails userDetails2 = new User(username, user.getPassword(), user.getCanceled(),
        //         user.getNotExpired(), user.getCredentialsNotExpired(), user.getAccountNotLocked(),
        //         authorities);

        log.info("认证信息-->{}", userDetails);
        return userDetails;
    }

    /**
     * 获取权限标识集合
     *
     * @param id
     * @return
     */
    private Set<String> getRightSet(Integer id) {
        return userMapper.listRightByUser(id);
    }

    private Set<String> getRoleSet(Integer id) {
        return roleMapper.listRoleByUser(id);
    }
}
