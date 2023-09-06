package org.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName user
 */
@Data
@TableName("user")
public class User implements Serializable {


    private Integer id;

    private String userName;

    private String password;


}
