package org.example.redistemplate.config;

/**
 * ClassName: E
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/7 17:11
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 解决 redis 的 key 出现的 \xac\xed\x00\x05t\x00 乱码问题
 * <pre>
 *     原因分析：
 *
 * spring-data-redis 的 RedisTemplate<K, V>模板类 在操作redis时默认使用JdkSerializationRedisSerializer 来进行序列化。spring操作redis是在jedis客户端基础上进行的，而jedis客户端与redis交互的时候协议中定义是用byte类型交互，看到spring-data-redis中RedisTemplate<K, V>在操作的时候k，v是泛型对象，而不是byte[]类型的，
 *
 * 这样导致的一个问题就是，如果不对RedisTemplate进行设置，spring会默认采用defaultSerializer = new JdkSerializationRedisSerializer();这个方法来对key、value进行序列化操作，JdkSerializationRedisSerializer它使用的编码是ISO-8859-1
 * </pre>
 *
 * @author linzp
 * @version 1.0.0
 * CreateDate 2020/8/18 22:26
 */
@Configuration
public class RedisConfig {

    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();

        template.setConnectionFactory(factory);
        //key序列化方式
        template.setKeySerializer(redisSerializer);
        //value序列化
        template.setValueSerializer(redisSerializer);
        //value hashmap序列化
        template.setHashValueSerializer(redisSerializer);
        //key haspmap序列化
        template.setHashKeySerializer(redisSerializer);

        return template;
    }
}
