package com.krishnan.balaji.practice.web.config;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.krishnan.balaji.practice.model.a.BusType;
@Component
public class BusTypeFormatter implements Formatter<BusType> {

	@Override
	public String print(BusType arg0, Locale arg1) {
		return arg0.name().toUpperCase();
	}

	@Override
	public BusType parse(String arg0, Locale arg1) throws ParseException {
		if (null == arg0 || arg0.trim().length() == 0)
			return null;
		for (BusType type : BusType.values()) {
			if (type.name().equalsIgnoreCase(arg0))
				return type;
		}
		return null;
	}

}
