package com.akestrel.edu.web;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.akestrel.edu.aspect.CustomAspectConfig;
import com.akestrel.edu.dao.CustomDaoConfig;
import com.akestrel.edu.security.CustomSecurityConfig;
import com.akestrel.edu.service.CustomServiceConfig;

@Order(1)
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {
				CustomDaoConfig.class, 
				CustomServiceConfig.class, 
				CustomAspectConfig.class,
				CustomSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {		
		return new Class<?>[] {CustomWebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {						
		return new String[] { "/" };				
	}		

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	}	
	
	protected Filter[] getServletFilters() {
		
			
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setForceEncoding(true);
		characterEncodingFilter.setEncoding("UTF-8");
		
		//DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
		
		
		return new Filter[] {characterEncodingFilter/*, delegatingFilterProxy*/};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		
		MultipartConfigElement multipartConfigElement = new  MultipartConfigElement("/");		
		registration.setMultipartConfig(multipartConfigElement);			
	}
	
	
	/*@Override
	protected Filter[] getServletFilters() {
		Filter[] filters = new Filter[] {
				new Filter() {
					
					@Override
					public void init(FilterConfig filterConfig) throws ServletException {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void doFilter(ServletRequest request, ServletResponse response,
							FilterChain chain) throws IOException, ServletException {
						System.out.println("In Filter");
						chain.doFilter(request, response);
					}
					
					@Override
					public void destroy() {
						// TODO Auto-generated method stub
						
					}
				}
		};
		return filters;
	}*/

}
