package com.bankaccount.service;

import java.math.BigDecimal;

import com.bankaccount.domain.Account;

public class BankAccountService {
	
	private final Account bankAccount;

	public BankAccountService(Account bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public void withdraw(BigDecimal withdrawalAmount) {
		
	}

}
