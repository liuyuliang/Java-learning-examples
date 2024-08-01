package org.example.easyexcel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName: Person
 * Description:
 *
 * @author Yuliang Lau
 * @date 2024/8/1 9:13
 */
@Getter
@Setter
public class Person {
    @ExcelProperty("用户ID")
    private String id;
    private String name;
    private int age;
    private String sex;
    private String birthday;
}
