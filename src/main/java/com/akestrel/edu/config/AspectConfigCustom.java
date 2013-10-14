package com.akestrel.edu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.akestrel.edu.aspect.SomeAspect;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfigCustom {

	@Bean
	public SomeAspect someAspect() {
		return new SomeAspect();
	}
	
	/*@Bean
	public SystemArchitecture systemArchitecture() {
		return new SystemArchitecture();
	}*/
	
}
