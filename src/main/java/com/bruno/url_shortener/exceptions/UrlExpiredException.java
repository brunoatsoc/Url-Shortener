package com.bruno.url_shortener.exceptions;

public class UrlExpiredException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UrlExpiredException(String message) {
		super(message);
	}

}
