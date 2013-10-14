package com.akestrel.edu.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SomeAspect {
	
//	@Before("com.akestrel.edu.aspect.SystemArchitecture.dataAccessOperation()")
	@Before("com.akestrel.edu.aspect.SystemArchitecture.businessService()")
	public void doAccessCheck() {		 
		 								    
		System.out.println("In @Before Advice");
	}
	
}
