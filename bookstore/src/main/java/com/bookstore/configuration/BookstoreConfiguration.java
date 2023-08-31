package com.bookstore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BookstoreConfiguration {
	
	@Bean
	public WebClient.Builder getWebClient() {
		return WebClient.builder();
	}

}
