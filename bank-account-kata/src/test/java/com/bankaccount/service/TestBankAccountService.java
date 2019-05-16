package com.bankaccount.service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Date;

import com.bankaccount.domain.Account;
import com.bankaccount.domain.Operation;
import com.bankaccount.domain.Transaction;
import com.bankaccount.exception.UnsuffcientBalanceException;
import com.bankaccount.utils.DateUtils;
import org.hamcrest.Matcher;
import org.junit.Test;

public class TestBankAccountService implements DateUtils {


	@Test
	public void testWithdrawalNormalScenario() throws UnsuffcientBalanceException{
		final BigDecimal balance = BigDecimal.valueOf(100);
		Account account = new Account("ACC1", "CUST1", balance);

		final BankAccountService bankAccountService = new BankAccountService(account);
		final BigDecimal withdrawalAmount = BigDecimal.valueOf(60);
		bankAccountService.withdraw(withdrawalAmount);

		final Matcher<BigDecimal> expextedBalance = is(BigDecimal.valueOf(40));
		assertThat(account.getBalance(), expextedBalance);
		assertThat(account.getTransactionList().size(), is(1));
		final Transaction transaction = account.getTransactionList().get(0);
		assertThat(transaction.getAmount(), is(withdrawalAmount));
		assertThat(transaction.getOperation(), is(Operation.WITHDRAWAL));
		assertThat(format(transaction.getDate()), is(format(new Date())));
		assertThat(transaction.getBalance(), expextedBalance);
	}

	@Test(expected = UnsuffcientBalanceException.class)
	public void testWithdrawalUnsufficientBalance() throws UnsuffcientBalanceException {
		Account account = new Account("ACC1", "CUST1", BigDecimal.valueOf(100));

		final BankAccountService bankAccountService = new BankAccountService(account);
		bankAccountService.withdraw(BigDecimal.valueOf(1000));
	}

	@Test
	public void testDeposit() {
		final BigDecimal balance = BigDecimal.valueOf(100);
		Account account = new Account("ACC1", "CUST1", balance);

		final BankAccountService bankAccountService = new BankAccountService(account);
		final BigDecimal depositAmount = BigDecimal.valueOf(200);
		bankAccountService.deposit(depositAmount);

		final BigDecimal expectedBalance = BigDecimal.valueOf(300);

		assertThat(account.getBalance(), is(expectedBalance));
		assertThat(account.getTransactionList().size(), is(1));
		final Transaction transaction = account.getTransactionList().get(0);
		assertThat(transaction.getAmount(), is(depositAmount));
		assertThat(transaction.getOperation(), is(Operation.DEPOSIT));
		assertThat(format(transaction.getDate()), is(format(new Date())));
		assertThat(transaction.getBalance(), is(expectedBalance));
	}
}
