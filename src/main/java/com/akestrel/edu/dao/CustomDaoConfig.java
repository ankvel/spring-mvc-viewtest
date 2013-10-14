package com.akestrel.edu.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class CustomDaoConfig implements DaoConfig {

	@Bean
	public AksMessageDao aksMessageDao() {			
		return new AksMessageDaoSimple();
	}
}
