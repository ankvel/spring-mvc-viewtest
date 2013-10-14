package com.akestrel.edu.user;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		
		// TODO Do non stub implementation
		UserAccount account = new UserAccount();
		account.setId(0L);
		account.setUsername("user");
		account.setPassword("password");
		account.setEmail("user@test.ru");
		Set<UserRole> roles = new HashSet<UserRole>();
		UserRole ur = new UserRole();
		ur.setId(0L);
		ur.setName("USER");
		roles.add(ur);
		account.setRoles(roles);
		
		UserDetails user = new UserDetailsAdapter(account);
				
		
		return user;
	}

}
