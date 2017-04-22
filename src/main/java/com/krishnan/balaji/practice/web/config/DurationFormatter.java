package com.krishnan.balaji.practice.web.config;

import java.text.ParseException;
import java.time.Duration;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class DurationFormatter implements Formatter<Duration>{

	@Override
	public String print(Duration arg0, Locale arg1) {
		long time = arg0.toMinutes();
		 return time/24/60 + "days, " + time/60%24 + " hours &" + time%60 +" minutes";
	}

	@Override
	public Duration parse(String arg0, Locale arg1) throws ParseException {
		return null;
	}

}
