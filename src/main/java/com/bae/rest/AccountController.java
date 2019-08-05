package com.bae.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.domain.Account;
import com.bae.service.AccountService;

@RestController
public class AccountController {

	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	public AccountController() {

	}

	@GetMapping("/all")
	public List<Account> findAll() {
		return accountService.findAll();

	}
	
	@GetMapping("/{id}")
	public Account findById(@PathVariable("id") Long accountId){
		return accountService.findById(accountId);
	}
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account newAccount = accountService.createAccount(account);
		return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
	}
	
	@DeleteMapping
	public String deleteAccount(@RequestBody Account account) {
		return accountService.deleteAccount(account);
	}
	
	@PutMapping
	public String updateAccount(@RequestBody Account account) {
		return accountService.updateAccount(account);
	}
	


}
