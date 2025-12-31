package com.example.client_b.service;

import org.springframework.stereotype.Service;

import com.example.client_b.config.TrxIdGenerator;
import com.example.client_b.model.TransactionRequest;
import com.example.client_b.model.TransactionXml;

@Service
public class TransactionService {

    private final TrxIdGenerator trxIdGenerator;
    private final XmlConversionService xmlConversionService;
    private final ServerCommunicationService serverCommunicationService;
    private final ConcurrentRequestExecutor requestExecutor;

    private final String bankId = "BANK_B"; // 

    public TransactionService(TrxIdGenerator trxIdGenerator,
                              XmlConversionService xmlConversionService,
                              ServerCommunicationService serverCommunicationService,
                              ConcurrentRequestExecutor requestExecutor) {
        this.trxIdGenerator = trxIdGenerator;
        this.xmlConversionService = xmlConversionService;
        this.serverCommunicationService = serverCommunicationService;
        this.requestExecutor = requestExecutor;
    }

    /**
     * Prepare transaction XML from JSON request.
     */
    public TransactionXml prepareTransaction(TransactionRequest request) {
        String trxId = trxIdGenerator.generate(bankId);
        return xmlConversionService.convert(request, bankId, trxId);
    }

    /**
     * Send transaction XML to server (synchronous).
     */
    public void sendToServer(TransactionXml xml) {
        serverCommunicationService.send(xml);
    }

    /**
     * Optional: Send multiple transactions concurrently.
     */
    public void sendBulkTransactions(java.util.List<TransactionXml> xmlList) {
        requestExecutor.sendBulk(xmlList);
    }
}
