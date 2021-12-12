package com.uit.danangfinancialtower.config;

import com.uit.danangfinancialtower.constants.SecurityConst;
import com.uit.danangfinancialtower.data.UserPrincipalService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

/**
 * WebSecurityConfig
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserPrincipalService userPrincipalService;
    
    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**",
                "/fonts/**", "/scss/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/**").permitAll()
            .antMatchers("/index", "/", "/map").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage(SecurityConst.LOGIN_PAGE)
            .permitAll()
            .defaultSuccessUrl(SecurityConst.DEFAULT_SUCCESS_URL, true)
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
            .rememberMe()
            .tokenValiditySeconds(
                (int) TimeUnit.DAYS.toSeconds(SecurityConst.TOKEN_VALIDATION_DURATION))
            .key(SecurityConst.TOKEN_VALIDATION_KEY)
            .rememberMeParameter("remember-me")
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout",
                "GET")) // https://docs.spring.io/spring-security/site/docs/4.2.12.RELEASE/apidocs/org/springframework/security/config/annotation/web/configurers/LogoutConfigurer.html
            .clearAuthentication(true)
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID", "remember-me")
            .logoutSuccessUrl(SecurityConst.DEFAULT_LOGOUT_SUCCESS_URL);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userPrincipalService);
        return provider;
    }
}
