package com.example.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.server.model.TransactionEntityLog;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntityLog, Long> {
	boolean existsByTrxId(String trxId);
}
