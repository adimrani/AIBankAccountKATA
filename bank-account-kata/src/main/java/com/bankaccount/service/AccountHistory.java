package com.bankaccount.service;

import java.util.List;
import java.util.stream.Collectors;

import com.bankaccount.domain.Account;
import com.bankaccount.domain.Transaction;
import com.bankaccount.utils.DateUtils;

public class AccountHistory implements DateUtils {

	private final Account account;


	public AccountHistory(Account account) {
		this.account = account;
	}

	public List<String> getHistory() {
		
		final List<Transaction> transactionList = account.getTransactionList();
		return transactionList.stream()
				.map(tx -> tx.getOperation().toString() + ", " + format(tx.getDate()) + ", " + tx.getAmount().toEngineeringString() + ", " + tx.getBalance())
				.collect(Collectors.toList());
	}

}
