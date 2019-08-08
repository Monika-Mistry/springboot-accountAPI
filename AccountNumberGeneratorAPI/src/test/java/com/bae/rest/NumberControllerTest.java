package com.bae.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.service.NumberGenerator;

@RunWith(SpringRunner.class)
public class NumberControllerTest {
	
	@InjectMocks
	private NumberController controller;
	
	@Mock
	private NumberGenerator numgen;
	
	private static final String MOCK_ACCOUNT_NUMBER = "A123456";
	
	@Test
	public void getAccountNumberTest() {
		when(numgen.getAccountNumber()).thenReturn(MOCK_ACCOUNT_NUMBER);
		
		assertEquals(MOCK_ACCOUNT_NUMBER, controller.getAccountNumber().getBody());
	}
	
	

}
