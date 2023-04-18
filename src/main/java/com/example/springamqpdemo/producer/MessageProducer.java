package com.example.springamqpdemo.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
    private final RabbitTemplate rabbitTemplate;

    public MessageProducer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("myqueue", message);
    }

}
