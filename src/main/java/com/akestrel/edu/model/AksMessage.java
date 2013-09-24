package com.akestrel.edu.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.NONE)
public class AksMessage {

	@XmlElement
	Long id;

	@Length(min = 3, max = 40)
	@XmlElement
	String author;

	@Length(min = 3)
	@XmlElement
	String content;

	public AksMessage() {
	}

	public AksMessage(Long id, String author, String content) {
		this.id = id;
		this.author = author;
		this.content = content;
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
