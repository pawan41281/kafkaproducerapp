package com.example.kafkaproducerapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaproducerapp.service.MessageService;

@RestController
@RequestMapping("/v1/messages")
public class MessageController {

	private final MessageService messageService;

	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	@GetMapping("/{message}")
	public ResponseEntity<?> sendMessage(@PathVariable String message) {
		try {
			for (int counter = 1; counter <= 1000; counter++) {
				messageService.sendMessage(message + " : Replica " + counter);
			}
			return ResponseEntity.ok("Message published");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
