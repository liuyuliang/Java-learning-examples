package org.example.mockito.controller;

import org.example.mockito.entity.User;
import org.example.mockito.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: D
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/10 16:32
 */
@RestController

@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("user/{userId}")
    public User say(@PathVariable("userId") Long id) {
        return userService.getUser(id);
    }

    @PostMapping("user/edit")
    public User edit(@RequestBody User user) {
        return userService.edit(user);
    }
}
