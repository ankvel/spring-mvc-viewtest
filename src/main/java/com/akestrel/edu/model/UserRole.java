package com.akestrel.edu.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserRole implements Serializable {

	private static final long serialVersionUID = 3927711987815598169L;
	
	private Long id;
	
	private String name;
	
	private Set<UserAccount> accounts = new HashSet<UserAccount>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<UserAccount> accounts) {
		this.accounts = accounts;
	}
	
	
}
