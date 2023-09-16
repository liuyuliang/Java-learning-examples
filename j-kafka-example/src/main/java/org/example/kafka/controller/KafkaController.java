package org.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: KafkaController
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/16 21:02
 */
@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/send")
    public void sendMessage(@RequestBody String message) {
        kafkaTemplate.send("kafka-test-topic", message);
    }

}
