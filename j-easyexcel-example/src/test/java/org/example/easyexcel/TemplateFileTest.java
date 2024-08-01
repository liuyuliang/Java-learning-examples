package org.example.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import org.example.easyexcel.vo.Person;
import org.example.easyexcel.vo.StaffSalaryEntity;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
                // 指定模板
                .withTemplate(templateFilePath)
                .build();

        WriteSheet sheet = EasyExcel.writerSheet().build();

        // 获取员工工资数据
        List<StaffSalaryEntity> staffSalaryEntities = getStaffSalaryEntities();

        FillConfig fillConfig = FillConfig.builder()
                // 开启填充换行
                .forceNewRow(true)
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
}
