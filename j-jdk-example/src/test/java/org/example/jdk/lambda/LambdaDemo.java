package org.example.jdk.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Demo
 * Description:
 * <pre>
 *     //1. lambda表达式的完整形态：有输入参数，有返回值，有代码块。
 * (int a, int b) -> {
 *  int c = a + b;
 *  return c;
 * }
 * //2. lambda表达式在某些情况也可以省略一部分
 *  //2.1 当代码块不需要返回值的 时候可以省略return语句
 *   (int a, int b) -> {
 *   int c = a + b;
 *  }
 *  //2.2 当代码块只有一句的时候可以省略大括号
 *   //并且这种情况默认返回这一句代码的执行结果
 *  (int a, int b) -> a + b; // 同1具有同样的作用
 *  //2.3 形参的类型可以根据函数式接口的里面的方法声明自行推断
 *   //可以省略形参类型
 *  (a, b) -> a + b; // 同1，2.2具有同样的效果
 *  //2.4 当只有一个参数的时候可以省略，形参的小括号
 *  a -> a * a;
 * </pre>
 *
 * @author Yuliang Lau
 * @date 2023/9/1 10:57
 */
public class LambdaDemo {
    @Test
    public void testThread() {
        Thread t2 = new Thread(() -> System.out.println("使用lambda方式创建线程"));
        t2.start();
    }

    /**
     * 类名::静态方法名 或者 类的实例::实例方法。
     */
    @Test
    public void Test2() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.forEach(String::toUpperCase); // 使用双冒号传递一个函数进来,
        list.forEach(s -> System.out.println(s.toUpperCase())); // 使用正常的lambda表达式
    }

}
