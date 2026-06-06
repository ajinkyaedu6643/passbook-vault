package com.passbookvault.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleNotFound(
			ResourceNotFoundException ex,
			HttpServletRequest request){
		
		Map<String, Object> response = new HashMap<>();
		
		response.put("timestamp", LocalDateTime.now());
		response.put("Status", 404);
		response.put("message", ex.getMessage());
		response.put("path", request.getRequestURI());
		
		return ResponseEntity.status(
				HttpStatus.NOT_FOUND)
				.body(response);
	}
}
