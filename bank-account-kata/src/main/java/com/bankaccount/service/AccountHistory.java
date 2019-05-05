package com.bankaccount.service;

import java.util.List;

import com.bankaccount.domain.Account;
import com.bankaccount.utils.DateUtils;

public class AccountHistory implements DateUtils {

	private final Account account;


	public AccountHistory(Account account) {
		this.account = account;
	}


	public List<String> getHistory() {
		
		return null;
	}

}
