package org.example.spring.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: SpirngSecurityApplication
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/10/19 13:57
 */
@SpringBootApplication
@MapperScan("org.example.spring.security.mapper")
public class SpirngSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpirngSecurityApplication.class, args);
    }
}
