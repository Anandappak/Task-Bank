package com.example.server.exptional;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleValidation(IllegalArgumentException ex) {
		return ResponseEntity.badRequest().body(Map.of("status", "REJECTED", "message", ex.getMessage()));
	}
}
