package com.akestrel.edu.web;

import java.io.File;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.akestrel.edu.aspect.AspectConfig;
import com.akestrel.edu.dao.DaoConfigDefault;
import com.akestrel.edu.service.ServiceConfigDefault;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {DaoConfigDefault.class, ServiceConfigDefault.class, AspectConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {		
		return new Class<?>[] {WebConfig.class};
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
		
			
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setForceEncoding(true);
		filter.setEncoding("UTF-8");					
		
		return new Filter[] {filter};
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
