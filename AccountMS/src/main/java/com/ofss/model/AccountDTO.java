package com.ofss.model;

// AccountDTO = Account object + Customer Object
public class AccountDTO {
	private Account account;
	private Object customer;
	private Object bank;
	
	public AccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDTO(Account account, Object customer, Object bank) {
		super();
		this.account = account;
		this.customer = customer;
		this.bank=bank;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Object getCustomer() {
		return customer;
	}
	public void setCustomer(Object customer) {
		this.customer = customer;
	}
	public Object getBank() {
		return bank;
	}
	public void setBank(Object bank) {
		this.bank = bank;
	}
	
	
	
	
	
	
}
