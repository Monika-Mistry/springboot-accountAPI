package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.service.PrizeService;

@RestController
public class PrizeController {
	
	private PrizeService prizeService;
	
	@Autowired
	public PrizeController(PrizeService prizeService) {
		this.prizeService = prizeService;
	}
	
	public PrizeController() {
	}

	@GetMapping("/getPrize")
	public ResponseEntity<String> getPrize() {
		return new ResponseEntity<String>(prizeService.getPrize(), HttpStatus.OK);
	}
}
