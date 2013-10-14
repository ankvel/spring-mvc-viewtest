package com.akestrel.edu.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsAdapter implements UserDetails {

	private static final long serialVersionUID = 4258402019572838005L;

	private UserAccount account;
	
	public UserDetailsAdapter(UserAccount account) {
		this.account = account;
	}
			
	public UserAccount getAccount() {
		return account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (final UserRole ur: account.getRoles()) {
			authorities.add(new GrantedAuthority() {

				private static final long serialVersionUID = -7373751860490730642L;

				@Override
				public String getAuthority() {					
					return ur.getName();
				}
			});
		}
		
		
		return null;
	}
		
	@Override
	public String getPassword() {		
		return account.getEmail();
	}

	@Override
	public String getUsername() {		
		return account.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
