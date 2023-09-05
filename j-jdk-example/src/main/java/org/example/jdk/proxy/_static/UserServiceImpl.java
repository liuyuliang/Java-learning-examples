package org.example.jdk.proxy._static;

/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/5 11:22
 */
public class UserServiceImpl implements UserService {
    @Override
    public void select() {
        System.out.println("查询 selectById");
    }

    @Override
    public void update() {
        System.out.println("更新 update");
    }
}
