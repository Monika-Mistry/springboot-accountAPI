package com.bae.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bae.domain.Account;
import com.bae.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	
	private AccountRepository accountRepository;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;

	}
	
	public AccountServiceImpl() {

	}
	

	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	public String deleteAccount(Account account) {
		accountRepository.delete(account);
		return "Account Successfully Deleted";
	}

	public String updateAccount(Account account) {
		accountRepository.deleteById(account.getId());
		
		accountRepository.save(account);
		
		return account.toString();
	}

}
