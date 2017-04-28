package com.krishnan.balaji.practice.web.config;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.krishnan.balaji.practice.model.a.Bus;
import com.krishnan.balaji.practice.service.redbus.BusOperatorService;

@Component
public class BusFormatter implements Formatter<Bus>{

	@Autowired BusOperatorService service;

	@Override
	public String print(Bus object, Locale locale) {
		return (object == null ? null : object.getRegNumber());
	}

	@Override
	public Bus parse(String text, Locale locale) throws ParseException {
		return (text == null ? null : service.getBus(Long.parseLong(text)));
	}
}
