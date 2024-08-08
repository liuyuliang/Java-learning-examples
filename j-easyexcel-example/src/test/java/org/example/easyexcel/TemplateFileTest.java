package org.example.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.enums.WriteDirectionEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.merge.LoopMergeStrategy;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Workbook;
import org.example.easyexcel.handler.CustomCellWriteHandler;
import org.example.easyexcel.handler.FormulaWriteHandler;
import org.example.easyexcel.handler.StyleCopyWriteHandler;
import org.example.easyexcel.vo.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * ClassName: TemplateFileTest
 * Description:
 *
 * @author Yuliang Lau
 * @date 2024/8/1 9:41
 */
public class TemplateFileTest {
    /**
     * 通过模板写入数据
     */
    @Test
    public void writeTemplateFile() {

        String templateFileName = "E:\\excel\\模板.xls"; // 确保使用正确的文件扩展名
        String fileName = "E:\\excel\\templateWrite" + System.currentTimeMillis() + ".xls";

        // 创建写入对象
        ExcelWriter excelWriter = EasyExcel.write(new File(fileName))
                .registerWriteHandler(new CustomCellWriteHandler())
                .withTemplate(new File(templateFileName))
                .build();

        try {
            // 创建一个空的List表示没有标题
            List<String> emptyTitleList = new ArrayList<>();
            // 第一个sheet页
            WriteSheet writeSheet1 = EasyExcel.writerSheet("上海").build();
            List<Person> data1 = data(); // 确保data()方法返回List<Person>类型
            excelWriter.write(data1, writeSheet1);

            // 第二个sheet页
            WriteSheet writeSheet2 = EasyExcel.writerSheet("北京").build();
            List<Person> data2 = data(); // 可以为不同的sheet提供不同的数据
            excelWriter.write(data2, writeSheet2);

        } finally {
            // 关闭写入对象
            excelWriter.finish();
        }
    }

    /**
     * 案例一：工资表
     */
    @Test
    public void salaryList() {
        // 模板文件路径
        String templateFilePath = "E:\\excel\\填充模板.xls";
        // 输出文件路径
        String outFilePath = "E:\\excel\\sa.xls";

        // 创建 ExcelWriter 实例
        ExcelWriter writer = EasyExcel
                // 写入到
                .write(outFilePath)
                .registerWriteHandler(new CustomCellWriteHandler())
                // 指定模板

                .withTemplate(templateFilePath)
                .build();

        WriteSheet sheet = EasyExcel.writerSheet().build();

        // 获取员工工资数据
        List<StaffSalaryEntity> staffSalaryEntities = getStaffSalaryEntities();

        FillConfig fillConfig = FillConfig.builder()
                // 开启填充换行
                .forceNewRow(true)
                .autoStyle(false)
                .build();

        // 执行填充操作
        writer.fill(staffSalaryEntities, fillConfig, sheet);

        // 结束
        writer.finish();
    }

    public List<StaffSalaryEntity> getStaffSalaryEntities() {
        List<StaffSalaryEntity> list = new ArrayList<>();

        list.add(StaffSalaryEntity.builder()
                .name("米大傻")
                .post("开发")
                .mouthSalary(new BigDecimal(1320))
                .hourSalary(new BigDecimal("7.59"))
                .shouldAttend(21.0)
                .actualAttend(21.0)
                .overtime(21.0)
                .weekOvertime(8.0)
                .holiday(0.0)
                .normalSalary(new BigDecimal(1320))
                .overtimeSalary(new BigDecimal("238.97"))
                .weekOvertimeSalary(new BigDecimal("242.76"))
                .holidaySalary(new BigDecimal(0))
                .postSubsidy(new BigDecimal(0))
                .award(new BigDecimal(20))
                .deduction(new BigDecimal(0))
                .social(new BigDecimal("113.6"))
                .shouldSalary(new BigDecimal("1688.12"))
                .selfTax(new BigDecimal(0))
                .actualSalary(new BigDecimal("1688.1"))
                .build());


        list.add(StaffSalaryEntity.builder()
                .name("曹大力")
                .post("店长")
                .mouthSalary(new BigDecimal(13200))
                .hourSalary(new BigDecimal("7.59"))
                .shouldAttend(21.0)
                .actualAttend(21.0)
                .overtime(21.0)
                .weekOvertime(8.0)
                .holiday(0.0)
                .normalSalary(new BigDecimal(1320))
                .overtimeSalary(new BigDecimal("238.97"))
                .weekOvertimeSalary(new BigDecimal("242.76"))
                .holidaySalary(new BigDecimal(0))
                .postSubsidy(new BigDecimal(0))
                .award(new BigDecimal(20))
                .deduction(new BigDecimal(0))
                .social(new BigDecimal("113.6"))
                .shouldSalary(new BigDecimal("13200.12"))
                .selfTax(new BigDecimal(0))
                .actualSalary(new BigDecimal("13200.1"))
                .build());

        list.add(StaffSalaryEntity.builder()
                .name("张大仙")
                .post("经理")
                .mouthSalary(new BigDecimal(13200))
                .hourSalary(new BigDecimal("7.59"))
                .shouldAttend(21.0)
                .actualAttend(21.0)
                .overtime(21.0)
                .weekOvertime(8.0)
                .holiday(0.0)
                .normalSalary(new BigDecimal(1320))
                .overtimeSalary(new BigDecimal("238.97"))
                .weekOvertimeSalary(new BigDecimal("242.76"))
                .holidaySalary(new BigDecimal(0))
                .postSubsidy(new BigDecimal(0))
                .deduction(new BigDecimal(0))
                .social(new BigDecimal("113.6"))
                .shouldSalary(new BigDecimal("13200.12"))
                .selfTax(new BigDecimal(0))
                .actualSalary(new BigDecimal("13200.1"))
                .build());

        return list;
    }


    private List<Person> data() {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person data = new Person();
            data.setName("姓名" + i);
            data.setAge(20);
            data.setId(i + "");
            data.setBirthday("2024-10-01");
            list.add(data);
        }
        return list;
    }

    @Test
    public void writeByModel() {
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("a.xls");
        String templateFile = "F:\\project\\IDEA_2023\\Java-learning-examples\\Java-learning-examples\\j-easyexcel-example\\src\\main\\resources\\a.xls";
        String fileName = "E:\\excel\\st\\a-" + System.currentTimeMillis() + ".xls";
        // 创建写入对象
        ExcelWriter excelWriter = EasyExcel.write(new File(fileName))
                .registerWriteHandler(new FormulaWriteHandler(6)) //在查询的几个月基础上加3
                .withTemplate(new File(templateFile))
                .build();
        //第一个sheet页  统计数据
        excelWriter = sheet1(excelWriter);

        //第二个sheet页  A座
        excelWriter = sheet2(excelWriter);
        excelWriter = sheet3(excelWriter);

        excelWriter.finish();

    }

    private ExcelWriter sheet3(ExcelWriter excelWriter) {
        {
            //第一个sheet页
            // 创建一个空的List表示没有标题
            List<String> emptyTitleList = new ArrayList<>();
            // 第一个sheet页
            WriteSheet writeSheet3 = EasyExcel.writerSheet("B座").build();
            HashMap map = new HashMap();
            map.put("title", "2024年1月-2024年6月");

// 将 Map 放入 List 中，因为 write 方法需要 List 作为参数
            List<Map<String, Object>> titleData = List.of(map);
//        excelWriter.write(titleData, writeSheet1);
            excelWriter.fill(map, writeSheet3);
            FillConfig fillConfig = FillConfig.builder().direction(WriteDirectionEnum.VERTICAL).autoStyle(false).build();

            List list = List.of("2024年1月", "2024年2月", "2024年3月","合计");
            List<MonthEntity> monthEntitiesList = initTilte(list);
            excelWriter.fill(new FillWrapper("month", monthEntitiesList), fillConfig, writeSheet3);

            //A
            Double[] a = {12.123213, 23434.2323, 983993.9939};

            List<Double> listA = new ArrayList<Double>(Arrays.asList(a));
            // 使用Java 8的Stream API求和（更现代、更灵活的方式）
            Double sum = listA.stream()
                    .mapToDouble(Double::doubleValue) // 这一步其实是多余的，因为已经是Integer类型了
                    .sum();
            listA.add(sum);

            List<MonthEntity> dataListA = initData(listA);
            excelWriter.fill(new FillWrapper("t1", dataListA), fillConfig, writeSheet3);
            excelWriter.fill(new FillWrapper("t2", dataListA), fillConfig, writeSheet3);
            excelWriter.fill(new FillWrapper("t3", dataListA), fillConfig, writeSheet3);
            excelWriter.fill(new FillWrapper("t4", dataListA), fillConfig, writeSheet3);
            excelWriter.fill(new FillWrapper("t5", dataListA), fillConfig, writeSheet3);
            excelWriter.fill(new FillWrapper("t6", dataListA), fillConfig, writeSheet3);
            return excelWriter;
        }
    }

    private ExcelWriter sheet2(ExcelWriter excelWriter) {
        //第一个sheet页
        // 创建一个空的List表示没有标题
        List<String> emptyTitleList = new ArrayList<>();
        // 第一个sheet页
        WriteSheet writeSheet2 = EasyExcel.writerSheet("A座").build();
        HashMap map = new HashMap();
        map.put("title", "2024年1月-2024年6月");

// 将 Map 放入 List 中，因为 write 方法需要 List 作为参数
        List<Map<String, Object>> titleData = List.of(map);
//        excelWriter.write(titleData, writeSheet1);
        excelWriter.fill(map, writeSheet2);
        FillConfig fillConfig = FillConfig.builder().direction(WriteDirectionEnum.VERTICAL).autoStyle(false).build();

        List list = List.of("2024年1月", "2024年2月", "2024年3月","合计");
        List<MonthEntity> monthEntitiesList = initTilte(list);
        excelWriter.fill(new FillWrapper("month", monthEntitiesList), fillConfig, writeSheet2);

        //A
        Double[] a = {12.123213, 23434.2323, 983993.9939};

        List<Double> listA = new ArrayList<Double>(Arrays.asList(a));
        // 使用Java 8的Stream API求和（更现代、更灵活的方式）
        Double sum = listA.stream()
                .mapToDouble(Double::doubleValue) // 这一步其实是多余的，因为已经是Integer类型了
                .sum();
        listA.add(sum);

        List<MonthEntity> dataListA = initData(listA);
        excelWriter.fill(new FillWrapper("s1", dataListA), fillConfig, writeSheet2);
        excelWriter.fill(new FillWrapper("s2", dataListA), fillConfig, writeSheet2);
        excelWriter.fill(new FillWrapper("s3", dataListA), fillConfig, writeSheet2);
        excelWriter.fill(new FillWrapper("s4", dataListA), fillConfig, writeSheet2);
        excelWriter.fill(new FillWrapper("s5", dataListA), fillConfig, writeSheet2);
        excelWriter.fill(new FillWrapper("s6", dataListA), fillConfig, writeSheet2);
        return excelWriter;
    }

    public ExcelWriter sheet1(ExcelWriter excelWriter) {
        //第一个sheet页
        // 创建一个空的List表示没有标题
        List<String> emptyTitleList = new ArrayList<>();
        // 第一个sheet页
        WriteSheet writeSheet1 = EasyExcel.writerSheet("统计数据").build();
        HashMap map = new HashMap();
        map.put("title", "test");

// 将 Map 放入 List 中，因为 write 方法需要 List 作为参数
        List<Map<String, Object>> titleData = List.of(map);
//        excelWriter.write(titleData, writeSheet1);
        excelWriter.fill(map, writeSheet1);
        FillConfig fillConfig = FillConfig.builder().direction(WriteDirectionEnum.HORIZONTAL).build();
        List list = List.of("2024年1月", "2024年2月", "2024年3月", "合计");
        List<MonthEntity> monthEntitiesList = initTilte(list);
        excelWriter.fill(new FillWrapper("month", monthEntitiesList), fillConfig, writeSheet1);
        //A
        Double[] a = {12.123213, 23434.2323, 983993.9939};

        List<Double> listA = new ArrayList<Double>(Arrays.asList(a));
        // 使用Java 8的Stream API求和（更现代、更灵活的方式）
        Double sum = listA.stream()
                .mapToDouble(Double::doubleValue) // 这一步其实是多余的，因为已经是Integer类型了
                .sum();
        listA.add(sum);

        List<MonthEntity> dataListA = initData(listA);
        excelWriter.fill(new FillWrapper("A1", dataListA), fillConfig, writeSheet1);
        excelWriter.fill(new FillWrapper("A2", dataListA), fillConfig, writeSheet1);
        excelWriter.fill(new FillWrapper("A3", dataListA), fillConfig, writeSheet1);
        excelWriter.fill(new FillWrapper("A4", dataListA), fillConfig, writeSheet1);
        excelWriter.fill(new FillWrapper("A5", dataListA), fillConfig, writeSheet1);
        excelWriter.fill(new FillWrapper("B1", dataListA), fillConfig, writeSheet1);
        excelWriter.fill(new FillWrapper("B2", dataListA), fillConfig, writeSheet1);
        excelWriter.fill(new FillWrapper("B3", dataListA), fillConfig, writeSheet1);
        excelWriter.fill(new FillWrapper("B4", dataListA), fillConfig, writeSheet1);
        excelWriter.fill(new FillWrapper("B5", dataListA), fillConfig, writeSheet1);
        excelWriter.fill(new FillWrapper("B6", dataListA), fillConfig, writeSheet1);
        excelWriter.fill(new FillWrapper("B7", dataListA), fillConfig, writeSheet1);
        return excelWriter;
    }

    public List<MonthEntity> initTilte(List<String> months) {
        List<MonthEntity> list = new ArrayList<>();
        for (String s : months) {
            MonthEntity monthEntity = new MonthEntity();
            monthEntity.setOrder(s);
            list.add(monthEntity);
        }
        return list;
    }
    public List<MonthMergeEntity> initTilte2(List<String> months) {
        List<MonthMergeEntity> list = new ArrayList<>();
        for (String s : months) {
            MonthMergeEntity monthEntity = new MonthMergeEntity();
            monthEntity.setOrder(s);
            list.add(monthEntity);
        }
        return list;
    }
    public List<MonthEntity> initData(List<Double> months) {
        List<MonthEntity> list = new ArrayList<>();
        for (double s : months) {
            MonthEntity monthEntity = new MonthEntity();
            monthEntity.setValue(s);
            list.add(monthEntity);
        }
        return list;
    }


}
