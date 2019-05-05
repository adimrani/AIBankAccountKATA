package com.bankaccount.service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Date;

import com.bankaccount.domain.Account;
import com.bankaccount.domain.Operation;
import com.bankaccount.domain.Transaction;
import com.bankaccount.utils.DateUtils;
import org.hamcrest.Matcher;
import org.junit.Test;

public class TestBankAccountService implements DateUtils {

	@Test
	public void testWithdrawalNormalScenario() {
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
	
}
