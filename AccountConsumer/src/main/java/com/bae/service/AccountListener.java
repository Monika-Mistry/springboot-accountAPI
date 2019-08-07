package com.bae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.bae.domain.SentAccount;

import com.bae.repository.AccountRepository;

@Component
public class AccountListener {
	
	private AccountRepository repository;
	
	@Autowired
	public AccountListener(AccountRepository repository) {
		this.repository = repository;
	}
	
	 @JmsListener(destination = "AccountQueue", containerFactory = "jmsFactory")
	 public void receiveMessage(SentAccount account){
		 System.out.println("Received <" + account + ">");
		 
		 repository.save(account);
		 
		 System.out.println(account + " processed ...");

	 }
}
