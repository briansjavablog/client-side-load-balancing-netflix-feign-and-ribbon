package com.briansjavablog.microservices.bankaccountservice.rest;

import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.briansjavablog.microservices.bankaccountservice.model.AccountIdentifier;
import com.briansjavablog.microservices.bankaccountservice.model.BankAccount;
import com.briansjavablog.microservices.client.AccountIdentifierServiceClient;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BankAccountController {

	@Autowired
	public AccountIdentifierServiceClient accountIdentifierServiceClient; 
	
	
	@PostMapping("/bank-account")
	public ResponseEntity<AccountIdentifier> createBankAccount(@RequestBody BankAccount bankAccount, HttpServletRequest request) throws URISyntaxException {
		
		log.info("creating bank account {}", bankAccount);
		
		AccountIdentifier accountIdentifier = accountIdentifierServiceClient.getAccountIdentifier(bankAccount.getAccountType().getValue());
		
		log.info("created Account Identifier [{}]", accountIdentifier);
		
		return ResponseEntity.ok(accountIdentifier);				
	}
		
}
