package org.example.jdk.proxy._static;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: UserServiceProxyTest
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/5 11:39
 */
class UserServiceProxyTest {
    UserService userServiceImpl = new UserServiceImpl();
    UserService proxy = new UserServiceProxy(userServiceImpl);

    @Test
    void select() {
        proxy.select();
    }

    @Test
    void update() {
        proxy.update();
    }
}