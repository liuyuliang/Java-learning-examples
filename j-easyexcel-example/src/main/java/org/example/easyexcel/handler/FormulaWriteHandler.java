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
public class FormulaWriteHandler implements CellWriteHandler {
    private int row;

    public FormulaWriteHandler(int row) {
        this.row = row;
    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<WriteCellData<?>> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {

        if ("统计数据".equals(writeSheetHolder.getSheetName())) {
            int rowIndex = cell.getRowIndex();
            if (rowIndex == 3) {
                //得到 A座（电）用电量统计(kWh)  统计行
                Row row = writeSheetHolder.getSheet().getRow(4);
                Cell cella = row.getCell(+cell.getColumnIndex());
                //获得列的第一个字母
                char ch = cell.getAddress().toString().charAt(0);
                cella.setCellFormula("SUM(" + ch + "3:" + ch + "4)");

            } else if (rowIndex == 8) {
//            B座（电）用电量统计(kWh)

                //  统计 B座（电）用电量统计(kWh)
                Row row9 = writeSheetHolder.getSheet().getRow(9);
                Cell BSumCell = row9.getCell(+cell.getColumnIndex());
                //获得列的第一个字母
                char ch = cell.getAddress().toString().charAt(0);
                BSumCell.setCellFormula("SUM(" + ch + "6:" + ch + "9)");


                //统计总用电量(kWh)
                Row row10 = writeSheetHolder.getSheet().getRow(10);
                Cell ABSumCell = row10.getCell(+cell.getColumnIndex());
                //获得列的第一个字母
                char ch2 = cell.getAddress().toString().charAt(0);
                ABSumCell.setCellFormula("SUM(" + ch + "5+" + ch + "10)");
            } else if (rowIndex == 19) {
//

                //统计总用电量(kWh)
                Row row20 = writeSheetHolder.getSheet().getRow(20);
                Cell BSumCell = row20.getCell(+cell.getColumnIndex());
                //获得列的第一个字母
                char ch = cell.getAddress().toString().charAt(0);
                BSumCell.setCellFormula("SUM(" + ch + "15:" + ch + "20)");


            }
        } else if ("A座".equals(writeSheetHolder.getSheetName())) {
            int rowIndex = cell.getRowIndex();
            if (rowIndex > 2) {
                Row row = writeSheetHolder.getSheet().getRow(rowIndex);
                Cell cell3 = row.getCell(3);
                int n = rowIndex + 1;
                cell3.setCellFormula("SUM(B" + n + ":C" + n + ")");

                Cell cell17 = row.getCell(17);
                cell17.setCellFormula("SUM(G" + n + ":Q" + n + ")");
            }
            //getColumnIndex  0 5  为合计 设置合计行的样式
            if (rowIndex == this.row && cell.getColumnIndex() != 0 && cell.getColumnIndex() != 5) {
                Workbook workbook = cell.getSheet().getWorkbook();
                CellStyle cellStyle = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                font.setColor(IndexedColors.RED.getIndex());
                cellStyle.setFont(font);
                cellStyle.setAlignment(HorizontalAlignment.CENTER);
                cell.setCellStyle(cellStyle);
            }

        }else if ("B座".equals(writeSheetHolder.getSheetName())) {
            int rowIndex = cell.getRowIndex();
            if (rowIndex > 2) {
                Row row = writeSheetHolder.getSheet().getRow(rowIndex);
                Cell cell3 = row.getCell(4);
                int n = rowIndex + 1;
                cell3.setCellFormula("SUM(B" + n + ":D" + n + ")");

                Cell cell17 = row.getCell(16);
                cell17.setCellFormula("SUM(H" + n + ":P" + n + ")");
            }
            //getColumnIndex  0 5  为合计 设置合计行的样式
            if (rowIndex == this.row && cell.getColumnIndex() != 0 && cell.getColumnIndex() != 6) {
                Workbook workbook = cell.getSheet().getWorkbook();
                CellStyle cellStyle = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                font.setColor(IndexedColors.RED.getIndex());
                cellStyle.setFont(font);
                cellStyle.setAlignment(HorizontalAlignment.CENTER);
                cell.setCellStyle(cellStyle);
            }
        }

    }
}
