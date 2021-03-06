package com.bae.business;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.service.NumberGeneratorEight;

@RunWith(SpringRunner.class)
public class NumberGeneratorEightTest {
	
	@InjectMocks
	private NumberGeneratorEight numgen;
	
	@Test
	public void getAccountNumberTest() {
		String pattern = "[ABC]\\d{8}";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(numgen.getAccountNumber());		
		
		assertEquals(true, m.matches());
	}
}
