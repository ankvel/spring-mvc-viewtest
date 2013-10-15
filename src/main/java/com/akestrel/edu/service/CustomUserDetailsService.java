package com.akestrel.edu.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		
		// TODO Do non stub implementation
		
		username = "user";
		String password = "password";
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		GrantedAuthority ga = new GrantedAuthority() {			

			private static final long serialVersionUID = -802862543319346131L;

			@Override
			public String getAuthority() {				
				return "ROLE_USER";
			}
			
			
		};
		authorities.add(ga);
		
		return new User(
				username, 
				password, 
				enabled, 
				accountNonExpired, 
				credentialsNonExpired, 
				accountNonLocked, authorities);
		

	}

}
