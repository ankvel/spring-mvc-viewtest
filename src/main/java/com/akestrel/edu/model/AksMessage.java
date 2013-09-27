package com.akestrel.edu.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.NONE)
public class AksMessage {

	@XmlElement
	private Long id;

	@Length(min = 3, max = 40)
	@XmlElement
	private String author;

	@Length(min = 3)
	@XmlElement
	private String content;
	
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private DateTime createdDate;
	

	public AksMessage() {
	}

	public AksMessage(Long id, String author, String content, DateTime createdDate) {
		this.id = id;
		this.author = author;
		this.content = content;
		this.createdDate = createdDate;
	}
	
	
	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "AksMessage{" + "id: " + id + "; author: " + author
				+ "; content: " + content + "}";
	}

}
