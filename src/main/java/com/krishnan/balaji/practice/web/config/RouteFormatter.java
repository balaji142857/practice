package com.krishnan.balaji.practice.web.config;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.krishnan.balaji.practice.model.a.Route;
import com.krishnan.balaji.practice.service.redbus.RouteService;

@Component
public class RouteFormatter implements Formatter<Route>{

	@Autowired RouteService service;
	
	@Override
	public String print(Route object, Locale locale) {
		return (object == null ? null : object.getDisplayName());
	}

	@Override
	public Route parse(String text, Locale locale) throws ParseException {
		return (text == null ? null : service.get(Integer.parseInt(text)));
	}

}
