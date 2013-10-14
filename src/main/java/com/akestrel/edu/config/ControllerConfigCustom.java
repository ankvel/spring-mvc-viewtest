package com.akestrel.edu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.akestrel.edu.web.controller.AksMessageController;
import com.akestrel.edu.web.controller.FileUpController;
import com.akestrel.edu.web.controller.TestController;

@Configuration
public class ControllerConfigCustom {

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
