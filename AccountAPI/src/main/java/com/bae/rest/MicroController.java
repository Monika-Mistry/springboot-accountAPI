package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MicroController {

	private RestTemplate restTemplate;

	private static final String ACC_NO_URL = "http://localhost:8081/getAccNo";

	@Autowired
	public MicroController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public MicroController() {

	}

	@GetMapping("/getAccNo")
	public ResponseEntity<String> getAccountNumber() {
		return restTemplate.exchange(ACC_NO_URL, HttpMethod.GET, null, String.class);
	}

}
