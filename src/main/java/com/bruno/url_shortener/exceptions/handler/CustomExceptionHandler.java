package com.bruno.url_shortener.exceptions.handler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.bruno.url_shortener.exceptions.UrlNotFoundException;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(UrlNotFoundException.class)
	public ResponseEntity<?> handlerUrlNotFoundException(UrlNotFoundException ex, WebRequest request) {
		Map<String, Object> body = new HashMap<String, Object>();
		
		body.put("timestamp", new Date());
		body.put("path", request.getDescription(false));
		body.put("message", ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
		Map<String, Object> body = new HashMap<String, Object>();

		body.put("timestamp", new Date());
		body.put("path", request.getDescription(false));
		
		Map<String,String> errors = new HashMap<String, String>();
		
		ex.getBindingResult().getAllErrors().forEach((err) -> {
			errors.put(((FieldError)err).getField(), err.getDefaultMessage());
		});
		body.put("message", errors);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handlerConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
		Map<String, Object> body = new HashMap<String, Object>();
		
		body.put("timestamp", new Date());
		body.put("path", request.getDescription(false));
		body.put("message", ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<?> handlerNoResourceFoundException(NoResourceFoundException ex, WebRequest request) {
		Map<String, Object> body = new HashMap<String, Object>();
		
		body.put("timestamp", new Date());
		body.put("path", request.getDescription(false));
		body.put("message", ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

}
