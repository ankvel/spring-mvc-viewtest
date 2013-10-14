package com.akestrel.edu.aksm;

import java.util.List;

import com.akestrel.edu.aksm.AksMessage;


public interface AksMessageService {

	AksMessage getMessage(Long id);
	
	List<AksMessage> getAllMessages();
	
	void saveMessage(AksMessage message);
	
}
