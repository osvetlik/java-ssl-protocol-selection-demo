package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Client {

	@PostConstruct
	private void getWeb() {
		final var webClient = WebClient.create("https://google.com/");
		final var mono = webClient.get().retrieve().bodyToMono(String.class);
		final var resp = mono.block();
		log.info("Got {}", resp);
	}
}
