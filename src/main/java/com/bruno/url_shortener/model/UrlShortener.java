package com.bruno.url_shortener.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "url_shortener")
@Data
public class UrlShortener {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "origina_ulrl", length = 1000, nullable = false)
	private String originaUlrl;

	@Column(name = "short_url", length = 100, nullable = false)
	private String shortUrl;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false)
	private LocalDateTime expiresAt;

}
