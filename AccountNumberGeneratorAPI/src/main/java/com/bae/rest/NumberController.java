package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.business.NumberGenerator;

@RestController
public class NumberController {
	
	private NumberGenerator numberGenerator;
	
	public NumberController() {
		
	}
	
	@Autowired
	public NumberController(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	@RequestMapping("/getAccNo")
	public ResponseEntity<String> getAccountNumber() {
		String accNo =  numberGenerator.getAccountNumber();
		
		return new ResponseEntity<String>(accNo, HttpStatus.OK);
	}

}
