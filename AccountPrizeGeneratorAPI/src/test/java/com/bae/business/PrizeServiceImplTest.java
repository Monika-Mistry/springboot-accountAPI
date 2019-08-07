package com.bae.business;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.service.PrizeServiceImpl;

@RunWith(SpringRunner.class)
public class PrizeServiceImplTest {
	
	@InjectMocks
	private PrizeServiceImpl service;
	
	@Test
	public void getPrizeTest() {
		String pattern = "£\\d{1,3}";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(service.getPrize());	
	System.out.println(service.getPrize());
		
		assertEquals(true, m.matches());
	}
	

}
