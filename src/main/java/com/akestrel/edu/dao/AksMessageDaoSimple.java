package com.akestrel.edu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.akestrel.edu.model.AksMessage;

public class AksMessageDaoSimple implements AksMessageDao {

	
	private Map<Long, AksMessage> messages = new HashMap<Long, AksMessage>();
	{
		messages.put(
				1L, new AksMessage(1L, "Wong Petrovych", "Hi!", 
				new LocalDate(2013, 9, 27), new DateTime()));
		messages.put(2L, new AksMessage(2L, "Wong Petrovych", "How are you?", 
				new LocalDate(2013, 9, 27), new DateTime()));
		messages.put(3L, new AksMessage(3L, "Dmitriy I", "Hello!", 
				new LocalDate(2013, 9, 27), new DateTime()));
		messages.put(4L, new AksMessage(4L, "Dmitriy I", "I'm fine.", 
				new LocalDate(2013, 9, 27), new DateTime()));
		messages.put(5L, new AksMessage(5L, "Dmitriy I", "And how are you?", 
				new LocalDate(2013, 9, 27), new DateTime()));
	}


	@Override
	public AksMessage getMessage(Long id) {
		return messages.get(id);
	}

	@Override
	public void saveMessage(AksMessage message) {
		if (message.getId() == null) {
			message.setId(genId());
		}

		messages.put(message.getId(), message);
	}

	@Override
	public List<AksMessage> getAllMessages() {
		System.out.println("------------");
		return new ArrayList<AksMessage>(messages.values());
	}

	private Long genId() {
		Long m = 0L;
		for (Long v : messages.keySet()) {
			m = (m > v) ? m : v + 1;
		}
		return m;
	}

}
