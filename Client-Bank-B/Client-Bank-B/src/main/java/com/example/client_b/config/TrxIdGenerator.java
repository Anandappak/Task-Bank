package com.example.client_b.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

@Component
public class TrxIdGenerator {

	private final AtomicLong counter = new AtomicLong(0);

	public String generate(String bankId) {
		String date = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
		long num = counter.incrementAndGet();
		return String.format("TRX-%s-%06d", date, num);
	}
}
