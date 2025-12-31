package com.example.client_b.service;

import com.example.client_b.model.TransactionRequest;
import com.example.client_b.model.TransactionXml;

public interface ConversionServiceXml {

	TransactionXml convert(TransactionRequest request, String bankId, String trxId);

}
