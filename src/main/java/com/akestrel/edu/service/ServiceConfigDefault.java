package com.akestrel.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.akestrel.edu.dao.DaoConfig;

@Configuration
public class ServiceConfigDefault implements ServiceConfig {

	@Autowired
	private DaoConfig daoConfig;
	
	@Bean
	public AksMessageService aksMessageService() {
		return new AksMessageServiceImpl(daoConfig.aksMessageDao());
	}


}
