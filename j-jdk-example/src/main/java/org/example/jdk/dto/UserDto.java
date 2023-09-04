package org.example.jdk.dto;

import org.example.jdk.annotation.InitSex;
import org.example.jdk.annotation.ValidateAge;

/**
 * ClassName: UserDto
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/4 10:16
 */
public class UserDto {
    private String username;
    @ValidateAge(min = 20, max = 35, value = 22)
    private int age;
    @InitSex(sex = InitSex.SEX_TYPE.MAN)
    private String sex;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
