package com.briansjavablog.accountidentifierservice.model;

import java.util.Arrays;

public enum EnumAccountType {

	CURRENT_ACCOUNT("currentAccount"),
	SAVINGS_ACCOUNT("savingsAccount");
	
	private String value;

	private EnumAccountType(String value) {
		this.value = value;
	}

	public static EnumAccountType fromValue(String value) {
		
		return Arrays.stream(EnumAccountType.values())
					 .filter(accountType -> accountType.value.equals(value))
					 .findFirst()
					 .orElseThrow(() -> new IllegalArgumentException("Unknown EnumAccountType " + value + ", Allowed EnumAccountType are " + values()));		
	}
}
