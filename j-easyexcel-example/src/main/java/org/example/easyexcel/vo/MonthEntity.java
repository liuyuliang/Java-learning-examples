package org.example.easyexcel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MonthEntity
 * Description:
 *
 * @author Yuliang Lau
 * @date 2024/8/6 13:22
 */
@Getter
@Setter
public class MonthEntity {
    @ExcelProperty
    private String order;
    private double value;



}
