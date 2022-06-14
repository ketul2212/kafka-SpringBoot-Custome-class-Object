package com.ketul.config;

import com.github.javafaker.Faker;
import com.ketul.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class KafkaProducerConfig {

    private Logger logger = LoggerFactory.getLogger(KafkaProducerConfig.class);

    @Autowired
    private KafkaTemplate<String, Student> template;

    @PostConstruct
    public void produceStudent() {
        for(int i = 1; i <= 10; i++) {
            Student student = getStudent();

            Message<Student> message = MessageBuilder.withPayload(student)
                            .setHeader(KafkaHeaders.TOPIC, "kafka-SpringBoot")
                                    .build();

            template.send(message);
        }
        logger.info("Event published...");
    }

    private Student getStudent() {
        Faker faker = new Faker();

        Student student = new Student();
        student.setName(faker.name().fullName());
        student.setMobile(faker.phoneNumber().phoneNumber());
        student.setEmail(student.getName() + "@gmail.com");
        return student;
    }
}
