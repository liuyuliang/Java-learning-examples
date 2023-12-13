package org.example.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyApplicationListener
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/11/30 16:51
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("事件触发：" + event.getClass().getName());
    }
}