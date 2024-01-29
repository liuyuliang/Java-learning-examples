package org.example.util.ssh;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: HutoolTest
 * Description:
 *
 * @author Yuliang Lau
 * @date 2024/1/29 16:03
 */
public class HutoolTest {
    @Test
    public void testDate() {
        // 获取当前日期
        LocalDate today = LocalDate.now();

        // 计算前两个月的日期
        LocalDate twoMonthsAgo = today.minusMonths(2);

        // 定义日期格式为 yyyyMM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");

        // 将日期格式化为 yyyyMM 格式
        String formattedDate = twoMonthsAgo.format(formatter);

        // 输出结果
        System.out.println("前两个月的日期（格式为 yyyyMM）是: " + formattedDate);
    }

    @Test
    public void testMonth() {
        String startDate = "202201"+"01"; // 开始日期，格式为yyyyMM
        String endDate = "202305"+"01"; // 结束日期，格式为yyyyMM

        // 将字符串转换为LocalDate对象
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        // 计算两个日期之间的所有日期
        List<String> dates = getDates(start, end);

        // 输出结果
        for (String date : dates) {
            System.out.println(date);
        }
    }




    /**
     * 获取两个日期之间的所有日期
     */
    private static List<String> getDates(LocalDate start, LocalDate end) {
        List<String> dates = new ArrayList<>();
        while (!start.isAfter(end)) {
            dates.add(start.format(DateTimeFormatter.ofPattern("yyyyMM")));
            start = start.plus(1, ChronoUnit.MONTHS);
        }
        return dates;
    }
}
