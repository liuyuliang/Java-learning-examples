package org.example.jdk.proxy._static;

import java.util.Date;

/**
 * ClassName: UserServiceImpl2
 * Description: 代理类 UserServiceProxy
 *
 * @author Yuliang Lau
 * @date 2023/9/5 11:38
 */
public class UserServiceProxy implements UserService {
    private UserService target; // 被代理的对象

    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    @Override
    public void select() {
        before();
        target.select();    // 这里才实际调用真实主题角色的方法
        after();
    }

    @Override
    public void update() {
        before();
        target.update();    // 这里才实际调用真实主题角色的方法
        after();
    }

    private void before() {     // 在执行方法之前执行
        System.out.println(String.format("log start time [%s] ", new Date()));
    }

    private void after() {      // 在执行方法之后执行
        System.out.println(String.format("log end time [%s] ", new Date()));
    }
}
