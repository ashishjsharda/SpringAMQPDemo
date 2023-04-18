package com.example.springamqpdemo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringamqpdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringamqpdemoApplication.class, args);
    }

    @RabbitListeners(value = @RabbitListener(queues = "myqueue"))
    public void listen(String in) {
        System.out.println(in);
    }

    @Bean
    public String queueName() {
        return "myqueue";
    }

    @Bean
    public ApplicationRunner runner(RabbitTemplate template, String queueName) {
        return args -> {
            template.convertAndSend(queueName, "Hello, world!");
        };
    }

    }


