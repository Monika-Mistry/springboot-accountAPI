package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
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

	public String getAccountNumber() {
		return numberGenerator.getAccountNumber();		
	}

}
