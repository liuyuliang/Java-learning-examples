package org.example.jdk.proxy.cglib;

/**
 * ClassName: UserDao
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/5 13:51
 */
public class UserDao {
    public void select() {
        System.out.println("UserDao 查询 selectById");
    }

    public void update() {
        System.out.println("UserDao 更新 update");
    }
}
