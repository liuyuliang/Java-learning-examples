package org.example.jdk.proxy.cglib;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: CglibLogInterceptorTest
 * Description:  jdk 17 运行不了，会报错
 *
 * @author Yuliang Lau
 * @date 2023/9/5 13:56
 */
class CglibLogInterceptorTest {
    @Test
    public void test() {
        CglibLogInterceptor cglibLogInterceptor = new CglibLogInterceptor();
        UserDao userDao = (UserDao) cglibLogInterceptor.getInstance(new UserDao());
        userDao.select();
    }

}