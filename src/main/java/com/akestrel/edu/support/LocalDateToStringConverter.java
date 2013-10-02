package com.akestrel.edu.support;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.core.convert.converter.Converter;

public class LocalDateToStringConverter extends ApplicationObjectSupport implements Converter<LocalDate, String>/*, ConditionalConverter*/ {

	public String convert(LocalDate date) {		
		String pattern = getMessageSourceAccessor().getMessage("date_conversion_pattern", LocaleContextHolder.getLocale());
		return DateTimeFormat.forPattern(pattern).print(date); 				
	}

	/*@Override
	public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
		return sourceType.getAnnotation(DateConv.class) != null;		
	}*/

}