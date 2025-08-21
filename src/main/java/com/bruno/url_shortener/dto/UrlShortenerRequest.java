package com.bruno.url_shortener.dto;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;

public record UrlShortenerRequest(
		@NotBlank(message = "The URL cannot be empty")
		@URL(message = "The URL must be valid")
		String originalUrl) {
}
