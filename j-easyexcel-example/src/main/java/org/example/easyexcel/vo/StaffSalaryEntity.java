package org.example.easyexcel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffSalaryEntity {

   @ExcelProperty( "姓名")
    private String name;

   @ExcelProperty( "职称")
    private String post;

   @ExcelProperty( "月薪")
    private BigDecimal mouthSalary;

   @ExcelProperty( "时薪")
    private BigDecimal hourSalary;

   @ExcelProperty( "应出勤天数")
    private Double shouldAttend;

   @ExcelProperty( "出勤天数")
    private Double actualAttend;

   @ExcelProperty( "平时加班时数")
    private Double overtime;

   @ExcelProperty( "周末加班时数")
    private Double weekOvertime;

   @ExcelProperty( "国假天数")
    private Double holiday;

   @ExcelProperty( "正班薪资")
    private BigDecimal normalSalary;

   @ExcelProperty( "平时加班薪资")
    private BigDecimal overtimeSalary;

   @ExcelProperty( "周末加班薪资")
    private BigDecimal weekOvertimeSalary;

   @ExcelProperty( "国假薪资")
    private BigDecimal holidaySalary;

   @ExcelProperty( "岗位津贴")
    private BigDecimal postSubsidy;

   @ExcelProperty( "全勤补贴")
    private BigDecimal fullAttendSubsidy;

   @ExcelProperty( "全勤奖")
    private BigDecimal award;

   @ExcelProperty( "事假缺勤扣款")
    private BigDecimal deduction;

   @ExcelProperty( "社保费用")
    private BigDecimal social;

   @ExcelProperty( "应得薪资")
    private BigDecimal shouldSalary;

   @ExcelProperty( "个人扣税")
    private BigDecimal selfTax;

   @ExcelProperty( "实发薪资")
    private BigDecimal actualSalary;

   @ExcelProperty( "员工签名")
    private BigDecimal sign;
}
