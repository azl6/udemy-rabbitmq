package com.course.rabbitmq.consumer.consumer;//package com.course.rabbitmq.consumer.consumer;

import com.course.rabbitmq.consumer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;

//@Service
public class SpringPictureConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOG = LoggerFactory.getLogger(SpringPictureConsumer.class);

    @RabbitListener(queues = "q.spring.image.work")
    public void listenImage(String message) throws IOException {
        var picture = objectMapper.readValue(message, Picture.class);
        LOG.info("Consuming image {}", picture);

        if(Integer.parseInt(picture.getSize()) > 9000) throw new IllegalArgumentException("Image too large");

        LOG.info("Processing image {}...", picture.getName());
    }

    @RabbitListener(queues = "q.spring.vector.work")
    public void listenVector(String message) throws IOException {
        var picture = objectMapper.readValue(message, Picture.class);
        LOG.info("Consuming image {}", picture);

        LOG.info("Processing vector {}...", picture.getName());

    }
}
