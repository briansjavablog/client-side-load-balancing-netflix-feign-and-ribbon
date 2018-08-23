
package com.briansjavablog.accountidentifierservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class AccountIdentifier {

	@Setter
	@Getter
	private String accountNumber;
	
	@Setter
	@Getter
	private String accountIdentifierServicePort;
}
