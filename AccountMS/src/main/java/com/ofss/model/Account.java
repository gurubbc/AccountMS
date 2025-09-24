package com.ofss.model;

import java.time.LocalDate;

public class Account {
	private int accountId; // ACCOUNT_ID
	private String accountType; // ACCOUNT_TYPE
	private LocalDate accountCreationDate; // ACCOUNT_CREATION_DATE
	private double accountBalance; // ACCOUNT_BALANCE
//	private Customer customer; // TIGHTLY COUPLED architecture
	private int customerId;  // CUSTOMER_ID
	private int bankId; // BANK_ID
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountId, String accountType, LocalDate accountCreationDate, double accountBalance,
			int customerId, int bankId) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountCreationDate = accountCreationDate;
		this.accountBalance = accountBalance;
		this.customerId = customerId;
		this.bankId = bankId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public LocalDate getAccountCreationDate() {
		return accountCreationDate;
	}
	public void setAccountCreationDate(LocalDate accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	
	
	
}
