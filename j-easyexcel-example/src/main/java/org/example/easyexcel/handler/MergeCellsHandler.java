package org.example.easyexcel.handler;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.*;

import java.util.List;

/**
 * ClassName: FormulaWriteHandler
 * Description:
 *
 * @author Yuliang Lau
 * @date 2024/8/6 14:24
 */
public class MergeCellsHandler implements CellWriteHandler {
    private int row;

    public MergeCellsHandler(int row) {
        this.row = row;
    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<WriteCellData<?>> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
        if(cell.getColumnIndex()==0){
            //合并单元格

        }

    }
}
