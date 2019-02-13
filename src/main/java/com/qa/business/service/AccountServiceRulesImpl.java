package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.AccountRepository;

public class AccountServiceRulesImpl {
	@Inject
	private AccountRepository repo;

	public String getAllAccounts() {

		return repo.getAllAccounts();
	}

	public String createAccount(String account) {

		return repo.createAccount(account);
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
