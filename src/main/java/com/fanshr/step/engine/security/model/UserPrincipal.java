package com.fanshr.step.engine.security.model;

import com.fanshr.step.engine.security.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/5/3 00:36
 * @date : Modified at 2022/5/3 00:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPrincipal implements UserDetails {
    private User user;
    private Set<String> rightMarkSet;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return rightMarkSet.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
