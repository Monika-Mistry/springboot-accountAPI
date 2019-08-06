package com.bae.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class NumberGeneratorSix implements NumberGenerator {

	public String getAccountNumber() {
		
		int length = 7;

		String digits = "0123456789";
		String chars = "ABC";

		Random random = new Random();

		List<String> result = new ArrayList<>();

		Consumer<String> appendChar = s -> result.add("" + s.charAt(random.nextInt(s.length())));
		
		appendChar.accept(chars);
		
		while(result.size() < length) {
			appendChar.accept(digits);
		}
		
		String str = String.join("", result);

		return str;
	}

}
