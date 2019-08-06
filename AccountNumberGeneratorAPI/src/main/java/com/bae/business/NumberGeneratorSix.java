package com.bae.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

@Service
public class NumberGeneratorSix implements NumberGenerator {

	public String getAccountNumber() {
		
		String digits = "0123456789";
		String chars = "ABC";

		Random random = new Random();

		List<String> result = new ArrayList<>();

		Consumer<String> appendChar = s -> result.add("" + s.charAt(random.nextInt(s.length())));
		
		appendChar.accept(chars);
		
		while(result.size() < 7) {
			appendChar.accept(digits);
		}
		
		String str = String.join("", result);

		return str;
	}

}
