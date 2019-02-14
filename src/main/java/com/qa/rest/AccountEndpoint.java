package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.AccountService;

@Path("/account")
public class AccountEndpoint {
	@Inject
	AccountService svc;

	@Path("/getAllAccounts")
	@GET
	@Produces("application/json")
	public String getAllAccounts() {
		return svc.getAllAccounts();
	}

	@Path("/createAccount")
	@PUT
	@Produces("application/json")
	public String createAccount(String account) {
		return svc.createAccount(account);
	}

	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces("application/json")
	public String deleteAccount(@PathParam("id") Long id) {
		return svc.deleteAccount(id);
	}

	@Path("/getOneAccount/{id}")
	@GET
	@Produces("application/json")
	public String getOneAccount(@PathParam("id") Long id) {
		return svc.getOneAccount(id);
	}

	@Path("/updateAccount/{id}")
	@PUT
	@Produces("application/json")
	public String updateAccount(@PathParam("id") Long id, String account) {
		return svc.updateAccount(id, account);
	}

	public void setService(AccountService svc2) {
		this.svc = svc2;
		
	}
	
}
