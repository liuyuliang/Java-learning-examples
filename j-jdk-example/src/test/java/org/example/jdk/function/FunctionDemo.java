package org.example.jdk.function;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

/**
 * ClassName: FunctionDemo
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/1 10:21
 */
public class FunctionDemo {
    @Test
    public void testFunction() {
        //输出输入的数值
        Function function = (str) -> {
            return str;
        };
        System.out.println(function.apply("hello"));
    }
}
