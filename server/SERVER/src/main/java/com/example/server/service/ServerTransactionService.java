package com.example.server.service;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.server.controller.ServerController;
import com.example.server.model.TransactionEntityLog;
import com.example.server.repository.TransactionRepository;
import com.example.server.xmlEntity.TransactionXml;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ServerTransactionService implements ServicesTrnx {

	private final TransactionRepository repository;
	private static final Logger log = LoggerFactory.getLogger(ServerController.class);

	public ServerTransactionService(TransactionRepository repository) {
		this.repository = repository;
	}

	@Async
	// @Transactional
	// public String processAsyncTransactionBank(TransactionXml request) {
	public CompletableFuture<String> processAsyncTransactionBank(TransactionXml request) {

		log.info("Processing trxId={}", request.getTrxId());

		// Validate trxId uniqueness
		if (repository.existsByTrxId(request.getTrxId())) {
			throw new IllegalArgumentException("Duplicate trxId");
		}

		// Validate accounts
		validateAccount(request.getFromAccount());
		validateAccount(request.getToAccount());

		//Validate amount
		if (request.getAmount() == null || request.getAmount() <= 0) {
			throw new IllegalArgumentException("Invalid amount");
		}

		// 4. Save transaction
		TransactionEntityLog entity = new TransactionEntityLog();
		entity.setTrxId(request.getTrxId());
		entity.setBankId(request.getBankId());
		entity.setCustomerId(request.getCustomerId());
		entity.setFromAccount(request.getFromAccount());
		entity.setToAccount(request.getToAccount());
		entity.setAmount(request.getAmount());
		entity.setCurrency(request.getCurrency());
		entity.setStatus("RECEIVED");
		entity.setCreatedAt(LocalDateTime.now());

		repository.save(entity);

		// return "ACKNOWLEDGED";
		return CompletableFuture.completedFuture("ACKNOWLEDGED");
	}

	private void validateAccount(String account) {
		if (account == null || !account.matches("\\d{10,}")) {
			throw new IllegalArgumentException("Invalid account number");
		}
	}
}
