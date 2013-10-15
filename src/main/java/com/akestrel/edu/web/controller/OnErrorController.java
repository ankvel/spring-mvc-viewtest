package com.akestrel.edu.web.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class OnErrorController {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
 
		ModelAndView model = new ModelAndView("error");
		model.addObject("exception", ex);
		return model;
 
	}
}
