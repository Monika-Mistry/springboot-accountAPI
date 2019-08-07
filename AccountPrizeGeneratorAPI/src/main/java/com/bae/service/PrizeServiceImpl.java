package com.bae.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class PrizeServiceImpl implements PrizeService {

	public String getPrize() {
		
		Random random = new Random();
		
		int prize = random.nextInt(1000);
		
		return "£" + prize ;
	}


}
