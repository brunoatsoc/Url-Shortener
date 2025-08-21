package com.bruno.url_shortener.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruno.url_shortener.model.UrlShortener;

public interface UrlShortenerRepository extends JpaRepository<UrlShortener, UUID> {

	Optional<UrlShortener> findByShortUrl(String shortUrl);

	boolean existsByShortUrl(String shortUrl);

	Optional<UrlShortener> findByShortUrlAndExpiresAtAfter(String shortUrl, LocalDateTime now);	

}
