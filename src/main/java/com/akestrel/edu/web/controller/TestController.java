package com.akestrel.edu.web.controller;

import java.util.Collections;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.akestrel.edu.model.AksMessage;
import com.akestrel.edu.service.AksMessageService;

@Controller
public class TestController {

	private AksMessageService ams;
		
	public TestController(AksMessageService ams) {
		this.ams = ams;
	}		
	
	@Autowired
	private ServletContext servletContext;

	/**
	 * 
	 */
	@RequestMapping(value = {"/test/{author}/{content}"}, method = RequestMethod.GET)
	public ModelAndView test (@PathVariable String author, @PathVariable String content, AksMessage aksMessage) {
		aksMessage.setAuthor(author);
		ModelAndView mav = new ModelAndView("test");
		return mav;
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test (AksMessage aksMessage, Model model) {		

		
		// TODO delete this
		System.out.println("-----");
		System.out.println("ServletContext.getAttributeNames()");
		System.out.println("-----");
		for (String s : Collections.list(servletContext.getAttributeNames())) {
			System.out.println(s);
		}
		
		model.addAttribute("aksMessages", ams.getAllMessages());
		return "test";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = {"/test", "/test/**"}, method = RequestMethod.POST)
	public String test(HttpServletRequest request, @Validated AksMessage aksMessage, BindingResult result, Model model, RedirectAttributes attr) {		
		
		
		System.out.println(aksMessage.getAuthor());		
		
		
		if (result.hasErrors()) {
			model.addAttribute("msg", "Error: " + result.getAllErrors());
			model.addAttribute("msg_type", "error");
			return "test";
		} else {
			ams.saveMessage(aksMessage);
			attr.addFlashAttribute("msg", "Saved: " + aksMessage);
			attr.addFlashAttribute("msg_type", "success");
		}
		
		return "redirect:/test";
	}
}
