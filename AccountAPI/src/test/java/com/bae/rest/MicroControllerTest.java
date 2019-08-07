package com.bae.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
public class MicroControllerTest {
	
	@InjectMocks
	private MicroController controller;

	@Mock
	private RestTemplate restTemplate;
	
	private static final String MOCK_ACCOUNT_NO = "A123456";
	private static final String MOCK_PRIZE = "£0";
	
	private static final String ACC_NO_URL = "http://localhost:8081/getAccNo";
	private static final String PRIZE_URL = "http://localhost:8082/getPrize/";
	
	@Test
	public void getAccountNumberTest() {

		ResponseEntity<String> accNumber = new ResponseEntity<String>(MOCK_ACCOUNT_NO, HttpStatus.OK);
		
		when(restTemplate.exchange(ACC_NO_URL, HttpMethod.GET, null, String.class)).thenReturn(accNumber);
		
		assertEquals(accNumber, controller.getAccountNumber());

	}
	
	@Test
	public void getPrize() {
		ResponseEntity<String> prize = new ResponseEntity<String>(MOCK_PRIZE, HttpStatus.OK);

		when(restTemplate.exchange(PRIZE_URL + MOCK_ACCOUNT_NO, HttpMethod.GET, null, String.class)).thenReturn(prize);
		
		assertEquals(prize, controller.getPrize(MOCK_ACCOUNT_NO));
	

	}

}
