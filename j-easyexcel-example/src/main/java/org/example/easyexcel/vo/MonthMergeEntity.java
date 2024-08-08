package org.example.easyexcel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentLoopMerge;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName: MonthEntity
 * Description:
 *
 * @author Yuliang Lau
 * @date 2024/8/6 13:22
 */
@Getter
@Setter
public class MonthMergeEntity {
    @ContentLoopMerge(eachRow = 2, columnExtend = 2)
   @ExcelProperty("字符串")
    private String order;
    private double value;



}
