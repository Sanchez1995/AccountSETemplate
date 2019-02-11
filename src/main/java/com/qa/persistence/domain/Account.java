package com.qa.persistence.domain;

public class Account {

	private Long id;

	private String first_name;
	private String last_name;
	private String account_number;

	public Account() {

	}

	public Account(String account_number, String first_name, String last_name) {
		super();

		this.account_number = account_number;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

}
