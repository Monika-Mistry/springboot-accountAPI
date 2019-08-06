package com.bae.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PrizeServiceImplTest {
	
	@InjectMocks
	private PrizeServiceImpl service;
	
	@Test
	public void getPrizeSixTest() {
		assertEquals("£0", service.getPrize("A123456"));
		assertEquals("£50", service.getPrize("B123456"));
		assertEquals("£100", service.getPrize("C123456"));
	}
	
	@Test
	public void getPrizeEightTest() {
		assertEquals("£0", service.getPrize("A12345678"));
		assertEquals("£500", service.getPrize("B12345678"));
		assertEquals("£750", service.getPrize("C12345678"));
	}
	
	@Test
	public void getPrizeTenTest() {
		assertEquals("£0", service.getPrize("A1234567890"));
		assertEquals("£5000", service.getPrize("B1234567890"));
		assertEquals("£10000", service.getPrize("C1234567890"));
	}

}
