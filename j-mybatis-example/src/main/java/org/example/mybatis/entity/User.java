package org.example.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @TableName user
 */
@Data
public class User implements Serializable {


    private Integer id;

    private String userName;

    private String password;


}
