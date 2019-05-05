package com.bankaccount.domain;


import java.math.BigDecimal;

public class Amount {

	private BigDecimal value;

	private final Currency currency;


	public Amount(BigDecimal value, Currency currency) {
		this.value = value;
		this.currency = currency;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Currency getCurrency() {
		return currency;
	}
}
