package org.example.jdk.stream;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * ClassName: StreamDemo
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/1 13:48
 */
public class StreamDemo {
    @Test
    public void test() {
//        从集合创建
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = numbers.stream();
//        从数组创建
        String[] names = {"Alice", "Bob", "Carol"};
        Stream<String> stream2 = Arrays.stream(names);
//        通过 Stream.of() 创建
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
//        通过 Stream.builder() 创建：
        Stream.Builder<String> builder = Stream.builder();
        builder.add("Apple");
        builder.add("Banana");
        builder.add("Cherry");
        Stream<String> stream4 = builder.build();
//        从 I/O 资源创建
        Path path = Paths.get("F:\\project\\IDEA_2023\\Java-learning-examples\\Java-learning-examples\\j-jdk-example\\src\\main\\resources\\stream.txt");
        try (Stream<String> stream5 = Files.lines(path)) {
            // 使用 stream 处理数据
            stream5.forEach(s -> System.out.println(s.trim()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
