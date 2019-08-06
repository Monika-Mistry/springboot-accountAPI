package com.bae.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@WebMvcTest(MicroController.class)
@AutoConfigureMockMvc
public class MicroControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RestTemplate restTemplate;
	
	@Test
	public void getAccountNumberTest() throws Exception {
		
		mockMvc.perform(get("/getAccNo")).andExpect(status().isOk()).andDo(print());
	}

}
