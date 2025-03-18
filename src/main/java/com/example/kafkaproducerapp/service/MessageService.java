package com.example.kafkaproducerapp.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	private final KafkaTemplate<String, Object> kafkaTemplate;

	public MessageService(KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("my-topic", message);
		future.whenComplete((result, ex) -> {
			if(ex==null) {
				//System.out.println("Published Message: " + message + " | Offset: " + result.getRecordMetadata().offset());
			}else {
				System.out.println("Unable to publish message | " + ex.getMessage());
			}
		});
	}
}
