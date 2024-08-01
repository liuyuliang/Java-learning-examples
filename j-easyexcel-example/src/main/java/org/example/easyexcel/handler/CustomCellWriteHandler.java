package org.example.easyexcel.handler;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.*;

import java.util.List;

/**
 * ClassName: CustomCellWriteHandler
 * Description:
 *
 * @author Yuliang Lau
 * @date 2024/8/1 15:29
 */
public class CustomCellWriteHandler implements CellWriteHandler {


    private void setCellStyle(Cell cell, short colorIndex) {
        Workbook workbook = cell.getSheet().getWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        FillPatternType fillPatternType = FillPatternType.SOLID_FOREGROUND;
        cellStyle.setFillForegroundColor(colorIndex);
        cellStyle.setFillBackgroundColor(colorIndex);
        cellStyle.setFillPattern(fillPatternType);
        cell.setCellStyle(cellStyle);

//        CellStyle cellStyle = workbook.createCellStyle();
//        Font cellFont = workbook.createFont();
//        cellFont.setFontName("宋体");
//        cellStyle.setFont(cellFont);
//        cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
//        cellStyle.setFillPattern(FillPatternType.FINE_DOTS);
//        cellStyle.setAlignment(HorizontalAlignment.CENTER);// 水平居中
//        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
//        cell.setCellStyle(cellStyle);

    }



    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<WriteCellData<?>> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
        if (!isHead) { // 排除标题行
            int rowIndex = cell.getRowIndex();
            if (rowIndex % 2 == 0) {
                // 偶数行设置样式
                setCellStyle(cell, IndexedColors.GREY_25_PERCENT.getIndex());
            } else {
                // 奇数行设置样式
                setCellStyle(cell, IndexedColors.YELLOW.getIndex());
            }
        }
    }
}
