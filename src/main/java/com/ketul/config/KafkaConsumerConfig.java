package com.ketul.config;

import com.ketul.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerConfig {

    private Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @KafkaListener(topics = "kafka-SpringBoot", groupId = "myGroup")
    public void consume(Student student) {
        logger.info("Received student ---> {}", student);
    }
}
