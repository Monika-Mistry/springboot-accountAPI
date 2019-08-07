package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bae.business.PrizeService;

@RestController
public class PrizeController {
	
	private PrizeService prizeService;
	
	@Autowired
	public PrizeController(PrizeService prizeService) {
		this.prizeService = prizeService;
	}
	
	public PrizeController() {
	}

	@GetMapping("/getPrize/{accountNo}")
	public String getPrize(@PathVariable("accountNo") String accountNumber) {
		return prizeService.getPrize(accountNumber);
	}
}
