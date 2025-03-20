package com.example.kafkaproducerapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaproducerapp.service.AccountTransactionService;
import com.example.vo.AccountTransactionVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/accounttransactions")
public class AccountTransactionController {

	private final AccountTransactionService accountTransactionService;
	
	public AccountTransactionController(AccountTransactionService accountTransactionService) {
		this.accountTransactionService = accountTransactionService;
	}
	
	@PostMapping("")
	public ResponseEntity<?> publish(@RequestBody AccountTransactionVo transactionVo) {
		try {
			accountTransactionService.publish(transactionVo);
			return ResponseEntity.ok("Account Transaction Message published");
		} catch (Exception e) {
			log.error("Exception: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
	
}
