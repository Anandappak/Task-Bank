package com.example.server.service;

import java.util.concurrent.CompletableFuture;

import com.example.server.xmlEntity.TransactionXml;

public interface ServicesTrnx {
	
	CompletableFuture<String> processAsyncTransactionBank(TransactionXml request);

}
