package com.krishnan.balaji.practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;
import org.hibernate.engine.jdbc.internal.Formatter;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

public class SqlLogFormat implements MessageFormattingStrategy {

	private final Formatter formatter = new BasicFormatterImpl();

	@Override
	public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared,
			String sql) {
		return formatter.format(
				LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) 
				+ " | "
				+ connectionId
				+ " | "
				+ category
				+ " | "
				+ sql).trim();
	}
}
