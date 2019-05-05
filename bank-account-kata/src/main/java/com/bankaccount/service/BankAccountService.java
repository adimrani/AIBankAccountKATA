package com.bankaccount.service;

import java.math.BigDecimal;
import java.util.Date;

import com.bankaccount.domain.Account;
import com.bankaccount.domain.Operation;
import com.bankaccount.domain.Transaction;
import com.bankaccount.exception.UnsuffcientBalanceException;

public class BankAccountService {

	private final Account bankAccount;

	public BankAccountService(Account bankAccount) {
		this.bankAccount = bankAccount;
	}

	public void withdraw(BigDecimal withdrawalAmount) {
		final BigDecimal actualBalanceValue = bankAccount.getBalance();
		if (actualBalanceValue.compareTo(withdrawalAmount) > 0) {
			bankAccount.setBalance(actualBalanceValue.subtract(withdrawalAmount));
			Transaction withdrawalTransaction = new Transaction(new Date(), withdrawalAmount, Operation.WITHDRAWAL, bankAccount.getBalance());
			bankAccount.getTransactionList().add(withdrawalTransaction);
		}
		else {
			throw new UnsuffcientBalanceException("Your balance is not sufficient");
		}
	}

	public void deposit(BigDecimal depositAmount) {
		bankAccount.setBalance(bankAccount.getBalance().add(depositAmount));
		Transaction depositTransaction = new Transaction(new Date(), depositAmount, Operation.DEPOSIT, bankAccount.getBalance());
		bankAccount.getTransactionList().add(depositTransaction);
	}

}
