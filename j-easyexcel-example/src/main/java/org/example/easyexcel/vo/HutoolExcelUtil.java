package org.example.easyexcel.vo;

import cn.hutool.poi.excel.ExcelWriter;
import org.apache.poi.ss.usermodel.*;


/**
 * ClassName: HutoolExcelUtil
 * Description:
 *
 * @author Yuliang Lau
 * @date 2024/8/8 10:33
 */
public class HutoolExcelUtil {
    /**
     * 单元格字体常用设置基础方法
     *
     * @param writer    ExcelWriter
     * @param fontName  字体名称(ex:微软雅黑、宋体、仿宋，需要底层操作系统支持)
     * @param fontSize  字体大小
     * @param color     字体颜色
     * @param underline 下划线样式
     * @param bold      是否加粗
     * @param strikeout 是否有删除线
     * @param italic    是否斜体
     * @return Font
     */
    public static Font createCellBaseFont(ExcelWriter writer, String fontName, short fontSize, short color,
                                          byte underline, boolean bold, boolean strikeout, boolean italic) {
        // 创建单元格Cell字体
        Font font = writer.createFont();
        // 设置字体名称(ex:微软雅黑、宋体、仿宋)
        font.setFontName(fontName);
        // 设置字体大小
        font.setFontHeightInPoints(fontSize);
        // 设置字体颜色
        font.setColor(color);
        // 设置字体是否加粗
        font.setBold(bold);
        // 设置字体下划线样式
        font.setUnderline(underline);
        // 设置是否有删除线
        font.setStrikeout(strikeout);
        // 设置是否斜体
        font.setItalic(italic);
        return font;
    }

    /**
     * 设置单元格的基础常用样式
     *
     * @param writer              Excel
     * @param font                字体
     * @param fillForegroundColor 是否填充背景
     * @param color               背景颜色 fillForegroundColor为true时生效
     * @param hAlign              水平对齐样式
     * @param vAlign              垂直对齐样式
     * @param wrapText            是否自动换行
     * @return CellStyle
     */
    public static CellStyle createCellBaseStyle(ExcelWriter writer, Font font, boolean fillForegroundColor,
                                                short color, HorizontalAlignment hAlign, VerticalAlignment vAlign, boolean wrapText) {
        // 创建单元格样式
        CellStyle style = writer.getWorkbook().createCellStyle();
        // 设置单元格内容的水平对齐方式，如左对齐、居中对齐、右对齐等。
        style.setAlignment(hAlign);
        // 设置单元格内容的垂直对齐方式，如上对齐、居中对齐、下对齐等。
        style.setVerticalAlignment(vAlign);
        // 设置字体
        style.setFont(font);
        // 是否设置背景色
        if (fillForegroundColor) {
            // style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
            // 设置单元格背景颜色
            style.setFillForegroundColor(color);
            // 设置填充模式
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        // 设置边框
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setWrapText(wrapText);
        return style;
    }

}
