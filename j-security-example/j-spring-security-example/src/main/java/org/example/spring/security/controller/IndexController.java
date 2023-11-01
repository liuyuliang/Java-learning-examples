package org.example.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: IndexController
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/10/31 17:03
 */
@RestController
public class IndexController {
    @GetMapping("/index")

    public String index(){
        return  "index";
    }
}
