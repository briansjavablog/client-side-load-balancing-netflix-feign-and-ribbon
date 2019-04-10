package com.briansjavablog.microservices.bankaccount.rest;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.briansjavablog.microservices.bankaccount.client.AccountIdentifierServiceClient;
import com.briansjavablog.microservices.bankaccount.model.AccountIdentifier;
import com.briansjavablog.microservices.bankaccount.model.BankAccount;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BankAccountController {

	@Autowired
	public AccountIdentifierServiceClient accountIdentifierServiceClient; 
	
	@PostMapping("/bank-account")
	public ResponseEntity<AccountIdentifier> createBankAccount(@RequestBody BankAccount bankAccount) throws URISyntaxException {
		
		log.info("creating bank account {}", bankAccount);
		
		AccountIdentifier accountIdentifier = accountIdentifierServiceClient.getAccountIdentifier(bankAccount.getAccountType().getValue());
		
		log.info("created Account Identifier [{}]", accountIdentifier);
		
		return ResponseEntity.ok(accountIdentifier);				
	}
		
}
