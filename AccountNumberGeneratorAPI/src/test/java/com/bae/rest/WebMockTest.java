package com.bae.rest;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.bae.service.NumberGenerator;

@RunWith(SpringRunner.class)
@WebMvcTest(NumberController.class)
@AutoConfigureMockMvc
public class WebMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private NumberGenerator service;

	@MockBean
	private RestTemplate restTemplate;

	private static final String MOCK_ACCOUNT_NUMBER = "A123456";

	@Test
	public void getAccountNumberTest() throws Exception {
		doReturn(MOCK_ACCOUNT_NUMBER).when(service).getAccountNumber();

		mockMvc.perform(MockMvcRequestBuilders.get("/getAccNo")).andExpect(status().isOk())
				.andExpect(content().string(MOCK_ACCOUNT_NUMBER)).andDo(print()).andReturn();
	}

}
