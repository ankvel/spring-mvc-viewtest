package com.akestrel.edu.support;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;

public class StringToDateTimeConverter implements Converter<String, DateTime> {
	
	private static final String DEFAULT_DATE_PATTERN = "dd.MM.yyyy";
	private DateTimeFormatter dateFormat;
	private String datePattern = DEFAULT_DATE_PATTERN;

	public StringToDateTimeConverter() {
		init();
	}
	
	public StringToDateTimeConverter(String datePattern) {
		this.datePattern = datePattern;
		init();
	}
	
	public String getDatePattern() {
		return datePattern;
	}

	public DateTime convert(String dateString) {
		return dateFormat.parseDateTime(dateString);
	}
		
	private void init() {
		dateFormat = DateTimeFormat.forPattern(datePattern);
	}
	
}