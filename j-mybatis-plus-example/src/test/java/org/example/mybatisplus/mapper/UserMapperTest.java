package org.example.mybatisplus.mapper;

import org.example.mybatisplus.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: UserMapperTest
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/6 14:26
 */
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        List<User> list = userMapper.selectList(null);
        list.stream().forEach((user) -> {
            System.out.println(user.getUserName());
        });
    }

}