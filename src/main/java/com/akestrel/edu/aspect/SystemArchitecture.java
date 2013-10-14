package com.akestrel.edu.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SystemArchitecture {
	
	@Pointcut("within(com.akestrel.edu.web..*)")
	public void inWebLayer() {}
	
	@Pointcut("within(com.akestrel.edu.service..*)")
	public void inServiceLayer() {}
	
	@Pointcut("within(com.akestrel.edu.dao..*)")
	public void inDataAccessLayer() {}
	
	@Pointcut("execution(* com.akestrel.edu.service.*.*(..)) && !target(com.akestrel.edu.service.CustomServiceConfig)")
	public void businessService() {}
	
	@Pointcut("execution(* com.akestrel.edu.dao.*.*(..)) && !target(com.akestrel.edu.dao.CustomDaoConfig)")
	public void dataAccessOperation() {}
	
}
