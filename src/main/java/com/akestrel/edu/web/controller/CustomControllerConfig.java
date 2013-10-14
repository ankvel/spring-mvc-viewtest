package com.akestrel.edu.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.akestrel.edu.dao.DaoConfig;
import com.akestrel.edu.service.ServiceConfig;

@Configuration
public class CustomControllerConfig {

	@Autowired
	private ServiceConfig serviceConfig;

	@Autowired
	private DaoConfig daoConfig;

	@Bean
	public TestController testController() {
		return new TestController(serviceConfig.aksMessageService());
	}

	@Bean
	public AksMessageController aksMessageController() {
		return new AksMessageController(serviceConfig.aksMessageService());
	}
	
	@Bean
	public FileUpController fileUpController() {
		return new FileUpController();
	}	
		
}
