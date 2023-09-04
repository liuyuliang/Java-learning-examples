package org.example.jdk.stream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 假设我们以索引x为中心,取前后各种5个数
 */
public class T2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(i);
        }
        int centerIndex = 7;  // 假设我们以索引7为中心

        System.out.println(getResult(list, centerIndex));
    }

    static List<Integer> getResult(List<Integer> list, int centerIndex) {
        if (centerIndex < 0 || centerIndex >= list.size()) {
            return list;
        }

        int startIndex = Math.max(0, centerIndex - 5);
        int endIndex = Math.min(list.size(), centerIndex + 5);
        List<Integer> result = list.subList(startIndex, endIndex);

        if (result.size() < 10) {
            result = list.stream()
                    .filter(i -> i >= Math.max(0, endIndex - 10) && i < Math.min(list.size(), Math.max(0, endIndex - 10) + 10))
                    .collect(Collectors.toList());
        }

        return result;
    }


    public <T> LinkedList<T> myMethod(LinkedList<T> list) {
        // 方法体
        // 假设从list中取出第一个元素返回
        return  list;
    }

    public void test2() {
        LinkedList<String> list = new LinkedList<>();
        list.add("asdfsdf");

    }
}