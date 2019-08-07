package com.bae.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bae.domain.Account;
import com.bae.service.AccountService;

@RestController
public class AccountController {

	private AccountService accountService;
	private RestTemplate restTemplate;
	
	private static final String ACC_NO_URL = "http://localhost:8081/getAccNo";
	private static final String PRIZE_URL = "http://localhost:8082/getPrize";

	@Autowired
	public AccountController(AccountService accountService, RestTemplate restTemplate) {
		this.accountService = accountService;
		this.restTemplate = restTemplate;
	}

	public AccountController() {

	}

	@GetMapping("/all")
	public List<Account> findAll() {
		return accountService.findAll();

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> findById(@PathVariable("id") Long accountId){
		Account account = accountService.findById(accountId);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		String accountNumber = restTemplate.exchange(ACC_NO_URL, HttpMethod.GET, null, String.class).getBody();
		String prize = restTemplate.exchange(PRIZE_URL, HttpMethod.GET, null, String.class).getBody();
		
		account.setAccountNumber(accountNumber);
		account.setPrize(prize);		
		
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
