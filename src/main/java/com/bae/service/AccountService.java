package com.bae.service;

import java.util.List;

import com.bae.domain.Account;

public interface AccountService {
	
	public List<Account> findAll();
	
	public Account createAccount(Account account);
	
	public String deleteAccount(Account account);
	
	public String updateAccount(Account account);

}
