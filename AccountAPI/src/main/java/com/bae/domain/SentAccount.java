package com.bae.domain;


public class SentAccount {

	private Long id;

	private String firstName;

	private String lastName;

	private String accountNumber;

	private String prize;

	public SentAccount() {

	}

	public SentAccount(Account account) {
		this.id = account.getId();
		this.firstName = account.getFirstName();
		this.lastName = account.getLastName();
		this.accountNumber = account.getAccountNumber();
		this.prize = account.getPrize();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

}
