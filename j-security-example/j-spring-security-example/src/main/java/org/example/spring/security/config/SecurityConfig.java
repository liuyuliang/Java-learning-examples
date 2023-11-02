package org.example.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

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
        http
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests.requestMatchers("/login").permitAll().anyRequest().authenticated()
                );

        http.formLogin(formLogin -> formLogin.loginPage("/login").
                loginProcessingUrl("/login").permitAll().defaultSuccessUrl("/out",true));
        //
        http.csrf(csrf -> csrf.disable());
        http.logout(logout -> logout.invalidateHttpSession(true).deleteCookies());

        return http.build();
    }

}
