package com.bankaccount.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.bankaccount.domain.Account;
import com.bankaccount.utils.DateUtils;
import org.junit.Test;

public class TestAccountHistory implements DateUtils {


	@Test
	public void shouldPrintHistory() {
		final BigDecimal balance = BigDecimal.valueOf(100);
		Account account = new Account("ACC1", "CUST1", balance);
		final BankAccountService bankAccountService = new BankAccountService(account);
		final BigDecimal withdrawalAmount = BigDecimal.valueOf(60);
		final BigDecimal depositAmount = BigDecimal.valueOf(35);


		bankAccountService.withdraw(withdrawalAmount);
		bankAccountService.deposit(depositAmount);
		AccountHistory accountHistory = new AccountHistory(account);

		final List<String> history = accountHistory.getHistory();
		assertThat(history, hasSize(2));
		final String withdrawalOp = String.format("WITHDRAWAL, %s, %s, 40", format(new Date()), withdrawalAmount.toPlainString());
		final String depositOp = String.format("DEPOSIT, %s, %s, 75", format(new Date()), depositAmount.toPlainString());
		assertThat(history, containsInAnyOrder(withdrawalOp, depositOp));
	}

}
