package com.krishnan.balaji.practice.web.config;

import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class LocalTimeFormatter implements Formatter<LocalTime>{

	private static final Logger log = LoggerFactory.getLogger(LocalTimeFormatter.class);
	
	@Override
	public String print(LocalTime object, Locale locale) {
		if(object == null)
			log.error("null localTime passed on to formatter");
		else
			log.info("formatting localTime "+object.toString());
		return (object == null ? "" : object.format(DateTimeFormatter.ISO_TIME));
	}

	@Override
	public LocalTime parse(String text, Locale locale) throws ParseException {
		//TODO
		log.info("Attempting to parse "+text +" as localTime");
		if(text == null || text.trim().length()==0)
			return null;
		else
			return LocalTime.parse(text, DateTimeFormatter.ISO_LOCAL_TIME);
	}

}
