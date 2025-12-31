package com.example.client_a.service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

import com.example.client_a.model.TransactionXml;

@Service
public class ConcurrentRequestExecutor {

    private final ExecutorService executor = Executors.newFixedThreadPool(100);
    private final ServerCommunicationService serverService;

    public ConcurrentRequestExecutor(ServerCommunicationService serverService) {
        this.serverService = serverService;
    }

    public void sendBulk(List<TransactionXml> requests) {
        for (TransactionXml xml : requests) {
            executor.submit(() -> serverService.send(xml));
        }
    }
}
