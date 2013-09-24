package com.akestrel.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akestrel.edu.dao.AksMessageDao;
import com.akestrel.edu.model.AksMessage;

@Service
public class AksMessageServiceImpl implements AksMessageService {

	
	private AksMessageDao aksMessageDao; 
	
	public AksMessageServiceImpl(AksMessageDao aksMessageDao) {
		this.aksMessageDao = aksMessageDao;
	}

	public AksMessage getMessage(Long id) {
		return aksMessageDao.getMessage(id);		
	}

	public List<AksMessage> getAllMessages() {		
		return aksMessageDao.getAllMessages();
	}

	public void saveMessage(AksMessage message) {		
		aksMessageDao.saveMessage(message);
	}

}
