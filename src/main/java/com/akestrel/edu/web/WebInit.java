package com.akestrel.edu.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.SpringServletContainerInitializer;
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
