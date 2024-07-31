package org.example.jdk.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName: ReflectTest
 * Description:
 *
 * @author Yuliang Lau
 * @date 2024/7/31 14:07
 */
public class ReflectTest {
    interface MyService {
        void performService();
    }

    class MyServiceImpl implements MyService {
        public void performService() {
            System.out.println("Service performed");
        }
    }

    @Test
    public void test() {
        MyService service = new MyServiceImpl();
        MyService proxy = (MyService) Proxy.newProxyInstance(
                MyService.class.getClassLoader(),
                new Class[]{MyService.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Before service call");
                        Object result = method.invoke(service, args);
                        System.out.println("After service call");
                        return result;
                    }
                }
        );

        proxy.performService();
    }
}
