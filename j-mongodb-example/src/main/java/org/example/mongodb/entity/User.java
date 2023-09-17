package org.example.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * ClassName: User
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/17 9:55
 */
@Data
@Document("User")
public class User {

    @Id
    private String id;
    private String name;
    private Integer age;
    private String email;
    private String createDate;
}

