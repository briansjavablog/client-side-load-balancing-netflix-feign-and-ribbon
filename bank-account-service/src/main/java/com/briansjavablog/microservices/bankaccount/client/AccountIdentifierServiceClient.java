package com.briansjavablog.microservices.bankaccount.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.briansjavablog.microservices.bankaccount.model.AccountIdentifier;

@FeignClient(name="account-identifier-service", configuration=FeignConfiguration.class)
public interface AccountIdentifierServiceClient {
	
	@GetMapping(path = "account-identifier/accountType/{accountType}")
	public AccountIdentifier getAccountIdentifier(@PathVariable("accountType") String accountType);
	
}
