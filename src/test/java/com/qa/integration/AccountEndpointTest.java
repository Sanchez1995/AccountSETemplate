package com.qa.integration;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.AccountService;
import com.qa.rest.AccountEndpoint;



@RunWith(MockitoJUnitRunner.class)
public class AccountEndpointTest {
	private static final String MOCK_VALUE="test_value"; 
	
	@InjectMocks 
	private AccountEndpoint endpoint; 
	
	@Mock 
	private AccountService svc; 
	
	@Before 
	public void setup() { 
		endpoint.setService(svc);
	} 
	
	@Test 
	@Ignore 
	public void testGetAllAccounts() { 
		Mockito.when(svc.getAllAccounts()).thenReturn(MOCK_VALUE); 
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllAccounts());
	} 
	@Test 
	@Ignore 
	public void testCreateAccount() { 
		Mockito.when(svc.createAccount(MOCK_VALUE)).thenReturn(MOCK_VALUE);
	} 
	@Test 
	@Ignore 
	public void testDeleteMovie() { 
		Mockito.when(svc.deleteAccount(1L)).thenReturn(MOCK_VALUE); 
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteAccount(1L)); 
		Mockito.verify(svc).deleteAccount(1L);
	}
}
