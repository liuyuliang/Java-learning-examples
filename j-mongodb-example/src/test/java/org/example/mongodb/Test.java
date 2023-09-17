package  org.example.mongodb;
import org.example.mongodb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * ClassName: Test
 * Description: 测试类要和应用包名一致，不然会报 SpringBoot测试失败并报错: Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration
 *
 * @author Yuliang Lau
 * @date 2023/9/17 9:59
 */
@SpringBootTest
public class Test {
    @Autowired
    private MongoTemplate  mongoTemplate;

    @org.junit.jupiter.api.Test
    public void insertTest() {
        User user = new User();
        user.setAge(20);
        user.setName("test");
        user.setEmail("123@qq.com");
        User user1 = mongoTemplate.insert(user);
        System.out.println(user1);
    }
}
