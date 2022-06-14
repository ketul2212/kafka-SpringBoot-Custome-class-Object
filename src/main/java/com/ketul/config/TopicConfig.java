package com.ketul.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Service;

@Service
public class TopicConfig {

    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name("kafka-SpringBoot")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
