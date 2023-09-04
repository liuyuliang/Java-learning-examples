package org.example.jdk.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: UrlOperationTest
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/4 18:05
 */
class UrlOperationTest {

    @Test
    void parseUrl() {
        UrlOperation urlOperation = new UrlOperation();
        String s = urlOperation.parseUrl("http://www.baidu.com");
        System.out.println(s);

    }
}