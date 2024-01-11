package org.example.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring 示例
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/11/30 16:40
 */
@RestController
@RequestMapping("/")
public class DemoController {
    /**
     *  测试
     * @return
     */
    @RequestMapping("/test")
    public String test(){
        return  "test"+System.currentTimeMillis();
    }
}
