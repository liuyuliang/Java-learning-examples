package org.example.jdk.proxy._dynamic;

import org.example.jdk.proxy._static.UserService;
import org.example.jdk.proxy._static.UserServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: LogHandlerTest
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/5 13:35
 */
class LogHandlerTest {
    @Test
    public void test() {
        LogHandler logHandler = new LogHandler(new UserServiceImpl());
        UserService userService = (UserService) logHandler.bind();
        userService.update();
    }

}