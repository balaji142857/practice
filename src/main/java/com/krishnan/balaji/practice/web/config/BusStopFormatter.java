package com.krishnan.balaji.practice.web.config;

import java.text.ParseException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.krishnan.balaji.practice.model.a.BusStop;
import com.krishnan.balaji.practice.service.redbus.BusStopService;

@Component
public class BusStopFormatter implements Formatter<BusStop>{

	private static final Logger log = LoggerFactory.getLogger(BusStopFormatter.class);
	@Autowired
	BusStopService busStopService;
		
	@Override
	public String print(BusStop object, Locale locale) {
		log.error("printing busStop "+object);
		if(object == null)
			return "";
		else
			return object.getId()+"";
	}

	@Override
	public BusStop parse(String text, Locale locale) throws ParseException {
		log.error("converting "+text +" to busStop");
		if(text == null || text.trim().length()==0)
			return null;
		long id = Long.parseLong(text);
		log.error("busStop id is "+id);
		return busStopService.getById(id);
	}

}
