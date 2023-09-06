package org.example.mybatis.controller;

import org.example.mybatis.entity.Response;
import org.example.mybatis.entity.User;
import org.example.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: d
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/6 11:20
 */
@RestController
public class UserController {
    @Autowired

    private UserService userService;

    @PostMapping
            ("user/insert")
    public Response insertUser(@RequestBody User user) {
        int result = userService.insertUser(user);
        return Response.success(result);
    }

    @PostMapping("user/getByUserNameAndPassword")
    public Response getByUserNameAndPassword(@RequestBody User user) {
        User result = userService.getByUserNameAndPassword(user);
        System.out.println(result.toString());
        return Response.success(result);
    }
}


