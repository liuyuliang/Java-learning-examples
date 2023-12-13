package org.example.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * ClassName: AnotationEvet
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/11/30 16:54
 */
@Configuration
public class AnotationEvet {
    @EventListener(classes={ApplicationEvent.class})
    public void listen(ApplicationEvent event){
        System.out.println("注解事件触发："+event.getClass().getName());
    }
}
