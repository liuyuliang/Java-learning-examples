package org.example.spring.security.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello ,spring security!" + LocalDateTime.now();
    }

    /**
     * 图片验证码
     *
     * @param response
     * @throws java.io.IOException
     */
    @GetMapping("admin/code")
    public void getHtoolVerifyCode(HttpServletResponse response) throws IOException {
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        lineCaptcha.setGenerator(randomGenerator);
        lineCaptcha.createCode();
        redisTemplate.opsForValue().append(lineCaptcha.getCode(), lineCaptcha.getCode());
//        jedis.set(RedisKey.ADMIN_VERIFY_CODE +lineCaptcha.getCode(),lineCaptcha.getCode());
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        lineCaptcha.write(response.getOutputStream());
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
