package org.example.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.net.PasswordAuthentication;

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
        http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                        /***用户角色*/
//                .requestMatchers("admin/api").hasRole("admin")
//                .requestMatchers("user/api").hasAnyRole("admin", "user")
                        /***用户权限*/
                        .requestMatchers("admin/api").hasAuthority("admin:api")//具有admin:api权限才能访问
                        .requestMatchers("user/api").hasAnyAuthority("admin:api", "user:api")//具有权限才能访问
                        .requestMatchers("/app/api").permitAll()//匿名访问
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
        );
        http.exceptionHandling(e -> e.accessDeniedPage("/noAuth"));
        http.formLogin(formLogin -> formLogin
                .loginPage("/login")
                .loginProcessingUrl("/login").permitAll()
                .defaultSuccessUrl("/index", true));
        //
        http.csrf(csrf -> csrf.disable());
        http.logout(logout -> logout.invalidateHttpSession(true).deleteCookies());

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        /***用户角色*/
//        UserDetails user1 = User.withUsername("admin").password("123456").roles("admin", "user").build();
//        UserDetails user2 = User.withUsername("user").password("123456").roles("user").build();
        /***用户权限*/
        UserDetails user1 = User.withUsername("admin").password("123456").authorities("admin:api", "user:api").build();
        UserDetails user2 = User.withUsername("user").password("123456").authorities("user:api").build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
