package org.example.easyexcel;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.RowUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.example.easyexcel.vo.HutoolExcelUtil;
import org.junit.jupiter.api.Test;

/**
 * ClassName: HutoolExceTest
 * Description:
 *
 * @author Yuliang Lau
 * @date 2024/8/8 9:27
 */
public class HutoolExceTest {
    @Test
    public void excelTest() {
        ExcelWriter writer = ExcelUtil.getWriter("d:/" + System.currentTimeMillis() + "writeTest.xlsx");
        int rowIndex = 2;
        writer.renameSheet(0, "用电量统计表");

        Sheet sheet = writer.getSheet();

        //设置标题
        writer.merge(6, "2024年1月-2024年6月 首都图书馆A座、B座月度用电量统计表");
        Font titleFont = HutoolExcelUtil.createCellBaseFont(writer, "宋体", (short) 14, Font.COLOR_NORMAL, Font.U_NONE, true, false, false);
        CellStyle titleCellStyle = HutoolExcelUtil.createCellBaseStyle(writer, titleFont, false, Font.COLOR_NORMAL, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, false);
        sheet.getRow(0).getCell(0).setCellStyle(titleCellStyle);
        writer.merge(2, "A座用电量(kWh)");
        sheet.getRow(writer.getCurrentRow() - 1).getCell(0).setCellStyle(titleCellStyle);
        writer.merge(1, 1, 4, 6, "B座用电量(kWh)", false);
        sheet.getRow(writer.getCurrentRow() - 1).getCell(4).setCellStyle(titleCellStyle);


        Font totalFont = HutoolExcelUtil.createCellBaseFont(writer, "宋体", (short) 10, Font.COLOR_RED, Font.U_NONE, true, false, false);
        CellStyle totalCellStyle = HutoolExcelUtil.createCellBaseStyle(writer, totalFont, false, Font.COLOR_NORMAL, HorizontalAlignment.LEFT, VerticalAlignment.CENTER, false);
        // 设置边框
        CellStyle cellStyleBorder = writer.createCellStyle();
        ;
        cellStyleBorder.setBorderBottom(BorderStyle.THIN);
        cellStyleBorder.setBorderLeft(BorderStyle.THIN);
        cellStyleBorder.setBorderRight(BorderStyle.THIN);
        cellStyleBorder.setBorderTop(BorderStyle.THIN);
        //数值样式
        DataFormat dataFormat = writer.getWorkbook().createDataFormat();
        short formatIndex = dataFormat.getFormat("#,##0.00");
        cellStyleBorder.setDataFormat(formatIndex);


        Font totalVFont = HutoolExcelUtil.createCellBaseFont(writer, "宋体", (short) 10, Font.COLOR_RED, Font.U_NONE, true, false, false);
        CellStyle totalVCellStyle = HutoolExcelUtil.createCellBaseStyle(writer, totalFont, false, Font.COLOR_NORMAL, HorizontalAlignment.RIGHT, VerticalAlignment.CENTER, false);
        totalVCellStyle.setDataFormat(formatIndex);
        for (int i = 0; i < 6; i++) {
            //        A座用电量(kWh)
            writer.merge(rowIndex, rowIndex + 3, 0, 0, "2024年1月", false);


            Cell totalCellA = RowUtil.getOrCreateRow(sheet, rowIndex).createCell(1);
            totalCellA.setCellValue("总用电量：");
            totalCellA.setCellStyle(totalCellStyle);

            Cell totalCellAValue = RowUtil.getOrCreateRow(sheet, rowIndex).createCell(2);
            totalCellAValue.setCellValue(23432.23432);
            totalCellAValue.setCellStyle(totalVCellStyle);

            Cell c1 = RowUtil.getOrCreateRow(sheet, rowIndex + 1).createCell(1);
            c1.setCellValue("IT设备用电量：");
            c1.setCellStyle(cellStyleBorder);
            Cell c2 = RowUtil.getOrCreateRow(sheet, rowIndex + 1).createCell(2);
            c2.setCellValue(43.34343);
            c2.setCellStyle(cellStyleBorder);
            Cell c3 = RowUtil.getOrCreateRow(sheet, rowIndex + 2).createCell(1);
            c3.setCellValue("空气调节设备用电量：");
            c3.setCellStyle(cellStyleBorder);
            Cell c4 = RowUtil.getOrCreateRow(sheet, rowIndex + 2).createCell(2);
            c4.setCellValue(932399.2323);
            c4.setCellStyle(cellStyleBorder);
            Cell c5 = RowUtil.getOrCreateRow(sheet, rowIndex + 3).createCell(1);
            c5.setCellValue("配电及附属设备用电量：");
            c5.setCellStyle(cellStyleBorder);
            Cell c6 = RowUtil.getOrCreateRow(sheet, rowIndex + 3).createCell(2);
            c6.setCellValue(8333.38388324);
            c6.setCellStyle(cellStyleBorder);


            //B座
            writer.merge(rowIndex, rowIndex + 3, 4, 4, "2024年1月", false);


            Cell totalCellB = RowUtil.getOrCreateRow(sheet, rowIndex).createCell(5);
            totalCellB.setCellValue("总用电量：");
            totalCellB.setCellStyle(totalCellStyle);

            Cell totalCellBValue = RowUtil.getOrCreateRow(sheet, rowIndex).createCell(6);
            totalCellBValue.setCellValue(23432.23432);
            totalCellBValue.setCellStyle(totalVCellStyle);


            Cell c7 = RowUtil.getOrCreateRow(sheet, rowIndex + 1).createCell(5);
            c7.setCellValue("IT设备用电量：");
            c7.setCellStyle(cellStyleBorder);
            Cell c8 = RowUtil.getOrCreateRow(sheet, rowIndex + 1).createCell(6);
            c8.setCellValue(43.34343);
            c8.setCellStyle(cellStyleBorder);
            Cell c9 = RowUtil.getOrCreateRow(sheet, rowIndex + 2).createCell(5);
            c9.setCellValue("空气调节设备用电量：");
            c9.setCellStyle(cellStyleBorder);
            Cell c10 = RowUtil.getOrCreateRow(sheet, rowIndex + 2).createCell(6);
            c10.setCellValue(932399.2323);
            c10.setCellStyle(cellStyleBorder);
            Cell c11 = RowUtil.getOrCreateRow(sheet, rowIndex + 3).createCell(5);
            c11.setCellValue("配电及附属设备用电量：");
            c11.setCellStyle(cellStyleBorder);
            Cell c12 = RowUtil.getOrCreateRow(sheet, rowIndex + 3).createCell(6);
            c12.setCellValue(8333.38388324);
            c12.setCellStyle(cellStyleBorder);
            rowIndex += 4;

        }
        writer.merge(1, sheet.getLastRowNum(), 3, 3, "", false);
        Cell d2 = writer.getCell("D2");
        // 设置边框
        CellStyle d2Style = writer.createCellStyle();
//        IndexedColors.LIGHT_GREEN.index
//设置中间隔断单元格样式
        d2Style.setFillForegroundColor(new XSSFColor(new java.awt.Color(181, 198, 234), null));
        d2Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        d2.setCellStyle(d2Style);

        writer.setColumnWidth(0, 12);
        writer.setColumnWidth(1, 22);
        writer.setColumnWidth(2, 15);
        writer.setColumnWidth(3, 3);
        writer.setColumnWidth(4, 12);
        writer.setColumnWidth(5, 22);
        writer.setColumnWidth(6, 15);


        writer.close();

    }

}
