package com.bankaccount.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {

	private final Date date;

	private final BigDecimal amount;

	private final Operation operation;

	private final BigDecimal balance;

	public Transaction(Date date, BigDecimal amount, Operation operation, BigDecimal balance) {
		this.date = date;
		this.amount = amount;
		this.operation = operation;
		this.balance = balance;
	}

	public Date getDate() {
		return date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Operation getOperation() {
		return operation;
	}

	public BigDecimal getBalance() {
		return balance;
	}
}
