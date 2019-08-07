package com.bae.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.business.PrizeService;

@RunWith(SpringRunner.class)
public class PrizeControllerTest {
	
	@InjectMocks 
	private PrizeController controller;
	
	@Mock
	private PrizeService service;
	
	private static final String MOCK_ACC_NO_SIX = "A123456";
	private static final String MOCK_PRIZE_SIX = "£0";
	
	private static final String MOCK_ACC_NO_EIGHT = "B12345678";
	private static final String MOCK_PRIZE_EIGHT= "£500";
	
	private static final String MOCK_ACC_NO_TEN = "C1234567890";
	private static final String MOCK_PRIZE_TEN = "£10000";
	
	@Test
	public void getPrizeSixTest() {
		when(service.getPrize(MOCK_ACC_NO_SIX)).thenReturn(MOCK_PRIZE_SIX);
		assertEquals(MOCK_PRIZE_SIX, service.getPrize(MOCK_ACC_NO_SIX));
	}
	
	
	@Test
	public void getPrizeEightTest() {
		when(service.getPrize(MOCK_ACC_NO_EIGHT)).thenReturn(MOCK_PRIZE_EIGHT);
		assertEquals(MOCK_PRIZE_EIGHT, service.getPrize(MOCK_ACC_NO_EIGHT));
	}
	
	
	@Test
	public void getPrizeTenTest() {
		when(service.getPrize(MOCK_ACC_NO_TEN)).thenReturn(MOCK_PRIZE_TEN);
		assertEquals(MOCK_PRIZE_TEN, service.getPrize(MOCK_ACC_NO_TEN));
	}
	

}
