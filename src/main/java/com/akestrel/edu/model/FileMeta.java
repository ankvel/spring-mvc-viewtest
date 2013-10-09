package com.akestrel.edu.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

// ignore "bytes" when return json format
@JsonIgnoreProperties({ "bytes" })
public class FileMeta {

	private Long id;
	private String fileName;
	private String fileSize;
	private String fileType;

	private byte[] bytes;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

}