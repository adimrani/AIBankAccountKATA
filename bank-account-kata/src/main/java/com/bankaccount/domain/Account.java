package com.bankaccount.domain;

import java.util.ArrayList;
import java.util.List;

public class Account {

	private final String id;

	private final String customerId;

	private final Amount balance;

	private final List<Transaction> transactionList =  new ArrayList<Transaction>();

	public Account(String id, String customerId, Amount balance) {
		this.id = id;
		this.customerId = customerId;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public Amount getBalance() {
		return balance;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}
}
