package com.example.apache;

import jdk.jfr.StackTrace;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.jupiter.api.Test;

/**
 * ClassName: T
 * Description:<pre>
 *     StringEscapeUtils的主要功能就是为Java，Java Script，Html，XML进行转义与反转义。
 *
 * escapeJava(String input) / unescapeJava(String unionCodeString)
 * 将输入字符串转为unicode编码 / 将unicode字符串转为Utf-8格式的字符串
 * escapeHtml4(String input) / unescapeHtml4(String input)
 * 转义/反转义html脚本
 * escapeEcmaScript(String input) / unescapeEcmaScript(String input)
 * 转义/反转义js脚本
 * escapeXml(String input) / unescapeXml(String input)
 * 转义/反转义xml脚本
 *
 * 作者：lq木头
 * 链接：https://juejin.cn/post/6908348494122074119
 * 来源：稀土掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * </pre>
 *
 * @author Yuliang Lau
 * @date 2023/9/4 14:39
 */
public class StringEscapeUtilsTest {
    @Test
    public void escapeHtml4Test() {
        System.out.println(StringEscapeUtils.escapeHtml4("\"bread\" & \"butter\""));
    }
}
