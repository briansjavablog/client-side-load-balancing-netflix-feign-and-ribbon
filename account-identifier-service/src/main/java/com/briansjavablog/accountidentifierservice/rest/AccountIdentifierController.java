package com.briansjavablog.accountidentifierservice.rest;

import java.net.URISyntaxException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.briansjavablog.accountidentifierservice.model.AccountIdentifier;
import com.briansjavablog.accountidentifierservice.model.EnumAccountType;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AccountIdentifierController {

	@Autowired	
	private Environment environment;
	
	
	@GetMapping("/account-identifier/accountType/{accountType}")
	public ResponseEntity<AccountIdentifier> createAccountIdentifier(@PathVariable("accountType") EnumAccountType accountType, HttpServletRequest request) throws URISyntaxException {
		
		log.info("creating Account Identifier for account type [{}]", accountType);
		
		Random random = new Random(System.currentTimeMillis());
		int randomId = 10000 +  random.nextInt(20000);
		
		AccountIdentifier accountIdentifier = new AccountIdentifier	();
		
		if(accountType.equals(EnumAccountType.CURRENT_ACCOUNT)) {
			accountIdentifier.setAccountNumber("C" + randomId);
		}
		else if(accountType.equals(EnumAccountType.SAVINGS_ACCOUNT)) {
			accountIdentifier.setAccountNumber("S" + randomId);
		}
		
		accountIdentifier.setAccountIdentifierServicePort(environment.getProperty("local.server.port"));
		
		log.info("generated Account Identifier [{}]", accountIdentifier);
		
		return ResponseEntity.ok(accountIdentifier);				
	}
		
}
