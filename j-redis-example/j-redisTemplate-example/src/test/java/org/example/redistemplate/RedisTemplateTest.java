package org.example.redistemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: RedisTemplateTest
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/7 16:50
 */
@SpringBootTest
public class RedisTemplateTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void stringTest() {
        //1、通过redisTemplate设置值
        redisTemplate.boundValueOps("StringKey1").set("StringValue1");
        redisTemplate.boundValueOps("StringKey2").set("StringValue2", 1, TimeUnit.MINUTES);

//2、通过BoundValueOperations设置值
        BoundValueOperations stringKey = redisTemplate.boundValueOps("StringKeyBoundValueOperations");
        stringKey.set("StringVauleBoundValueOperations");
        stringKey.set("StringValueBoundValueOperations", 1, TimeUnit.MINUTES);

//3、通过ValueOperations设置值
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("StringKeyValueOperations", "StringVauleValueOperations");
        ops.set("StringValueValueOperations", "StringVauleValueOperations", 1, TimeUnit.MINUTES);

    }
}
