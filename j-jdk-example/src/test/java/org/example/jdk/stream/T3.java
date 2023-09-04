package org.example.jdk.stream;

import java.util.ArrayList;
import java.util.List;
/**
 * 假设我们以索引x为中心,取前后各种5个数
 */
public class T3 {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        int centerIndex = 2;  // 假设我们以索引5为中心


        System.out.println( getResult(list, centerIndex));


    }

    static List getResult(List list, int centerIndex) {
        List<Integer> result = new ArrayList<>();
        if (centerIndex <= list.size()) {
            int startIndex = Math.max(0, centerIndex - 5);  // 取中心坐标前5条数据
            int endIndex = Math.min(list.size(), centerIndex + 5);  // 取中心坐标后5条数据
            result.addAll(list.subList(startIndex, endIndex));  // 取子数据
            if (result.size() < 10) {
                if (endIndex == list.size() - 1) {
                    result = list;
                } else {
                    result = list.subList(Math.max(0, endIndex - 10), Math.min(list.size(), Math.max(0, endIndex - 10) + 10));
                }
            }
        } else {
            result.addAll(list);  // 如果中心坐标无效，返回所有数据
        }
        return result;
    }
}


