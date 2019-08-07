package com.bae.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.service.PrizeService;

@RunWith(SpringRunner.class)
public class PrizeControllerTest {
	
	@InjectMocks 
	private PrizeController controller;
	
	@Mock
	private PrizeService service;
	
	private static final String MOCK_PRIZE = "£0";
	
	@Test
	public void getPrizeTest() {
		when(service.getPrize()).thenReturn(MOCK_PRIZE);
		assertEquals(MOCK_PRIZE, service.getPrize());
	}

	

}
