package org.example.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: D
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/10/19 14:23
 */
@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated();
        http.formLogin(formLogin -> formLogin.loginPage("/login").permitAll().
                loginProcessingUrl("/login").defaultSuccessUrl("/index"));
        //
        http.csrf(csrf -> csrf.disable());
        http.logout(logout -> logout.invalidateHttpSession(true).deleteCookies());

        return http.build();
    }

    private Filter myFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws  ServletException, IOException {
                // 你的过滤逻辑...
                chain.doFilter(request, response);
            }
        };
    }
}
