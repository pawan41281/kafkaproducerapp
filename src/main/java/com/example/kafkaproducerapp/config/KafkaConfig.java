package com.example.kafkaproducerapp.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

//	@Bean
//	NewTopic createNewTopic() {
//		return new NewTopic("my-topic", 10, (short) 1); //this will create topic 1st parameter topic name, 2nd parameter number of partitions, 3rd param number of replicas
//	}
}
