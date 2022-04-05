package com.course.rabbitmq.consumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HelloRabbitConsumer{

    @RabbitListener(queues = "course.hello")
    public void listen(String msg){
        System.out.println("Consuming " + msg);
    }
}
