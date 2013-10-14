package com.akestrel.edu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.akestrel.edu.aksm.AksMessageDao;
import com.akestrel.edu.aksm.AksMessageDaoSimple;


@Configuration
public class DaoConfigCustom implements DaoConfig {

	@Bean
	public AksMessageDao aksMessageDao() {			
		return new AksMessageDaoSimple();
	}
}
