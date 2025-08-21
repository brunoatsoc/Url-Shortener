package com.bruno.url_shortener.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.url_shortener.dto.UrlShortenerRequest;
import com.bruno.url_shortener.service.UrlShortenerService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("url-shortener")
@RequiredArgsConstructor
@Validated
public class UrlShortenerController {

    private final UrlShortenerService urlService;

	@PostMapping("/shorten")
	public ResponseEntity<String> encurtar(@Valid @RequestBody UrlShortenerRequest urlShortenerRequest) {
	    String urlCurta = urlService.shortenUrl(urlShortenerRequest.originalUrl());
	    return ResponseEntity.ok(urlCurta);
	}

	@GetMapping("/{short-url}")
	public ResponseEntity<Void> redirecionar(@PathVariable("short-url") @Size(min = 10, max = 10, message = "Short URL must be 10 characters long") String shortUrl) {
	    String urlOriginal = urlService.getOriginalUrl(shortUrl);
	
	    return ResponseEntity.status(HttpStatus.FOUND)
	            .location(URI.create(urlOriginal))
	            .build();
	}

}
