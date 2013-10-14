package com.akestrel.edu.service;

import java.util.List;

import com.akestrel.edu.model.AksMessage;


public interface AksMessageService {

	AksMessage getMessage(Long id);
	
	List<AksMessage> getAllMessages();
	
	void saveMessage(AksMessage message);
	
}
