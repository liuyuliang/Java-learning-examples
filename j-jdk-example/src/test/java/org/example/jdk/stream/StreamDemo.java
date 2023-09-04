package org.example.jdk.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
    public void createStreamTest() {
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

    /**
     * 映射（Map）：map() 方法接受一个 Function 函数作为参数，用于对 Stream 中的元素进行映射转换。对每个元素应用函数后的结果会构成一个新的 Stream
     */
    @Test
    public void filterTest() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> filteredStream = stream.filter(n -> n % 2 == 0); // 过滤出偶数
        filteredStream.forEach(integer -> {
            System.out.println(integer);
        });
    }

    /**
     * 映射（Map）：map() 方法接受一个 Function 函数作为参数，用于对 Stream 中的元素进行映射转换。对每个元素应用函数后的结果会构成一个新的 Stream
     */
    @Test
    public void mapTest() {
        Stream<String> stream = Stream.of("apple", "banana", "cherry");
        Stream<Integer> mappedStream = stream.map(s -> s.length()); // 映射为单词长度
        mappedStream.forEach(integer -> {
            System.out.println(integer);
        });
    }

    /**
     * 扁平映射（FlatMap）：flatMap() 方法类似于 map() 方法，不同之处在于它可以将每个元素映射为一个流，并将所有流连接成一个流。这主要用于解决嵌套集合的情况
     */
    @Test
    public void flatMapTest() {
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );
        Stream<Integer> flattenedStream = nestedList.stream().flatMap(List::stream); // 扁平化为一个流
        flattenedStream.forEach(integer -> {
            System.out.println(integer);
        });
    }

    @Test
    public void limitTest() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> limitedStream = stream.limit(3); // 只保留前 3 个元素
        limitedStream.forEach(integer -> {
            System.out.println(integer);
        });
    }

    @Test
    public void skipTest() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> skippedStream = stream.skip(2); // 跳过前 2 个元素
        skippedStream.forEach(integer -> {
            System.out.println(integer);
        });
    }

    /**
     * 排序（Sorted）：sorted() 方法用于对 Stream 中的元素进行排序，默认是自然顺序排序。还可以提供自定义的 Comparator 参数来指定排序规则。
     */
    @Test
    public void sortedTest() {
        Stream<Integer> stream = Stream.of(5, 2, 4, 1, 3);
        Stream<Integer> sortedStream = stream.sorted(); // 自然顺序排序
        sortedStream.forEach(integer -> {
            System.out.println(integer);
        });
    }

    @Test
    public void distinctTest() {
        Stream<Integer> stream = Stream.of(1, 2, 2, 3, 3, 3);
        Stream<Integer> distinctStream = stream.distinct(); // 去重
        distinctStream.forEach(integer -> {
            System.out.println(integer);
        });
    }

    /**
     * 汇总（Collect）：collect() 方法用于将 Stream 中的元素收集到结果容器中，如 List、Set、Map 等。可以使用预定义的 Collectors 类提供的工厂方法来创建收集器，也可以自定义收集器。
     */
    @Test
    public void collectTest() {
        Stream<String> stream = Stream.of("apple", "banana", "cherry");
        List<String> collectedList = stream.collect(Collectors.toList()); // 收集为 List
        collectedList.stream().forEach(System.out::println);
    }

    /**
     * 归约（Reduce）：reduce() 方法用于将 Stream 中的元素依次进行二元操作，得到一个最终的结果。它接受一个初始值和一个 BinaryOperator 函数作为参数。
     */
    @Test
    public void reduceTest() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> sum = stream.reduce((a, b) -> a + b); // 对所有元素求和
        System.out.println(sum.get());
    }

    /**
     * 统计（Summary Statistics）：summaryStatistics() 方法可以从 Stream 中获取一些常用的统计信息，如元素个数、最小值、最大值、总和和平均值
     */
    @Test
    public void summaryStatisticsTest() {
        IntStream stream = IntStream.of(1, 2, 3, 4, 5);
        IntSummaryStatistics stats = stream.summaryStatistics();
        System.out.println("Count: " + stats.getCount());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Average: " + stats.getAverage());
    }

    /**
     * peek： peek是一个中间操作方法，它接受一个Consumer函数作为参数，对流中的每个元素执行该函数。与forEach不同的是，peek方法会返回一个新的流，该流中的元素和原始流中的元素相同。
     */
    @Test
    public void peekTest() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    /**
     * allMatch： allMatch 方法用于判断流中的所有元素是否都满足给定的条件。当流中的所有元素都满足条件时，返回 true；如果存在一个元素不满足条件，则返回 false。
     */
    @Test
    public void allMatchTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean allEven = numbers.stream()
                .allMatch(n -> n % 2 == 0);
        System.out.println(allEven); // 输出结果: false

    }

    /**
     * anyMatch 方法用于判断流中是否存在至少一个元素满足给定的条件。当流中至少有一个元素满足条件时，返回 true；如果没有元素满足条件，则返回 false。
     */
    @Test
    public void anyMatchTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean hasEven = numbers.stream()
                .anyMatch(n -> n % 2 == 0);
        System.out.println(hasEven); // 输出结果: true
        Assertions.assertTrue(hasEven);
    }

    /**
     * noneMatch： noneMatch 方法用于判断流中的所有元素是否都不满足给定的条件。当流中没有元素满足条件时，返回 true；如果存在一个元素满足条件，则返回 false。
     */
    @Test
    public void noneMatchTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean noneNegative = numbers.stream()
                .noneMatch(n -> n < 0);
        Assertions.assertTrue(noneNegative); // 输出结果: true
    }

    @Test
    public void findFirstTest() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Optional<String> first = names.stream()
                .findFirst();
        first.ifPresent(System.out::println); // 输出结果: Alice
    }

    @Test
    public void findAnyTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> any = numbers.stream()
                .filter(n -> n % 2 == 0)
                .findAny();
        any.ifPresent(System.out::println); // 输出结果: 2 或 4（取决于并行处理的结果）
    }

    @Test
    public void countTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        long count = numbers.stream()
                .count();
        System.out.println(count); // 输出结果: 5
    }

    @Test
    public void maxTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> max = numbers.stream()
                .max(Integer::compareTo);
        max.ifPresent(System.out::println); // 输出结果: 5
    }

    @Test
    public void minTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> min = numbers.stream()
                .min(Integer::compareTo);
        min.ifPresent(System.out::println); // 输出结果: 1
    }

    /**
     * <pre>在传统的顺序流中，所有的操作都是在单个线程上按照顺序执行的。而并行流则会将流的元素分成多个小块，并在多个线程上并行处理这些小块，
     * 最后将结果合并起来。这样可以充分利用多核处理器的优势，加快数据处理的速度。
     *
     * 要将一个顺序流转换为并行流，只需调用流的 parallel() 方法即可。</pre>
     */
    @Test
    public void parallelTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
                .parallel()
                .forEach(System.out::println);
    }

    @Test
    public void mapTest2() {
        List<String> list = Arrays.asList("apple", "banana", "orange", "grapefruit", "kiwi");
        List<String> resultList = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(resultList);
    }

}