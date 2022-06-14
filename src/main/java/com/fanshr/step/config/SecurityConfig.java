package com.fanshr.step.config;

import com.fanshr.step.config.handler.CustomizeAbstractSecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.annotation.Resource;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/4/30 22:12
 * @date : Modified at 2022/4/30 22:12
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Resource
    private AccessDeniedHandler accessDeniedHandler;
    @Resource
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Resource
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Resource
    private LogoutSuccessHandler logoutSuccessHandler;
    @Resource
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;
    @Resource
    private AccessDecisionManager accessDecisionManager;
    @Resource
    private FilterInvocationSecurityMetadataSource securityMetadataSource;
    @Resource
    private CustomizeAbstractSecurityInterceptor securityInterceptor;


    //
    // @Bean
    // public UserDetailsService userDetailsService(){
    //     return new UserSecurityService();
    // }

    /**
     * 密码编码器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        // return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }



    // TODO: 以下内容没写也会生效，，注意分析原理 查看默认加载机制
    /**
     * 配置身份认证来源，即用户、角色、权限关系
     * @return 封装身份认证提供者
     */
    // @Bean
    // public DaoAuthenticationProvider authenticationProvider() {
    //     DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    //     authenticationProvider.setUserDetailsService(userDetailsService());  //自定义的用户和角色数据提供者
    //     authenticationProvider.setPasswordEncoder(passwordEncoder()); //设置密码加密对象
    //     return authenticationProvider;
    // }
    //
    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth.authenticationProvider(authenticationProvider()); //设置身份认证提供者
    // }


    //
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
                // .passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.csrf().disable();
        http.cors().and().csrf().disable();
        // super.configure(http);
        http.authorizeRequests()
                .antMatchers("/question/item/getAll").hasAnyAuthority("p1")
                // 设置拦截校验范围，所有/r/**的请求必须认证通过
                .antMatchers("/question/item/**").authenticated()
                // 排除校验范围，除了/r/**，其它的请求可以访问
                .anyRequest().permitAll()

                // .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                //     @Override
                //     public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                //         o.setAccessDecisionManager(accessDecisionManager);//决策管理器
                //         o.setSecurityMetadataSource(securityMetadataSource);//安全元数据源
                //         return o;
                //     }
                // })
                .and().formLogin().permitAll()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and().logout().permitAll()
                .logoutSuccessHandler(logoutSuccessHandler).deleteCookies("JSESSIONID")
                .and().exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .maximumSessions(1).expiredSessionStrategy(sessionInformationExpiredStrategy)
        ;
        // http.addFilterBefore(securityInterceptor, FilterSecurityInterceptor.class);
    }


}
