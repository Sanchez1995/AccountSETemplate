package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

public class AccountServiceImpl implements AccountService {
	@Inject
	private AccountRepository repo;
	@Inject
	private JSONUtil util;

	public String getAllAccounts() {

		return repo.getAllAccounts();
	}

	public String createAccount(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		if (anAccount.getAccount_number().contains("9")) {
			return repo.createAccount(account);
		} else {
			return "{\"message\": \"An account number cannot contain the number 9\"}";
		}
	}

	public String deleteAccount(Long id) {

		return repo.deleteAccount(id);
	}

	public String updateAccount(Long id, String account) {

		return repo.updateAccount(id, account);
	}

	public String getOneAccount(Long id) {

		return repo.getOneAccount(id);
	}
}
