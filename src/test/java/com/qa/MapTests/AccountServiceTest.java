package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;

public class AccountServiceTest {

	private AccountMapRepository acc;

	private static final String MOCK_OBJECT = "{\"id\":1,\"account_number\":\"12\",\"first_name\":\"g\",\"last_name\":\"d\"}";

	@Before
	public void setup() {
		acc = new AccountMapRepository();
	}

	@Test
	public void addAccountTest() {
		String reply = acc.createAccount(MOCK_OBJECT);
		Assert.assertEquals(reply, "Account Created");
	}

	@Test
	@Ignore
	public void add2AccountsTest() {
		fail("TODO");
	}

	@Test
	@Ignore
	public void removeAccountTest() {
		fail("TODO");
	}

	@Test
	@Ignore
	public void remove2AccountsTest() {
		fail("TODO");
	}

	@Test
	@Ignore
	public void remove2AccountTestAnd1ThatDoesntExist() {
		fail("TODO");
	}

	@Test
	@Ignore
	public void jsonStringToAccountConversionTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	@Ignore
	public void accountConversionToJSONTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	@Ignore
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Test
	@Ignore
	public void getCountForFirstNamesInAccountWhenOne() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Test
	@Ignore
	public void getCountForFirstNamesInAccountWhenTwo() {
		// For a later piece of functionality
		fail("TODO");
	}

}
