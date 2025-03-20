package com.example.kafkaproducerapp.config;

//import java.util.HashMap;
//import java.util.Map;
//
import org.apache.kafka.clients.admin.NewTopic;
//import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic createNewTopic() {
		return new NewTopic("transactions", 1, (short) 1); 
		//this will create new topic if not exists
		//1st parameter topic name, 
		//2nd parameter number of partitions, 
		//3rd param number of replicas
	}
//	
//	@Bean
//	ProducerFactory<String, Object> producerFactory(){
//		Map<String, Object> map = new HashMap<>();
//		map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.29.109:9092");
//		map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class);
//		map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, org.springframework.kafka.support.serializer.JsonSerializer.class);
//		return new DefaultKafkaProducerFactory<>(map);
//	}
//	
//	@Bean
//	KafkaTemplate<String, Object> kafkaTemplate(){
//		return new KafkaTemplate<>(producerFactory());
//	}
	
}
