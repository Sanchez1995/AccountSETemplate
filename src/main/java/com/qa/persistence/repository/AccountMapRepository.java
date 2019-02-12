package com.qa.persistence.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;

import com.qa.util.*;

public class AccountMapRepository implements AccountRepository {

	Map<Long, Account> accountMap = new HashMap<Long, Account>();
	private JSONUtil util = new JSONUtil();
	

	public String getAllAccounts() {

		return util.getJSONForObject(accountMap.values());
	}

	public String createAccount(String account) {

		Account secondAccount = util.getObjectForJSON(account, Account.class);

		accountMap.put(secondAccount.getId(), secondAccount);

		return "Account Created";
	}

	public String deleteAccount(Long id) {
		accountMap.remove(id);
		return "Account Deleted";
	}

	public String updateAccount(Long id, String account) {

		deleteAccount(id);
		createAccount(account);

		return "Account Updated";
	}

}
