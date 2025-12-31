package com.example.server.controller;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.service.ServerTransactionService;
import com.example.server.xmlEntity.TransactionXml;

@RestController
@RequestMapping("/api/v1/server/transaction")
public class ServerController {
	private static final Logger log = LoggerFactory.getLogger(ServerController.class);

	private final ServerTransactionService service;

	public ServerController(ServerTransactionService service) {
		this.service = service;
	}

	@PostMapping(value = "/process", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> receive(@RequestBody TransactionXml request) {
		log.info("Received request trxId={} on thread={}", request.getTrxId(), Thread.currentThread().getName());
		CompletableFuture<String> processAsyncTransactionBank = null;
		try {
			processAsyncTransactionBank = service.processAsyncTransactionBank(request);
			log.info("Responding trxId={} with status={}", request.getTrxId(), processAsyncTransactionBank.get());
			return ResponseEntity.ok(Map.of("trxId", request.getTrxId(), "status", processAsyncTransactionBank.get(),
					"message", "Transaction Forwarded"));
		} catch (InterruptedException | ExecutionException e) {

			// cancelled true : - if the future was cancelled before completing.
			// completedExceptionall true :- if the future threw an exception during
			// processing.
			// done true :- if the future finished (successfully or exceptionally).
			// numberOfDependents :Number of other futures waiting on this future (usually
			// 0).
			log.error("Responding trxId={} with status={}", request.getTrxId(), processAsyncTransactionBank);
			return ResponseEntity.ok(Map.of("trxId", request.getTrxId(), "status", processAsyncTransactionBank,
					"message", "Transaction in Server Forwarding (Processing ) "));
			// TODO Auto-generated catch block
		}

	}
}
