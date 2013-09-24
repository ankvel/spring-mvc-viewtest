package com.akestrel.edu.web.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeHandlerInterceptor implements HandlerInterceptor {

	// static final Logger log = LoggerFactory.getLogger(SomeHandlerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {		
		
		StringBuilder sb = new StringBuilder();
		sb.append("\nIn Interceptor: Request Parameters: [\n");
		for (Enumeration<?> e = request.getParameterNames(); e.hasMoreElements();) {
			Object o = e.nextElement();
			
			sb.append(o.toString()).append(": ").append(request.getParameter(o.toString())).append("\n");			
		}		       
		sb.append("]");
		//log.info(sb.toString());
		//log.info(request.getLocale().toString());
		System.out.println(sb.toString());
		System.out.println(request.getLocale().toString());				
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//log.info("postHandle");

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//log.info("afterCompletion");

	}

}
