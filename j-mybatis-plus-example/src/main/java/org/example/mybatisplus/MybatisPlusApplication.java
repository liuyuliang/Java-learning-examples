package org.example.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: MybatisApplication
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/6 11:02
 */
@SpringBootApplication
@MapperScan("org.example.mybatisplus.mapper")
public class MybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }
}
