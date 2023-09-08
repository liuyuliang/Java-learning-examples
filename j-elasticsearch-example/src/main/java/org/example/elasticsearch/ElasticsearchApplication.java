package org.example.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * ClassName: ElasticsearchApplication
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/8 10:55
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ElasticsearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }
}
