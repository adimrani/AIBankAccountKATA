package com.bankaccount.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

	private final String id;

	private final String customerId;

	private  BigDecimal balance;

	private final List<Transaction> transactionList =  new ArrayList<Transaction>();

	public Account(String id, String customerId, BigDecimal balance) {
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

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}
}
