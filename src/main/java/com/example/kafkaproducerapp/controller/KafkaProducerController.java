package com.example.kafkaproducerapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaproducerapp.service.KafkaProducerService;
import com.example.vo.TransactionVo;


@RestController
@RequestMapping("/v1/transactions")
public class KafkaProducerController {

	private final KafkaProducerService kafkaProducerService;
	
	public KafkaProducerController(KafkaProducerService kafkaProducerService) {
		this.kafkaProducerService = kafkaProducerService;
	}
	
	@PostMapping("")
	public ResponseEntity<?> publishTransactionMessage(@RequestBody TransactionVo transactionVo) {
		try {
				kafkaProducerService.publishTransactionMessage(transactionVo);
			return ResponseEntity.ok("Transaction Message published");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
	
}
