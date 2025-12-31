package com.example.client_a.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.client_a.model.TransactionXml;

@Service
public class ServerCommunicationService {

	private final RestTemplate restTemplate = new RestTemplate();
	private final String serverUrl = "http://localhost:9700/api/v1/server/transaction/process";

	public void send(TransactionXml xml) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<TransactionXml> request = new HttpEntity<>(xml, headers);

		restTemplate.postForObject(serverUrl, request, String.class);
	}
}
