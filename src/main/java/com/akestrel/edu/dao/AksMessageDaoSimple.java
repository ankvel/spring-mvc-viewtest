package com.akestrel.edu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import com.akestrel.edu.model.AksMessage;

public class AksMessageDaoSimple implements AksMessageDao {

	private Map<Long, AksMessage> messages = new HashMap<Long, AksMessage>();
	{
		messages.put(
				1L, new AksMessage(1L, "Wong Petrovych", "Hi!", 
				new DateTime(2013, 9, 27, 12, 30, 3), new DateTime()));
		messages.put(2L, new AksMessage(2L, "Wong Petrovych", "How are you?", 
				new DateTime(2013, 9, 27, 12, 31, 15), new DateTime()));
		messages.put(3L, new AksMessage(3L, "Dmitriy I", "Hello!", 
				new DateTime(2013, 9, 27, 12, 32, 0), new DateTime()));
		messages.put(4L, new AksMessage(4L, "Dmitriy I", "I'm fine.", 
				new DateTime(2013, 9, 27, 12, 34, 56), new DateTime()));
		messages.put(5L, new AksMessage(5L, "Dmitriy I", "And how are you?", 
				new DateTime(2013, 9, 27, 12, 35, 18), new DateTime()));
	}

	public AksMessage getMessage(Long id) {
		return messages.get(id);
	}

	public void saveMessage(AksMessage message) {
		if (message.getId() == null) {
			message.setId(genId());
		}

		messages.put(message.getId(), message);
	}

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
