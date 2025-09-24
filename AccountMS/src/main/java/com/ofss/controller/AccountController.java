package com.ofss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/accounts", method=RequestMethod.GET)
	public ResponseEntity<Object> getAllAccounts() {
		return accountService.getAllAccounts();
	}
	
	@RequestMapping(value="/accounts/id/{accountId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getAllAccounts(@PathVariable("accountId") int aId) {
		return accountService.getAccountById(aId);
	}
	
	// For a given account id, along with account details I also want customer details
	// and bank details
	@RequestMapping(value="/accounts/id/{accountId}/details", method=RequestMethod.GET)
	public ResponseEntity<Object> getAccountsDetailsById(@PathVariable("accountId") int aId){
		return accountService.getAccountsDetailsById(aId);
	}

}
