package com.akestrel.edu.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter(urlPatterns="/*")
public class SomeFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// System.out.println("In Filter " + request.getParameterNames());
		
		StringBuilder sb = new StringBuilder();
		sb.append("\nIn Filter: Request Parameters: [\n");
		for (Enumeration<?> e = request.getParameterNames(); e.hasMoreElements();) {
			Object o = e.nextElement();
			
			sb.append(o.toString()).append(": ").append(request.getParameter(o.toString())).append("\n");			
		}		       
		sb.append("]");
		
		System.out.println("In Filter: Request Params: " + sb.toString());
		
		
		
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}