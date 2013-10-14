package com.akestrel.edu.aksm;

import java.util.List;

import com.akestrel.edu.aksm.AksMessage;


public interface AksMessageDao {

	AksMessage getMessage(Long id);
	
	void saveMessage(AksMessage message);		
	
	List<AksMessage> getAllMessages();
}
