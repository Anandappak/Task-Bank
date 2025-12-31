package com.example.client_a.service;

import com.example.client_a.model.TransactionRequest;
import com.example.client_a.model.TransactionXml;

public interface ConversionServiceXml {

	TransactionXml convert(TransactionRequest request, String bankId, String trxId);

}
