package com.bankaccount.exception;

//a good practice because RuntimeException does not have to be declared in a method's throws
public class UnsuffcientBalanceException extends RuntimeException {
	public UnsuffcientBalanceException(String message) {
		super(message);
	}
}
