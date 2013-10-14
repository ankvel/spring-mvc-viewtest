package com.akestrel.edu.aksm;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class AksMessages {

	@XmlElement
	private List<AksMessage> aksMessage;

	public AksMessages() {		
	}
	
	public AksMessages (List<AksMessage> aksMessage) {
		this.aksMessage = aksMessage;
	}
		
	public List<AksMessage> getAksMessage() {
		return aksMessage;
	}

	public void setAksMessage(List<AksMessage> aksMessage) {
		this.aksMessage = aksMessage;
	}

}
