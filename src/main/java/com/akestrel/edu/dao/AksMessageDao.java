package com.akestrel.edu.dao;

import java.util.List;

import com.akestrel.edu.model.AksMessage;


public interface AksMessageDao {

	AksMessage getMessage(Long id);
	
	void saveMessage(AksMessage message);		
	
	List<AksMessage> getAllMessages();
}
