package com.briansjavablog.microservices.bankaccount.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BankAccount {

	@Setter
	@Getter
	private String accountName;

	@Setter
	@Getter
	private EnumAccountType accountType;

	@Setter
	@Getter
	private BigDecimal accountBlance;
}
