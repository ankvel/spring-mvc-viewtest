package com.akestrel.edu.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.akestrel.edu.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void registerAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {
	
		//auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		//auth.authenticationProvider(authenticationProvider());
		auth.userDetailsService(userDetailsService());
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
	
	/*@Bean
	public AuthenticationProvider authenticationProvider() {
		return new AbstractUserDetailsAuthenticationProvider() {
			
			@Override
			protected UserDetails retrieveUser(String username,
					UsernamePasswordAuthenticationToken authentication)
					throws AuthenticationException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			protected void additionalAuthenticationChecks(UserDetails userDetails,
					UsernamePasswordAuthenticationToken authentication)
					throws AuthenticationException {
				// TODO Auto-generated method stub
				
			}
		};
			
		
	}*/
}

