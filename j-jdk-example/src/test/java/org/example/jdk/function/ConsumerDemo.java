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
     * 一个简单的平方计算
     */
    @Test
    public void testConsumer() {
        Consumer<Integer> square = x -> System.out.println("print square : " + x * x);
        square.accept(2);

    }

    /**
     * 定义3个Consumer并按顺序进行调用andThen方法，其中consumer2抛出NullPointerException。
     */
    @Test
    public void testAndThen() {
        Consumer<Integer> consumer1 = x -> System.out.println("first x : " + x);
        Consumer<Integer> consumer2 = x -> {
            System.out.println("second x : " + x);
            throw new NullPointerException("throw exception test");
        };
        Consumer<Integer> consumer3 = x -> System.out.println("third x : " + x);

        consumer1.andThen(consumer2).andThen(consumer3).accept(1);
    }
}
