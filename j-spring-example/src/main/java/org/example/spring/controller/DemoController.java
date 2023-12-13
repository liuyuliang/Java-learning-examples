package org.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: Demo
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/11/30 16:40
 */
@RestController
@RequestMapping("/")
public class DemoController {
    @RequestMapping("/test")
    public String test(){
        return  "test";
    }
}
