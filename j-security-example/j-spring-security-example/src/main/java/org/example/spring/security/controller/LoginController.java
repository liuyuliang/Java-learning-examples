package org.example.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

/**
 * ClassName: LoginController
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/10/19 14:03
 */
@Controller
public class LoginController {

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello ,spring security!"+ LocalDateTime.now();
    }
}
