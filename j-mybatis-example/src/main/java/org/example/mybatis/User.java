package org.example.mybatis;

import java.io.Serializable;

/**
* 
* @TableName user
*/
public class User implements Serializable {


    private Integer id;

    private String userName;

    private String password;

    /**
    * 
    */
    private void setId(Integer id){
    this.id = id;
    }

    /**
    * 
    */
    private void setUserName(String userName){
    this.userName = userName;
    }

    /**
    * 
    */
    private void setPassword(String password){
    this.password = password;
    }


    /**
    * 
    */
    private Integer getId(){
    return this.id;
    }

    /**
    * 
    */
    private String getUserName(){
    return this.userName;
    }

    /**
    * 
    */
    private String getPassword(){
    return this.password;
    }

}
