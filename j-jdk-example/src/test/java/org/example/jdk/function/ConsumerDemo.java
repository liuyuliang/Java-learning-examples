package org.example.jdk.function;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/**
 * ClassName: ConsumerDemo
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/8/31 15:40
 */

public class ConsumerDemo {
    /**
     *  一个简单的平方计算
     */
    @Test
    public void testConsumer() {
        Consumer<Integer> square = x -> System.out.println("print square : " + x * x);
        square.accept(2);
    }
}
