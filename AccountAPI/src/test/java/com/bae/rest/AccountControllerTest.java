package com.bae.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.domain.Account;
import com.bae.service.AccountService;

@RunWith(SpringRunner.class)
public class AccountControllerTest {
	
	@InjectMocks
	private AccountController controller;
	
	@Mock
	private AccountService service;
	
	private static final Account MOCK_ACCOUNT_1 = new Account(1L, "John", "Smith");
	private static final Account MOCK_ACCOUNT_2 = new Account(2L, "Jane", "Doe");
	private static final String MOCK_DELETE_RESPONSE = "Account Successfully Deleted";
	
	private static final String MOCK_ACCOUNT_NO = "A123456";
	private static final String MOCK_PRIZE = "£0";
	private static final String ACC_NO_URL = "http://localhost:8081/getAccNo";
	private static final String PRIZE_URL = "http://localhost:8082/getPrize/";
	
	
	
	@Test
	public void findAllTest() {
		List<Account> MOCK_LIST = new ArrayList<>();
		
		MOCK_LIST.add(MOCK_ACCOUNT_1);
		MOCK_LIST.add(MOCK_ACCOUNT_2);
		
		when(service.findAll()).thenReturn(MOCK_LIST);
		
		assertEquals(MOCK_LIST, controller.findAll());
		
		verify(service).findAll();
	}
	
	@Test
	public void createAccountTest() {
		when(service.createAccount(MOCK_ACCOUNT_1)).thenReturn(MOCK_ACCOUNT_1);
		
		assertEquals(MOCK_ACCOUNT_1, controller.createAccount(MOCK_ACCOUNT_1).getBody());
		
		verify(service).createAccount(MOCK_ACCOUNT_1);
		
	}
	
	@Test
	public void deleteAccountTest() {
		when(service.deleteAccount(MOCK_ACCOUNT_1)).thenReturn(MOCK_DELETE_RESPONSE);
		
		assertEquals(MOCK_DELETE_RESPONSE, controller.deleteAccount(MOCK_ACCOUNT_1));
		
		verify(service).deleteAccount(MOCK_ACCOUNT_1);
	} 
	
	@Test
	public void updateAccountTest() {
		when(service.updateAccount(MOCK_ACCOUNT_1)).thenReturn(MOCK_ACCOUNT_1.toString());
		
		assertEquals(MOCK_ACCOUNT_1.toString(), controller.updateAccount(MOCK_ACCOUNT_1));
		
		verify(service).updateAccount(MOCK_ACCOUNT_1);
	}
	
	@Test
	public void findByIdTest() {
		when(service.findById(1L)).thenReturn(MOCK_ACCOUNT_1);
		
		assertEquals(MOCK_ACCOUNT_1, controller.findById(1L).getBody());
		
		verify(service).findById(1L);
	}
	

}
