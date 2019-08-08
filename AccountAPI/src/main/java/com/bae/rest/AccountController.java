package com.bae.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bae.domain.Account;
import com.bae.domain.SentAccount;
import com.bae.service.AccountService;

@RestController
public class AccountController {

	private AccountService accountService;
	private RestTemplate restTemplate;
	private JmsTemplate jmsTemplate;

	private static final String ACC_NO_URL = "http://localhost:8081/getAccNo";
	private static final String PRIZE_URL = "http://localhost:8082/getPrize";

	@Autowired
	public AccountController(AccountService accountService, RestTemplate restTemplate, JmsTemplate jmsTemplate) {
		this.accountService = accountService;
		this.restTemplate = restTemplate;
		this.jmsTemplate = jmsTemplate;
	}

	public AccountController() {

	}

	@GetMapping("/all")
	public List<Account> findAll() {
		return accountService.findAll();

	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> findById(@PathVariable("id") Long accountId) {
		Account account = accountService.findById(accountId);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account createAccount = new Account();
		
		ResponseEntity<String> getAccNo = restTemplate.exchange(ACC_NO_URL, HttpMethod.GET, null, String.class);
		ResponseEntity<String> getPrize = restTemplate.exchange(PRIZE_URL, HttpMethod.GET, null, String.class);
		
		String accountNumber = getAccNo.getBody();
		String prize = getPrize.getBody();

		createAccount.setFirstName(account.getFirstName());
		createAccount.setLastName(account.getLastName());
		createAccount.setAccountNumber(accountNumber);
		createAccount.setPrize(prize);
	
//		Account newAccount = accountService.createAccount(createAccount);
//		
//		sendToQueue(newAccount);
//		
//		
//		return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
		
		
		sendToQueue(createAccount);
		return new ResponseEntity<>(accountService.createAccount(createAccount), HttpStatus.CREATED);
	}

	@DeleteMapping
	public String deleteAccount(@RequestBody Account account) {
		return accountService.deleteAccount(account);
	}

	@PutMapping
	public String updateAccount(@RequestBody Account account) {
		return accountService.updateAccount(account);
	}
	
	private void sendToQueue(Account account){
        SentAccount accountToStore =  new SentAccount(account);
        jmsTemplate.convertAndSend("AccountQueue", accountToStore);
    }

}
