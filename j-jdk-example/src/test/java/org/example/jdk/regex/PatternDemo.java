package org.example.jdk.regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: PatternDemo
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/5 10:48
 */
public class PatternDemo {
    @Test
    public void pattern() {
        Pattern p = Pattern.compile("(?<=href=\").*(?=\">)");
        String str = "<li id=\"yaodian1\"><a class=\"yaodianlist\" target=\"_blank\" href=\"/Storelis/storelist!detail.html2?id=133488 \">阿凡达</a></li>";
        Matcher m = p.matcher(str);
        System.out.println(str);
        while (m.find())
            System.out.println(m.group());
    }
}
