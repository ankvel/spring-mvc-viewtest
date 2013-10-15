package com.akestrel.edu.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
	
		auth.userDetailsService(userDetailsService());
	}		
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeUrls()
			.antMatchers("/signup", "/about", "/home", "/error").permitAll()
			.antMatchers("/test/**", "/fileup/**").hasRole("USER")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginUrl("/login")
			.usernameParameter("j_username")
			.passwordParameter("j_password")
			.permitAll();
	}


	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
	
	
}

