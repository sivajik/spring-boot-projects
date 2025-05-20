package com.sprms.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "my-topic", groupId = "my_new_group", topicPattern = "topic")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
