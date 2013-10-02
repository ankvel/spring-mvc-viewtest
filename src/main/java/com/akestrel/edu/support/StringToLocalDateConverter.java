package com.akestrel.edu.support;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.core.convert.converter.Converter;

public class StringToLocalDateConverter extends ApplicationObjectSupport implements Converter<String, LocalDate>/*, ConditionalConverter*/ {

	public LocalDate convert(String dateString) {		
		String pattern = getMessageSourceAccessor().getMessage("date_conversion_pattern", LocaleContextHolder.getLocale());		
		return LocalDate.parse(dateString, DateTimeFormat.forPattern(pattern));
	}

	/*@Override
	public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
		targetType.getName();
		System.out.println(sourceType.getAnnotation(DateConv.class) != null);
		return sourceType.getAnnotation(DateConv.class) != null;		
	}*/	
	
}