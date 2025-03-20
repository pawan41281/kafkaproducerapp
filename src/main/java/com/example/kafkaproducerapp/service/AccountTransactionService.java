package com.example.kafkaproducerapp.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.example.vo.AccountTransactionVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountTransactionService {

	private final KafkaTemplate<String, AccountTransactionVo> kafkaTemplate;
	
	public AccountTransactionService(KafkaTemplate<String, AccountTransactionVo> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void publish(AccountTransactionVo transactionVo) {
		CompletableFuture<SendResult<String, AccountTransactionVo>> future = kafkaTemplate.send("transactions", transactionVo);
		future.whenComplete((result, ex) -> {
			if(ex!=null) {
				log.error("Failed to publish account transaction : {}",transactionVo);
			}else {
				log.info("Account transaction published : {}",transactionVo);
			}
		});
	}
}
