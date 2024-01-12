package org.example.spring.entity;

import java.util.Arrays;

/**
 * ClassName: User
 * Description:
 *
 * @author Yuliang Lau
 * @date 2024/1/12 13:35
 */
public class User {
    private String id;
    private String name;
    private  String[] hobby;

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }
}
