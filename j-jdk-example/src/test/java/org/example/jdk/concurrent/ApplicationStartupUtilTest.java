package org.example.jdk.concurrent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: ApplicationStartupUtilTest
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/4 13:56
 */
class ApplicationStartupUtilTest {
@Test
    public  void  test(){
    boolean result = false;
    try {
        result = ApplicationStartupUtil.checkExternalServices();
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println("External services validation completed !! Result was :: "+ result);
}
}