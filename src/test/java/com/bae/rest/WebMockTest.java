package com.bae.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bae.domain.Account;
import com.bae.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
@AutoConfigureMockMvc
public class WebMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountService service;

	private static final Account MOCK_ACCOUNT_1 = new Account(1L, "John", "Smith");
	private static final Account MOCK_ACCOUNT_2 = new Account(2L, "Jane", "Doe");
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@Test
	public void findAllTest() throws Exception {
		List<Account> MOCK_LIST = new ArrayList<>();

		MOCK_LIST.add(MOCK_ACCOUNT_1);
		MOCK_LIST.add(MOCK_ACCOUNT_2);

		when(service.findAll()).thenReturn(MOCK_LIST);

		mockMvc.perform(get("/all")).andExpect(jsonPath("$[0].firstName", is("John")))
				.andExpect(jsonPath("$[1].firstName", is("Jane")));
	}

	@Test
	public void createAccountTest() throws Exception {
		String postValue = OBJECT_MAPPER.writeValueAsString(MOCK_ACCOUNT_1);

		doReturn(MOCK_ACCOUNT_1).when(service).createAccount(MOCK_ACCOUNT_1);

		mockMvc.perform(MockMvcRequestBuilders.post("/").contentType(MediaType.APPLICATION_JSON).content(postValue))
				.andExpect(status().isCreated()).andDo(print());
	}

}
