package com.qa.service.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class AccountDBRepositoryTest {
	@InjectMocks
	private AccountDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	private static final String MOCK_DATA_ARRAY = "[{\"account_number\":\"123\",\"first_name\":\"George\",\"last_name\":\"Downe\"}]";

	private static final String MOCK_OBJECT = "{\"account_number\":\"123\",\"first_name\":\"George\",\"last_name\":\"Downe\"}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllAccounts() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("123", "George", "Downe"));
		Mockito.when(query.getResultList()).thenReturn(accounts);
		System.out.println(repo.getAllAccounts());
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllAccounts());
	}

	@Test
	public void testGetOneAccount() {
		System.out.println(repo.getOneAccount(1L));
		Account anAccount = new Account("123", "George", "Downe");
		Mockito.when(manager.find(Account.class, 1L)).thenReturn(anAccount);
		Assert.assertEquals(MOCK_OBJECT, repo.getOneAccount(1L));
	}

	@Test
	public void testDeleteAccount() {
		String reply = repo.deleteAccount(1L);
		Assert.assertEquals(reply, "{\"message\": \"Account sucessfully deleted\"}");
	}

	@Test
	public void testCreateAccount() {
		String reply = repo.createAccount(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Account has been succesfully added\"}");
	}

	@Test
	public void testUpdateAccount() {
		String reply = repo.updateAccount(1L, MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Account sucessfully updated\"}");
	}
}
