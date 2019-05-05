package com.bankaccount.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {

	private final Date date;

	private final BigDecimal amount;

	private final Operation operation;

	public Transaction(Date date, BigDecimal amount, Operation operation) {
		this.date = date;
		this.amount = amount;
		this.operation = operation;
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
}
