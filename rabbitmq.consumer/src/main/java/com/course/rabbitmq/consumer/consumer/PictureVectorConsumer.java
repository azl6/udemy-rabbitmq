//package com.course.rabbitmq.consumer.consumer;
//
//import com.course.rabbitmq.consumer.entity.Picture;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PictureVectorConsumer {
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private static final Logger LOG = LoggerFactory.getLogger(PictureVectorConsumer.class);
//
//    @RabbitListener(queues = "q.picture.vector")
//    public void listen(String message) throws JsonProcessingException {
//        LOG.info("On vector: {}", objectMapper.readValue(message, Picture.class));
//    }
//}
