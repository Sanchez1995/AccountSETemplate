package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;

import com.qa.util.*;

@Default
@Transactional(SUPPORTS)
public class AccountDBRepository implements AccountRepository {

	private JSONUtil util = new JSONUtil();
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Override
	public String getAllAccounts() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account aAccount = util.getObjectForJSON(account, Account.class);
		manager.persist(aAccount);
		return "{\"message\": \"Account has been succesfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {

		if (manager.contains(manager.find(Account.class, id))) {
			manager.remove(manager.find(Account.class, id));
		}

		return "{\"message\": \"Account sucessfully deleted\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String account) {

		if (manager.contains(manager.find(Account.class, id))) {
			deleteAccount(id);
			createAccount(account);
		}
		return "{\"message\": \"Account sucessfully updated\"}";
	}

	@Override
	public String getOneAccount(Long id) {
		return util.getJSONForObject(manager.find(Account.class, id));

	}

	public void setManager(EntityManager manager2) {
		this.manager = manager2;

	}

	public void setUtil(JSONUtil util2) {
		this.util = util2;

	}

}
