package com.example.observability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ObservabilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObservabilityApplication.class, args);
	}

	@Bean
	public RestTemplate xxx() {
		return new RestTemplateBuilder().build();
	}

}
