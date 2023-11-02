package org.example.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: IndexController
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/10/31 17:03
 */
@Controller
public class IndexController {

    @RequestMapping("/out")
    public String login() {
        return "out";
    }
}
