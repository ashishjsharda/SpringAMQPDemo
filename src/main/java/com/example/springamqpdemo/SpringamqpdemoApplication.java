package com.example.springamqpdemo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringamqpdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringamqpdemoApplication.class, args);
    }

    @RabbitListeners(value = @RabbitListener(queues = "myqueue"))
    public void listen(String in) {
        System.out.println(in);
    }

}
