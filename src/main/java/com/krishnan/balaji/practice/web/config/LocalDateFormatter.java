package com.krishnan.balaji.practice.web.config;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class LocalDateFormatter implements Formatter<LocalDate>{
	private static final Logger log = LoggerFactory.getLogger(LocalDateFormatter.class);
	@Override
	public String print(LocalDate object, Locale locale) {
		return (object == null ? null : object.format(DateTimeFormatter.ISO_DATE));
	}

	@Override
	public LocalDate parse(String text, Locale locale) throws ParseException {
		log.info("converting "+text+" to locadate");
		return (text == null ? null : LocalDate.parse(text, DateTimeFormatter.ISO_DATE));
	}

}
