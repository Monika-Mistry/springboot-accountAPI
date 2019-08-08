package com.bae.service;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.repository.AccountRepository;

@RunWith(SpringRunner.class)
public class AccountListenerTest {
	
	@InjectMocks
	private AccountListener listener;
	
	@Mock
	private AccountRepository repository;
	
	

}
