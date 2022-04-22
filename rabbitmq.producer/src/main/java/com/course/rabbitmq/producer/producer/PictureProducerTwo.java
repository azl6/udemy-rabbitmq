package com.course.rabbitmq.producer.producer;

import com.course.rabbitmq.producer.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureProducerTwo {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(Picture picture) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(picture);

        var sb = new StringBuilder();
        sb.append(picture.getSource());
        sb.append(".");
        sb.append(picture.getSize() > 4000 ? "large" : "small");
        sb.append(".");
        sb.append(picture.getType());

        rabbitTemplate.convertAndSend("x.picture2", sb.toString(), json);

    }
}