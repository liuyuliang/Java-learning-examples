package org.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

/**
 * @TableName user
 */

@TableName("user")
@Data
public class User implements Serializable {


    private Integer id;

    private String userName;

    private String password;


}
