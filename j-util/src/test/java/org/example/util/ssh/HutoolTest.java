package org.example.util.ssh;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * ClassName: HutoolTest
 * Description:
 *
 * @author Yuliang Lau
 * @date 2024/1/29 16:03
 */
public class HutoolTest {
    @Test
    public void testDate(){
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
}
