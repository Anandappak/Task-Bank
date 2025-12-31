package com.example.client_a.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.client_a.model.TransactionRequest;
import com.example.client_a.model.TransactionXml;
import com.example.client_a.service.TransactionService;

@RestController
@RequestMapping("/api/v1/bank")
public class TransactionController {

	private final TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@PostMapping("/transaction")
	public ResponseEntity<?> createTransaction(@RequestBody TransactionRequest request) {

		// Generate trxId & XML
		TransactionXml xml = transactionService.prepareTransaction(request);

		// Forward to server
		transactionService.sendToServer(xml);

		// Respond back to client
		return ResponseEntity.ok(
				Map.of("trxId", xml.getTrxId(), "status", "FORWARDED", "message", "Transaction forwarded to server"));
	}
}
