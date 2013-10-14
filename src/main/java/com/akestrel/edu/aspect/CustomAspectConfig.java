package com.akestrel.edu.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy
public class CustomAspectConfig {

	@Bean
	public SomeAspect someAspect() {
		return new SomeAspect();
	}
	
	/*@Bean
	public SystemArchitecture systemArchitecture() {
		return new SystemArchitecture();
	}*/
	
}
