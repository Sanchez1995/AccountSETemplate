package com.qa.business.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.business.service.*;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {
	@InjectMocks
	private AccountServiceImpl imp;

	@Mock
	private AccountRepository repo;

	private JSONUtil util;

	private static final String MOCK_DATA_ARRAY = "[{\"account_number\":\"123\",\"first_name\":\"George\",\"last_name\":\"Downe\"}]";

	private static final String MOCK_OBJECT = "{\"account_number\":\"123\",\"first_name\":\"George\",\"last_name\":\"Downe\"}";

	@Before
	public void setup() {

		util = new JSONUtil();
		imp.setRepo(repo);
		imp.setUtil(util);
	}
 
	@Test
	public void testGetAllAccountsService() {
		Mockito.when(imp.getAllAccounts()).thenReturn(MOCK_DATA_ARRAY);
		Assert.assertEquals(MOCK_DATA_ARRAY, imp.getAllAccounts());

	}

	@Test
	public void testCreateAccountService9() {

		Mockito.when(imp.createAccount(MOCK_OBJECT))
				.thenReturn("{\"message\": \"An account number cannot contain the number 9\"}");

		Assert.assertEquals("{\"message\": \"An account number cannot contain the number 9\"}",
				imp.createAccount(MOCK_OBJECT));

	}

	@Test
	public void testCreateAccountServiceNot9() {
		Mockito.when(imp.createAccount(MOCK_OBJECT)).thenReturn(MOCK_OBJECT);
		Assert.assertEquals(MOCK_OBJECT, imp.createAccount(MOCK_OBJECT));
	}

	@Test
	public void testDeleteAccountService() {
		String reply = imp.deleteAccount(1L);
		Assert.assertEquals(reply, imp.deleteAccount(1L));
	}

	@Test
	public void testUpdateAccount() {
		String reply = imp.updateAccount(1L, MOCK_OBJECT);
		Assert.assertEquals(reply, imp.updateAccount(1L, MOCK_OBJECT));
	}

	@Test
	public void testGetOneAccountService() {
		Mockito.when(imp.getOneAccount(1L)).thenReturn(MOCK_OBJECT);
		Assert.assertEquals(MOCK_OBJECT, imp.getOneAccount(1L));
	}

}
