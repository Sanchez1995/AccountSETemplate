package com.qa.persistence.repository;

import com.qa.util.JSONUtil;

public interface AccountRepository {

	String getAllAccounts();

	String createAccount(String account);

	String deleteAccount(Long id);

	String updateAccount(Long id, String account);

	String getOneAccount(Long id);

	void setUtil(JSONUtil util);

	

	

}
