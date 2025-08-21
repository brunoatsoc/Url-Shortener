package com.bruno.url_shortener.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UrlNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UrlNotFoundException(String message) {
		super(message);
	}

}
