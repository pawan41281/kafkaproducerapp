package com.example.kafkaproducerapp.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.example.vo.TransactionVo;

@Service
public class KafkaProducerService {

	private final KafkaTemplate<String, Object> kafkaTemplate;
	
	public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void publishTransactionMessage(TransactionVo transactionVo) {
		CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("my-topic2", transactionVo);
		future.whenComplete((result, ex) -> {
			if(ex!=null) {
				System.out.println("Failed to publish transaction message : " + transactionVo);
			}else {
				System.out.println("Published transaction message : " + transactionVo);
			}
		});
	}
}
