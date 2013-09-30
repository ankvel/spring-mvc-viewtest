package com.akestrel.edu.support;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTimeAdapter extends XmlAdapter<String, DateTime> {
	
	private static final String DT_PATTER = "yyyy-MM-dd:hh:mm";

	@Override
	public String marshal(DateTime v) throws Exception {
		DateTimeFormatter fmt = DateTimeFormat.forPattern(DT_PATTER);
		return fmt.print(v);
	}

	@Override
	public DateTime unmarshal(String v) throws Exception {
		DateTimeFormatter fmt = DateTimeFormat.forPattern(DT_PATTER);
		return fmt.parseDateTime(v);
	}
}
