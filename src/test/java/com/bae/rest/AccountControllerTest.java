package com.bae.rest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
	private static final String MOCK_DELETE_REPSPONSE = "Account Successfully Deleted";
	
	
	
	@Test
	public void findAllTest() {
		List<Account> MOCK_LIST = new ArrayList<>();
		
		MOCK_LIST.add(MOCK_ACCOUNT_1);
		MOCK_LIST.add(MOCK_ACCOUNT_2);
		
		Mockito.when(service.findAll()).thenReturn(MOCK_LIST);
		
		assertEquals(MOCK_LIST, controller.findAll());
		
		Mockito.verify(service).findAll();
	}
	
	@Test
	public void createAccountTest() {
		Mockito.when(service.createAccount(MOCK_ACCOUNT_1)).thenReturn(MOCK_ACCOUNT_1);
		
		assertEquals(MOCK_ACCOUNT_1, controller.createAccount(MOCK_ACCOUNT_1).getBody());
		
		Mockito.verify(service).createAccount(MOCK_ACCOUNT_1);
		
	}
	
	@Test
	public void deleteAccountTest() {
		Mockito.when(service.deleteAccount(MOCK_ACCOUNT_1)).thenReturn(MOCK_DELETE_REPSPONSE);
		
		assertEquals(MOCK_DELETE_REPSPONSE, controller.deleteAccount(MOCK_ACCOUNT_1));
		
		Mockito.verify(service).deleteAccount(MOCK_ACCOUNT_1);
	} 
	
	@Test
	public void updateAccountTest() {
		Mockito.when(service.updateAccount(MOCK_ACCOUNT_1)).thenReturn(MOCK_ACCOUNT_1.toString());
		
		assertEquals(MOCK_ACCOUNT_1.toString(), controller.updateAccount(MOCK_ACCOUNT_1));
		
		Mockito.verify(service).updateAccount(MOCK_ACCOUNT_1);
	}
	
	@Test
	public void findByIdTest() {
		Mockito.when(service.findById(1L)).thenReturn(MOCK_ACCOUNT_1);
		
		assertEquals(MOCK_ACCOUNT_1, controller.findById(1L).getBody());
		
		Mockito.verify(service).findById(1L);
	}
	

}
