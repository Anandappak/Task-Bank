package com.example.client_a.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.example.client_a.model.TransactionRequest;
import com.example.client_a.model.TransactionXml;

@Service
public class XmlConversionService implements ConversionServiceXml {

	public TransactionXml convert(TransactionRequest request, String bankId, String trxId) {
		TransactionXml xml = new TransactionXml();
		xml.setTrxId(trxId);
		xml.setBankId(bankId);
		xml.setCustomerId(request.getCustomerId());
		xml.setFromAccount(request.getFromAccount());
		xml.setToAccount(request.getToAccount());
		xml.setAmount(request.getAmount());
		xml.setCurrency(request.getCurrency());
		xml.setTimestamp(OffsetDateTime.now().toString());
		return xml;
	}
}
