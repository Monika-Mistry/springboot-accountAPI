package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.service.NumberGenerator;

@RestController
public class NumberController {
	
	private NumberGenerator numberGenerator;
	
	public NumberController() {
		
	}
	
	@Autowired
	public NumberController(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	@GetMapping("/getAccNo")
	public ResponseEntity<String> getAccountNumber() {		
		return new ResponseEntity<String>(numberGenerator.getAccountNumber(), HttpStatus.OK);
	}

}
