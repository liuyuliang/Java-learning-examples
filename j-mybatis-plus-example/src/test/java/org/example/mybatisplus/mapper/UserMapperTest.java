package org.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    @Test
    public void testQueryWrapper() {
        // 查询条件构造器
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "tom");
        // 查询操作
        List<User> bannerItems = userMapper.selectList(wrapper);
    }

    @Test
    public void testLambdaQueryWrapper() {

        //todo 报错，原因未知
//        String userName ="tom";
//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
//        lambdaQueryWrapper.like(User::getUserName,userName);
//
//        userMapper.selectList(lambdaQueryWrapper);


    }

}