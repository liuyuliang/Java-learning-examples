package org.example.jdk.annotation;

import org.example.jdk.dto.UserDto;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Field;

/**
 * ClassName: Test
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/4 10:26
 */
public class AnnontationTest {
    @org.junit.jupiter.api.Test
    public void annotationTest() throws IllegalAccessException {
        UserDto userDto = new UserDto();
        initUser(userDto);
        boolean checkResult = checkUser(userDto);
        Assertions.assertFalse(checkResult);
        userDto.setAge(22);
        checkResult = checkUser(userDto);
        Assertions.assertTrue(checkResult);
    }

    private boolean checkUser(UserDto userDto) throws IllegalAccessException { // 获取User类中所有的属性(getFields无法获得private属性)
        Field[] fields = UserDto.class.getDeclaredFields();
        boolean result = true;
        // 遍历所有属性
        for (Field field : fields) {
            // 如果属性上有此注解，则进行赋值操作
            if (field.isAnnotationPresent(ValidateAge.class)) {
                ValidateAge validateAge = field.getAnnotation(ValidateAge.class);
                field.setAccessible(true);
                int age = (int) field.get(userDto);
                if (age < validateAge.min() || age > validateAge.max()) {
                    result = false;
                    System.out.println("年龄值不符合条件");
                }
            }
        }
        return result;
    }

    private void initUser(UserDto userDto) throws IllegalAccessException {
        // 获取User类中所有的属性(getFields无法获得private属性)
        Field[] fields = UserDto.class.getDeclaredFields();
        // 遍历所有属性
        for (Field field : fields) {
            // 如果属性上有此注解，则进行赋值操作
            if (field.isAnnotationPresent(InitSex.class)) {
                InitSex init = field.getAnnotation(InitSex.class);
                field.setAccessible(true);
                // 设置属性的性别值
                field.set(userDto, init.sex().toString());
                System.out.println("完成属性值的修改，修改值为:" + init.sex().toString());
            }
        }
    }
}
