package com.qa.persistence.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Account;

import com.qa.util.*;
@Alternative
public class AccountMapRepository implements AccountRepository {

	Map<Long, Account> accountMap = new HashMap<Long, Account>();
	private JSONUtil util = new JSONUtil();

	public String getAllAccounts() {

		return util.getJSONForObject(accountMap.values());
	}

	public String createAccount(String account) {

		Account secondAccount = util.getObjectForJSON(account, Account.class);

		accountMap.put(secondAccount.getId(), secondAccount);

		return "{\"message\": \"Account created\"}";
	}

	public String deleteAccount(Long id) {
		if (accountMap.containsKey(id)) {
			accountMap.remove(id);

		}
		return "{\"message\": \"Account deleted\"}";
	}

	public String updateAccount(Long id, String account) {
		if (accountMap.containsKey(id)) {
			deleteAccount(id);
			createAccount(account);
		}

		return "{\"message\": \"Account updated\"}";
	}

	public int checkName(String testName) {

		return (int) accountMap.values().stream().filter(n -> n.getFirst_name().contentEquals(testName)).count();

	}

	public String getOneAccount(Long id) {

		return util.getJSONForObject(accountMap.get(id));

	}

	@Override
	public void setUtil(JSONUtil util) {
		this.util = util;
		
	}

}
