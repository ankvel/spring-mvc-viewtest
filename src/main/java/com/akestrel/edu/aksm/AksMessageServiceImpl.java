package com.akestrel.edu.aksm;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akestrel.edu.aksm.AksMessage;
import com.akestrel.edu.aksm.AksMessageDao;


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
