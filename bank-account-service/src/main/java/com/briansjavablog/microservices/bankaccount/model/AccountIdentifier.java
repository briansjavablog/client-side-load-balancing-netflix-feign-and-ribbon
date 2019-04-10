package com.briansjavablog.microservices.bankaccount.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountIdentifier {

	@Setter
	@Getter
	private String accountNumber;
	
	@Setter
	@Getter
	private String accountIdentifierServicePort;
}
