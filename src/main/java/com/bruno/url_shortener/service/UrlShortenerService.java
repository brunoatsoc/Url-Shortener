package com.bruno.url_shortener.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bruno.url_shortener.exceptions.UrlExpiredException;
import com.bruno.url_shortener.exceptions.UrlNotFoundException;
import com.bruno.url_shortener.model.UrlShortener;
import com.bruno.url_shortener.repository.UrlShortenerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrlShortenerService {

	private final UrlShortenerRepository repository;

	private SecureRandom secureRandom = new SecureRandom();

	@Value("${app.link-characters}")
	private String linkCharacters;
	@Value("${app.server-link-base}")
	private String serverLinkBase;
	@Value("${app.short-url-size}")
	private Integer shortUrlSize;
	@Value("${app.url-expire-time-minutes}")
	private Integer urlExpireTimeMinutes;

	public String shortenUrl(String longUrl) {
        String shortUrl = generateUniqueShortUrl();
        
        UrlShortener url = new UrlShortener();
        url.setOriginaUlrl(longUrl);
        url.setShortUrl(shortUrl);
        url.setCreatedAt(LocalDateTime.now());
        url.setExpiresAt(LocalDateTime.now().plusMinutes(1));
        
        repository.save(url);
        
        return serverLinkBase + shortUrl;
    }

	public String getOriginalUrl(String shortUrl) {
        return repository.findByShortUrl(shortUrl).map(url -> {
        	if (LocalDateTime.now().isAfter(url.getExpiresAt())) {
        		repository.delete(url);

        		throw new UrlExpiredException("URL is expired");
        	}
        	
        	return url.getOriginaUlrl();
        }).orElseThrow(() -> new UrlNotFoundException("URL does not exists"));
    }

	private String generateUniqueShortUrl() {
		String shortUrl;
	
	    do {
	    	shortUrl = generateShortUrl();
	    } while (repository.existsByShortUrl(shortUrl));
	
	    return shortUrl;
	}

	private String generateShortUrl() {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int i = 0; i < shortUrlSize; i++) {
	        int index = secureRandom.nextInt(linkCharacters.length());
	        stringBuilder.append(linkCharacters.charAt(index));
	    }

	    return stringBuilder.toString();
	}

}
