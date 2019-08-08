package com.bae.rest;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.bae.domain.Account;
import com.bae.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
@AutoConfigureMockMvc
public class WebMockTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext ctx;

	@MockBean
	private AccountService service;

	@MockBean
	private RestTemplate restTemplate;

	@MockBean
	private JmsTemplate jmsTemplate;

	private static final Account MOCK_ACCOUNT_1 = new Account(1L, "John", "Smith", "A123456", "£0");
	private static final Account MOCK_ACCOUNT_2 = new Account(2L, "Jane", "Doe", "B123456", "£100");
	private static final Account MOCK_ACCOUNT_CREATE = new Account(1L, "John", "Smith");
	private static final String MOCK_DELETE_RESPONSE = "Account Successfully Deleted";
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void findAllTest() throws Exception {
		List<Account> MOCK_LIST = new ArrayList<>();

		MOCK_LIST.add(MOCK_ACCOUNT_1);
		MOCK_LIST.add(MOCK_ACCOUNT_2);

		when(service.findAll()).thenReturn(MOCK_LIST);

		mockMvc.perform(get("/all")).andExpect(jsonPath("$[0].firstName", is("John")))
				.andExpect(jsonPath("$[1].firstName", is("Jane"))).andExpect(jsonPath("$", hasSize(2)));

	}

	@Test
	public void findByIdTest() throws Exception {
		List<Account> MOCK_LIST = new ArrayList<>();

		MOCK_LIST.add(MOCK_ACCOUNT_1);

		when(service.findById(1L)).thenReturn(MOCK_ACCOUNT_1);

		mockMvc.perform(get("/{id}", 1L)).andExpect(jsonPath("$.firstName", is("John")));
	}

	@Ignore
	@Test
	public void createAccountTest() throws Exception {
		String postValue = OBJECT_MAPPER.writeValueAsString(MOCK_ACCOUNT_CREATE);

		doReturn(MOCK_ACCOUNT_1).when(service).createAccount(MOCK_ACCOUNT_CREATE);

		mockMvc.perform(MockMvcRequestBuilders.post("/").contentType(MediaType.APPLICATION_JSON).content(postValue))
				.andExpect(status().isCreated()).andDo(print());

	}

	@Ignore
	@Test
	public void deleteAccountTest() throws Exception {
		String deleteValue = OBJECT_MAPPER.writeValueAsString(MOCK_ACCOUNT_1);

//		when(service.deleteAccount(MOCK_ACCOUNT_1)).thenReturn(MOCK_DELETE_RESPONSE);
		doReturn("Account Succesfully Deleted").when(service).deleteAccount(MOCK_ACCOUNT_1);

		mockMvc.perform(MockMvcRequestBuilders.delete("/").contentType(MediaType.APPLICATION_JSON).content(deleteValue))
				.andExpect(status().isOk()).andExpect(content().string(MOCK_DELETE_RESPONSE)).andDo(print())
				.andReturn();

	}

	
	@Ignore
	@Test
	public void updateAccountTest() throws Exception {
		String putValue = OBJECT_MAPPER.writeValueAsString(MOCK_ACCOUNT_1);

//		when(service.updateAccount(MOCK_ACCOUNT_1)).thenReturn(MOCK_ACCOUNT_1.toString());
		doReturn(MOCK_ACCOUNT_1.toString()).when(service).updateAccount(MOCK_ACCOUNT_1);

		mockMvc.perform(MockMvcRequestBuilders.put("/").contentType(MediaType.APPLICATION_JSON).content(putValue))
				.andExpect(status().isOk()).andExpect(content().string(MOCK_ACCOUNT_1.toString())).andDo(print());

	}

}
