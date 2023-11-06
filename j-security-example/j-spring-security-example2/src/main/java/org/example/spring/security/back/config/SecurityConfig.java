package org.example.spring.security.back.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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

public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests.requestMatchers("/login").permitAll()
                                .anyRequest().authenticated()
                );

        http.formLogin(formLogin -> formLogin
                .loginProcessingUrl("/login").successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("text/html;charset=UtF-8");
                        response.getWriter().write("loginok");
                        System.out.println(authentication.getPrincipal());
                        System.out.println(authentication.getAuthorities());
                        System.out.println(authentication.getCredentials());
                    }
                }).failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                        response.setContentType("text/html;charset=UtF-8");
                        response.getWriter().write("loginError");
                        exception.printStackTrace();
                    }
                })
        );
        //
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}
