package org.example.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * ClassName: KafkaConsumer
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/16 21:06
 */
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "kafka-test-topic", groupId = "my-group-id")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }

}
