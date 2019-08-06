package com.bae.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.domain.Account;
import com.bae.repository.AccountRepository;

@RunWith(SpringRunner.class)
public class AccountServiceImplTest {

	@InjectMocks
	private AccountServiceImpl service;

	@Mock
	private AccountRepository repository;

	private static final Account MOCK_ACCOUNT_1 = new Account(1L, "John", "Smith");
	private static final Optional<Account> MOCK_ACCOUNT_OPTIONAL = Optional.of(MOCK_ACCOUNT_1);
	private static final Account MOCK_ACCOUNT_2 = new Account(2L, "Jane", "Doe");
	private static final String MOCK_DELETE_REPSPONSE = "Account Successfully Deleted";

	@Test
	public void findAllTest() {
		List<Account> MOCK_LIST = new ArrayList<>();

		MOCK_LIST.add(MOCK_ACCOUNT_1);
		MOCK_LIST.add(MOCK_ACCOUNT_2);

		when(repository.findAll()).thenReturn(MOCK_LIST);

		assertEquals(MOCK_LIST, service.findAll());

		verify(repository).findAll();
	}

	@Test
	public void createAccountTest() {
		when(repository.save(MOCK_ACCOUNT_1)).thenReturn(MOCK_ACCOUNT_1);

		assertEquals(MOCK_ACCOUNT_1, service.createAccount(MOCK_ACCOUNT_1));

		verify(repository).save(MOCK_ACCOUNT_1);

	}

	@Test
	public void deleteAccountTest() {
		doNothing().when(repository).delete(MOCK_ACCOUNT_1);

		assertEquals(MOCK_DELETE_REPSPONSE, service.deleteAccount(MOCK_ACCOUNT_1));

		verify(repository).delete(MOCK_ACCOUNT_1);
	}

	@Test
	public void updateAccountTest() {
		doNothing().when(repository).deleteById(MOCK_ACCOUNT_1.getId());
		when(repository.save(MOCK_ACCOUNT_1)).thenReturn(MOCK_ACCOUNT_1);
		
		
		assertEquals(MOCK_ACCOUNT_1.toString(), service.updateAccount(MOCK_ACCOUNT_1));
		
		verify(repository).deleteById(MOCK_ACCOUNT_1.getId());
		verify(repository).save(MOCK_ACCOUNT_1);
	}

	@Test
	public void findByIdTest() {
		when(repository.findById(1L)).thenReturn(MOCK_ACCOUNT_OPTIONAL);

		assertEquals(MOCK_ACCOUNT_1, service.findById(1L));

		verify(repository).findById(1L);
	}

}
