package org.example.spring.security.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName: IndexController
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/11/6 10:59
 */
@Controller
public class IndexController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/admin/api")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user/api")
    public String user() {
        return "user";
    }

    @GetMapping("/app/api")
    public String app() {
        return "app";
    }

    @GetMapping("/noAuth")
    public String noAuth() {
        return "noAuth";
    }
}
