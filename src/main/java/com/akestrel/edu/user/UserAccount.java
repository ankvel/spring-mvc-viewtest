package com.akestrel.edu.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class UserAccount implements Serializable {

	private static final long serialVersionUID = -4405244098318097367L;
	
	private Long id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private boolean enabled;
	
	private Set<UserRole> roles = new HashSet<UserRole>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
	
}
