package com.akestrel.edu.web.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.akestrel.edu.model.AksMessage;
import com.akestrel.edu.model.AksMessages;
import com.akestrel.edu.service.AksMessageService;

@Controller
@RequestMapping(value = "/aks_message")
public class AksMessageController {

	private final AksMessageService aksMessageService;

	public AksMessageController(AksMessageService aksMessageService) {
		this.aksMessageService = aksMessageService;
	}

	@RequestMapping(value = "/messages", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public AksMessages getMessages() {
		return new AksMessages(aksMessageService.getAllMessages());
	}
	
	@RequestMapping(value = "/messages/{code}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public AksMessage getAksMessage(@PathVariable String code) {
		return aksMessageService.getMessage(Long.valueOf(code));
	}
	

}
