package org.example.easyexcel.handler;


import com.alibaba.excel.write.handler.RowWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * ClassName: StyleCopyWriteHandler
 * Description:
 *
 * @author Yuliang Lau
 * @date 2024/8/6 12:55
 */
public class StyleCopyWriteHandler   implements RowWriteHandler {

    @Override
    public void afterRowDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Integer relativeRowIndex, Boolean isHead) {
        Sheet sheet = writeSheetHolder.getSheet();
        Cell templateCell = sheet.getRow(relativeRowIndex).getCell(0); // 假设我们要从第一列复制样式
        Cell currentCell = row.getCell(0); // 假设我们要应用样式到第一列
        // 复制样式
        currentCell.setCellStyle(templateCell.getCellStyle());
    }
}