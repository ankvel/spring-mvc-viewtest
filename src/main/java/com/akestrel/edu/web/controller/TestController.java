package com.akestrel.edu.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.akestrel.edu.model.AksMessage;
import com.akestrel.edu.service.AksMessageService;

@Controller
public class TestController {

	private AksMessageService ams;
		
	private Logger log = LoggerFactory.getLogger(TestController.class);
	
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
		
		model.addAttribute("aksMessages", ams.getAllMessages());
		return "test";
	}
	
	
	/**
	 * 
	 */
	@RequestMapping(value = {"/test", "/test/**"}, method = RequestMethod.POST)
	public String test(HttpServletRequest request, 
			//@RequestParam(value="picture", required=false) Part picture,
			@Validated AksMessage aksMessage, BindingResult result, Model model, RedirectAttributes attr) {		
		
		
		log.info("Creating aks message");
		
		
		if (result.hasErrors()) {
			model.addAttribute("msg", "Error: " + result.getAllErrors());
			model.addAttribute("msg_type", "error");
			model.addAttribute("aksMessages", ams.getAllMessages());
			return "test";
		} else {
			
			/*if (picture != null) {
				log.info("File name: " + picture.getName());
				log.info("File size: " + picture.getName());
				byte[] content = null;
				
				try {
					InputStream inputStream = picture.getInputStream();
					if (inputStream != null) {
						content = IOUtils.toByteArray(inputStream);						
					} else {
						log.info("File inputstream is null");
					}
				} catch (IOException ioe) {
					log.error("Error saving uploaded file");
				}
				aksMessage.setPicture(content);
			}*/
			
			
			aksMessage.setCreatedDate(new DateTime());
			ams.saveMessage(aksMessage);
			attr.addFlashAttribute("msg", "Saved: " + aksMessage);
			attr.addFlashAttribute("msg_type", "success");
		}
		
		return "redirect:/test";
	}
	
	
	@RequestMapping(value = {"/test/picture/{id}"}, method = RequestMethod.GET)
	@ResponseBody
	public byte[] downloadPicture(@PathVariable("id") Long id) {
		AksMessage aksMessage = ams.getMessage(id);
		
		if (aksMessage != null && aksMessage.getPicture() != null) {
			log.info("Downloading picture for id: {} with size: {}", aksMessage.getId(), 
					aksMessage.getPicture().length);
		}
		return aksMessage.getPicture();
	}
	

}
