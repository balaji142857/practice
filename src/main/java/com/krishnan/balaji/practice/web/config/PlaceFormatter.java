package com.krishnan.balaji.practice.web.config;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.krishnan.balaji.practice.model.a.Place;
import com.krishnan.balaji.practice.service.redbus.PlaceService;

@Component
public class PlaceFormatter implements Formatter<Place>{

	@Autowired
	PlaceService service;
	
	@Override
	public String print(Place object, Locale locale) {
		return (object == null ? "" : object.getDisplay());
	}

	@Override
	public Place parse(String text, Locale locale) throws ParseException {
		if(text == null || text.trim().equals(""))
			return null;
		int place = Integer.parseInt(text);
		return service.get(place);
	}

}
