package com.course.rabbitmq.producer.scheduler;

import com.course.rabbitmq.producer.client.RabbitmqClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RabbitmqScheduler {
    @Autowired
    private RabbitmqClient rabbitmqClient;

    private static final Logger LOG = LoggerFactory.getLogger(RabbitmqScheduler.class);


    @Scheduled(fixedDelay = 90000)
    private void sweepDirtyQueues(){
        try {
            var dirtyQueues = rabbitmqClient.getAllQueues()
                    .stream()
                    .filter(x -> x.isDirty()).collect(Collectors.toList());

            dirtyQueues.forEach(x -> LOG.info("Queue {} has {} unprocessed messages", x.getName(), x.getMessages()));
        }catch (Exception e){
            LOG.warn("Cannot sweep queues: {}", e.getMessage());
        }
    }


}
