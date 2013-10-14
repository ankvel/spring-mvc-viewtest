package com.akestrel.edu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.akestrel.edu.aksm.AksMessageService;
import com.akestrel.edu.aksm.AksMessageServiceImpl;

@Configuration
public class ServiceConfigCustom implements ServiceConfig {

	@Autowired
	private DaoConfig daoConfig;
	
	@Bean
	public AksMessageService aksMessageService() {
		return new AksMessageServiceImpl(daoConfig.aksMessageDao());
	}


}
