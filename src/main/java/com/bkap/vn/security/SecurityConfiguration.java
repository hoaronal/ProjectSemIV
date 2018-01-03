package com.bkap.vn.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
@Order(1000)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    public static final String ADMIN = "ADMIN";
    public static final String MANAGER = "MANAGER";
    public static final String USER = "USER";

    @Autowired
    @Qualifier("customAdminDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    PersistentTokenRepository tokenRepository;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("123456").roles("USER").and()
                .withUser("admin").password("123456").roles("USER", "ADMIN");

        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        /*web.ignoring().antMatchers("/resources/**")
                .antMatchers("/resources/css/**")
                .antMatchers("/resources/editor/**")
                .antMatchers("/resources/bootstrap/**")
                .antMatchers("/resources/img/**")
                .antMatchers("/resources/js/**")
                .antMatchers("/resources/web/**")
                .antMatchers(HttpMethod.GET, "/WEB-INF/views/manager/**")
                .antMatchers(HttpMethod.GET, "/WEB-INF/views/template/**")
                .antMatchers(HttpMethod.GET, "/WEB-INF/views/web/**");*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/quan-tri/login", "/quan-tri/logout").permitAll();
        http.authorizeRequests().antMatchers("/quan-tri/**","/quan-tri/nguoi-dung/**", "/quan-tri/quan-tri-vien/**", "/quan-tri/phu-kien/**","/quan-tri/danh-muc/**","/quan-tri/qua-tang/**","/quan-tri/lich-su-he-thong/**","/quan-tri/tin-tuc/**","/quan-tri/don-hang/**","/quan-tri/san-pham/**","/quan-tri/tinh-thanh/**","/quan-tri/bao-cao/**","/quan-tri/giao-dich/**").hasAnyRole(ADMIN,USER,MANAGER);
        http.authorizeRequests().antMatchers("/quan-tri/nguoi-dung/cap-nhat/**","/quan-tri/quan-tri-vien/cap-nhat/**","/quan-tri/phu-kien/cap-nhat/**","/quan-tri/danh-muc/cap-nhat/**","/quan-tri/qua-tang/cap-nhat/**","/quan-tri/tin-tuc/cap-nhat/**","/quan-tri/don-hang/cap-nhat/**","/quan-tri/san-pham/cap-nhat/**","/quan-tri/tinh-thanh/cap-nhat/**","/quan-tri/giao-dich/cap-nhat/**").hasAnyRole(ADMIN,MANAGER);
        http.authorizeRequests().antMatchers("/quan-tri/nguoi-dung/them-moi/**","/quan-tri/quan-tri-vien/them-moi/**","/quan-tri/phu-kien/them-moi/**","/quan-tri/danh-muc/them-moi/**","/quan-tri/qua-tang/them-moi/**","/quan-tri/tin-tuc/them-moi/**","/quan-tri/don-hang/them-moi/**","/quan-tri/san-pham/them-moi/**","/quan-tri/tinh-thanh/them-moi/**","/quan-tri/giao-dich/them-moi/**").hasAnyRole(ADMIN,MANAGER);
        http.authorizeRequests().antMatchers("/quan-tri/nguoi-dung/xoa/*","/quan-tri/quan-tri-vien/xoa/**","/quan-tri/quyen/xoa/**","/quan-tri/phu-kien/xoa/**","/quan-tri/danh-muc/xoa/**","/quan-tri/qua-tang/xoa/**","/quan-tri/tin-tuc/xoa/**","/quan-tri/don-hang/xoa/**","/quan-tri/san-pham/xoa/**","/quan-tri/tinh-thanh/xoa/**","/quan-tri/giao-dich/xoa/**").hasRole(MANAGER);
        http.authorizeRequests()
                .and().formLogin().loginPage("/quan-tri/login")
                .loginProcessingUrl("/quan-tri/login").usernameParameter("account").passwordParameter("password").defaultSuccessUrl("/quan-tri").and()
                .rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
                .and().logout()
                .logoutUrl("/quan-tri/logout")
                .logoutSuccessUrl("/quan-tri/login?logout")
                .and().exceptionHandling()
                .accessDeniedPage("/quan-tri/access_denied");
        /*http.csrf().disable();*/


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
        PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
                "remember-me", userDetailsService, tokenRepository);
        return tokenBasedservice;
    }

    @Bean
    public AuthenticationTrustResolver getAuthenticationTrustResolver() {
        return new AuthenticationTrustResolverImpl();
    }

}
