package com.bankaccount.exception;

public class UnsuffcientBalanceException extends RuntimeException {
	public UnsuffcientBalanceException(String message) {
		super(message);
	}
}
