package com.course.rabbitmq.consumer.consumer;

import com.course.rabbitmq.consumer.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureImageConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOG = LoggerFactory.getLogger(PictureImageConsumer.class);

    @RabbitListener(queues = "q.picture.image")
    public void listen(String message) throws JsonProcessingException {
        LOG.info("On image: {}", objectMapper.readValue(message, Picture.class));
    }
}
