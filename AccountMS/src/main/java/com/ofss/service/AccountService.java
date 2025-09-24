package com.ofss.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ofss.model.Account;
import com.ofss.model.AccountDTO;

@Service
public class AccountService {

	
	@Autowired
	RestTemplate restTemplate;
	// Let's create some AccountService objects manually and add it to ArrayList
	ArrayList<Account> allAccounts;

	public AccountService() {
		allAccounts = new ArrayList<>();
		Account acc1 = new Account(101, "Savings", LocalDate.of(2004, 06, 23), 25000.0, 1, 1);
		Account acc2 = new Account(102, "Salary", LocalDate.of(2005, 06, 22), 15000.0, 2, 2);
		Account acc3 = new Account(103, "Current", LocalDate.of(2025, 9, 24), 222000.0, 3, 3);
		Account acc4 = new Account(104, "Savings", LocalDate.of(2003, 11, 12), 88000.0, 4, 4);
		Account acc5 = new Account(105, "Savings", LocalDate.of(2004, 06, 19), 17000.0, 5, 5);
		allAccounts.add(acc1);
		allAccounts.add(acc2);
		allAccounts.add(acc3);
		allAccounts.add(acc4);
		allAccounts.add(acc5);
		System.out.println("Intialized Account details");
	}

	public ResponseEntity<Object> getAllAccounts() {
		return ResponseEntity.status(HttpStatus.OK).body(allAccounts);
	}

	public ResponseEntity<Object> getAccountById(int accountId) {
		for (Account a : allAccounts) {
			if (a.getAccountId() == accountId) {
				return ResponseEntity.status(HttpStatus.OK).body(a);
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such account id is present");
	}

	public ResponseEntity<Object> getAccountsDetailsById(int accountId){
		Account existingAccount=null;
		
		Object customer=null;
		Object bank=null;
		AccountDTO accountDTO=new AccountDTO();
		
		for (Account a:allAccounts) {
			if (a.getAccountId()==accountId) {
				existingAccount=a;
				break;
			}
		}
		
		if (existingAccount!=null) {
			// lets retrieve the customer id
			int custId=existingAccount.getCustomerId();
			// I will pass this custId to CustomerMS that will return me Customer object
			// I will inject Account object and returned Customer object into AccountDTO object
			// return this AccountDTO
			// call the following method from here
			customer=getCustomerForGivenCustomerId(custId);
			bank=getBankForGivenCustomerId(existingAccount.getBankId());
			// let's inject customer into accountdto
			accountDTO.setAccount(existingAccount); // all account details
			accountDTO.setCustomer(customer);
			accountDTO.setBank(bank);
			return ResponseEntity.status(HttpStatus.OK).body(accountDTO);
		}
		
		// failure, no such account id is existing
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such acccount id is present");
	
	}
	
	public Object getCustomerForGivenCustomerId(int custId) {
		// we are going to call CUSTOMERMS endpoint /customers/id/{customerId}
		String serviceURL="http://localhost:CUSTOMERMS";
//		restTemplate.getForObject(serviceURL, endpoint, returndatatype, pathvariable);
		return restTemplate.getForObject("http://CUSTOMERMS/customers/id/{id}", Object.class, custId);
	}
	
	public Object getBankForGivenCustomerId(int bankId) {
		// we are going to call CUSTOMERMS endpoint /customers/id/{customerId}
		String serviceURL="http://localhost:BANKMS";
//		restTemplate.getForObject(serviceURL, endpoint, returndatatype, pathvariable);
		return restTemplate.getForObject("http://BANKMS/banks/id/{id}", Object.class, bankId);
	}
	
}	
	

